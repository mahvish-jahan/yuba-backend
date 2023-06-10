package com.yuba.cafe.service;

import com.yuba.cafe.exception.GenericExceptionMessage;
import com.yuba.cafe.model.Role;
import com.yuba.cafe.model.User;
import com.yuba.cafe.model.order.Order;
import com.yuba.cafe.model.order.OrderState;
import com.yuba.cafe.reporsitory.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderService {

    @Autowired
    private SnackService snackService;
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private UserService userService;


    public Order add(Order order) {
        return orderRepo.save(order);
    }

    public List<Order> allOrders(Long userId) {

        Optional<User> byId = userService.findById(userId);
        if (byId.isEmpty()) return Collections.emptyList();

        if (byId.get().getRole().equals(Role.MANAGER.name())) {
            return orderRepo.findAll();
        }

        return orderRepo.findAllByUserIdOrderByIdDesc(userId);
    }

    public Order acceptOrder(Long userId, Long orderId) {

        Optional<User> userOpt = userService.findById(userId);
        if (userOpt.isEmpty() || !userOpt.get().getRole().equals(Role.MANAGER.name())) {
            throw new GenericExceptionMessage("Only Manager can accept the order");
        }

        Optional<Order> byId = orderRepo.findById(orderId);
        if (byId.isEmpty()) {
            throw new GenericExceptionMessage("Order not found");
        }

        Order order = byId.get();
        order.setOrderState(OrderState.ACCEPTED);
        return orderRepo.save(order);
    }

    public Order rejectOrder(Long userId, Long orderId) {

        Optional<User> userOpt = userService.findById(userId);
        if (userOpt.isEmpty() || !userOpt.get().getRole().equals(Role.MANAGER.name())) {
            throw new GenericExceptionMessage("Only Manager can accept the order");
        }

        Optional<Order> byId = orderRepo.findById(orderId);
        if (byId.isEmpty()) {
            throw new GenericExceptionMessage("Order not found");
        }

        Order order = byId.get();
        order.setOrderState(OrderState.REJECTED);
        return orderRepo.save(order);
    }
}
