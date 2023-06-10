package com.yuba.cafe.contoller;

import com.yuba.cafe.fakeData.FakeData;
import com.yuba.cafe.fakeData.SnackCollection;
import com.yuba.cafe.jwt.JwtTokenUtil;
import com.yuba.cafe.model.cart.Cart;
import com.yuba.cafe.model.cart.CartLine;
import com.yuba.cafe.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;

@RestController()
public class CartController {

    @Autowired
    private JwtTokenUtil jwtUtil;

    @Autowired
    private CartService cartService;

    @GetMapping("/api/secure/cart")
    public ResponseEntity<Set<CartLine>> cart(@RequestHeader("Authorization") String authHeader) {

        Long userId = jwtUtil.getUserIdUsingAuthHeader(authHeader);

        Optional<Cart> byUserId = cartService.findByUserId(userId);

        System.out.println("Cart");

        if (byUserId.isPresent()) {
            return ResponseEntity.ok(byUserId.get().getCartLines());
        } else {
            return ResponseEntity.ok(Collections.emptySet());
        }
    }

    @GetMapping("/api/secure/cart/inspired")
    public ResponseEntity<?> cartInspired() {
        SnackCollection inspiredByCart = FakeData.inspiredByCart();

        System.out.println("Cart Inspired");
        return ResponseEntity.ok(inspiredByCart);
    }

    @GetMapping("/api/secure/addToCart/{snackId}")
    public ResponseEntity<Set<CartLine>> addToCart(
            @RequestHeader("Authorization") String authHeader,
            @PathVariable Long snackId
    ) {

        Long userId = jwtUtil.getUserIdUsingAuthHeader(authHeader);
        boolean addToCart = cartService.addToCart(userId, snackId);
        if (addToCart) {

            Optional<Cart> byUserId = cartService.findByUserId(userId);

            if (byUserId.isPresent()) {
                return ResponseEntity.ok(byUserId.get().getCartLines());
            } else {
                return ResponseEntity.ok(Collections.emptySet());
            }
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/api/secure/removeFromCart/{snackId}")
    public ResponseEntity<Set<CartLine>> removeFromCart(
            @RequestHeader("Authorization") String authHeader,
            @PathVariable Long snackId
    ) {

        System.out.println("removeFromCart");

        Long userId = jwtUtil.getUserIdUsingAuthHeader(authHeader);
        boolean addToCart = cartService.removeFromCart(userId, snackId);
        if (addToCart) {

            Optional<Cart> byUserId = cartService.findByUserId(userId);

            if (byUserId.isPresent()) {
                return ResponseEntity.ok(byUserId.get().getCartLines());
            } else {
                return ResponseEntity.ok(Collections.emptySet());
            }
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/api/secure/addQuantity/{snackId}")
    public ResponseEntity<?> addQuantity(
            @RequestHeader("Authorization") String authHeader,
            @PathVariable Long snackId
    ) {

        Long userId = jwtUtil.getUserIdUsingAuthHeader(authHeader);

        boolean success = cartService.addQuantity(userId, snackId);

        System.out.println("Cart Increase Count");

        if (success) {
            Optional<Cart> byUserId = cartService.findByUserId(userId);

            if (byUserId.isPresent()) {
                return ResponseEntity.ok(byUserId.get().getCartLines());
            } else {
                return ResponseEntity.ok(Collections.emptySet());
            }
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/api/secure/subQuantity/{snackId}")
    public ResponseEntity<?> subQuantity(
            @RequestHeader("Authorization") String authHeader,
            @PathVariable Long snackId
    ) {

        Long userId = jwtUtil.getUserIdUsingAuthHeader(authHeader);

        boolean success = cartService.subQuantity(userId, snackId);

        System.out.println("Cart Decrease Count");

        if (success) {
            Optional<Cart> byUserId = cartService.findByUserId(userId);

            if (byUserId.isPresent()) {
                return ResponseEntity.ok(byUserId.get().getCartLines());
            } else {
                return ResponseEntity.ok(Collections.emptySet());
            }
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/api/secure/checkout")
    public ResponseEntity<?> checkout(
            @RequestHeader("Authorization") String authHeader) {

        Long userId = jwtUtil.getUserIdUsingAuthHeader(authHeader);

        boolean success = cartService.checkout(userId);

        if (success) {
            Optional<Cart> byUserId = cartService.findByUserId(userId);

            if (byUserId.isPresent()) {
                return ResponseEntity.ok(byUserId.get().getCartLines());
            } else {
                return ResponseEntity.ok(Collections.emptySet());
            }
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
