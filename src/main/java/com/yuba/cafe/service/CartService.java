package com.yuba.cafe.service;

import com.yuba.cafe.exception.GenericExceptionMessage;
import com.yuba.cafe.exception.StockUnavailableException;
import com.yuba.cafe.model.Address;
import com.yuba.cafe.model.Role;
import com.yuba.cafe.model.Snack;
import com.yuba.cafe.model.User;
import com.yuba.cafe.model.cart.Cart;
import com.yuba.cafe.model.cart.CartLine;
import com.yuba.cafe.model.order.Order;
import com.yuba.cafe.model.order.OrderItem;
import com.yuba.cafe.model.order.OrderState;
import com.yuba.cafe.reporsitory.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CartService {

    @Autowired
    private CartRepo cartRepo;
    @Autowired
    private UserService userService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private SnackService snackService;

    public Cart add(Cart cart) {
        return cartRepo.save(cart);
    }

    public Optional<Cart> findByUserId(Long userId) {
        return cartRepo.findByUserId(userId);
    }

    public boolean addToCart(Long userId, Long snackId) {
        Optional<Cart> byUserId = findByUserId(userId);

        Cart cart;
        if (byUserId.isEmpty()) {
            Cart newCart = new Cart();
            newCart.setUserId(userId);
            cart = cartRepo.save(newCart);
        } else {
            cart = byUserId.get();
        }

        Optional<Snack> byId = snackService.findById(snackId);
        if (byId.isEmpty()) {
            return false;
        }

        Snack snack = byId.get();

        // check if snack already in cart, if yes increase quantity
        if (Objects.nonNull(cart.getCartLines())) {
            Set<CartLine> filteredLines = cart.getCartLines().stream().filter(cl -> cl.getSnack().getId().equals(snackId)).collect(Collectors.toSet());
            if (filteredLines.size() > 0) {
                return addQuantity(userId, snackId);
            }
        }

        CartLine cartLine = new CartLine();
        cartLine.setSnack(snack);
        cartLine.setCount(1L);

        Set<CartLine> cartLines = cart.getCartLines();
        if (cartLines == null) cartLines = new HashSet<>();

        cartLines.add(cartLine);
        cart.setCartLines(cartLines);

        cartRepo.save(cart);

        return true;
    }

    public boolean removeFromCart(Long userId, Long snackId) {
        Optional<Cart> byUserId = findByUserId(userId);

        Cart cart;
        if (byUserId.isEmpty()) {
            return true;
        } else {
            cart = byUserId.get();
        }


        Set<CartLine> cartLines = cart.getCartLines();
        if (cartLines == null) return false;

        Set<CartLine> filteredCartLines = cartLines.stream().filter(cl -> !cl.getSnack().getId().equals(snackId)).collect(Collectors.toSet());

        cart.setCartLines(filteredCartLines);

        cartRepo.save(cart);

        return true;
    }

    public boolean addQuantity(Long userId, Long snackId) {
        Optional<Cart> byUserId = this.findByUserId(userId);
        if (byUserId.isEmpty()) return false;

        Cart cart = byUserId.get();
        Optional<CartLine> optionalCartLine = cart.getCartLines().stream().filter(cl -> cl.getSnack().getId().equals(snackId)).findFirst();
        if (optionalCartLine.isEmpty()) return false;

        optionalCartLine.get().setCount(optionalCartLine.get().getCount() + 1);

        cartRepo.save(cart);
        return true;
    }

    public boolean subQuantity(Long userId, Long snackId) {
        Optional<Cart> byUserId = this.findByUserId(userId);
        if (byUserId.isEmpty()) return false;

        Cart cart = byUserId.get();
        Optional<CartLine> optionalCartLine = cart.getCartLines().stream().filter(cl -> cl.getSnack().getId().equals(snackId)).findFirst();
        if (optionalCartLine.isEmpty()) return false;

        if (optionalCartLine.get().getCount() <= 1) {
            cart.getCartLines().remove(optionalCartLine.get());
        } else {
            optionalCartLine.get().setCount(optionalCartLine.get().getCount() - 1);
        }

        cartRepo.save(cart);
        return true;
    }

    public boolean checkout(Long userId) {

        Optional<User> byId = userService.findById(userId);
        if (byId.isEmpty()) return false;
        User user = byId.get();

        if (user.getRole().equals(Role.MANAGER.name())) {
            throw new GenericExceptionMessage("Manager can't place order");
        }

        Optional<Cart> byUserId = this.findByUserId(userId);
        if (byUserId.isEmpty()) return false;

        Cart cart = byUserId.get();

        Set<CartLine> cartLines = cart.getCartLines();
        if (cartLines.isEmpty()) return false;

        double totalAmount = 0;

        for (CartLine cl : cartLines) {
            Long count = cl.getCount();
            Snack snack = cl.getSnack();

            Optional<Snack> snackOptional = snackService.findById(snack.getId());
            if (snackOptional.isEmpty()) {
                throw new StockUnavailableException(snack.getName() + " is not available");
            } else if (snackOptional.get().getAvailable() < count) {
                throw new StockUnavailableException(snack.getName() + " stock is not sufficient");
            }

            Long price = snack.getPrice();

            totalAmount += count * price;
        }

        Address address = addressService.currentAddress(userId);
        if (address == null) return false;

        Set<OrderItem> orderItems = new HashSet<>();

        cartLines.forEach(cl -> {
            OrderItem orderItem = new OrderItem();
            orderItem.setCount(cl.getCount());
            orderItem.setSnack(cl.getSnack());

            orderItems.add(orderItem);

        });

        Order order = new Order();
        order.setTotalAmount(totalAmount);
        order.setUser(user);
        order.setAddress(address);
        order.setOrderItems(orderItems);
        order.setOrderState(OrderState.PENDING);

        Order savedOrder = orderService.add(order);

        cart.setCartLines(Collections.emptySet());

        cartRepo.save(cart);

        updateStock(savedOrder);

        return true;
    }

    private void updateStock(Order savedOrder) {

        for (OrderItem orderItem : savedOrder.getOrderItems()) {
            Long count = orderItem.getCount();
            Snack snack = orderItem.getSnack();
            snack.setAvailable(snack.getAvailable() - count);

            snackService.save(snack);
        }
    }
}
