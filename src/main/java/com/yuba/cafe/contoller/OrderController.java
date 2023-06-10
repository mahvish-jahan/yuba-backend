package com.yuba.cafe.contoller;

import com.yuba.cafe.jwt.JwtTokenUtil;
import com.yuba.cafe.model.order.Order;
import com.yuba.cafe.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/secure/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private JwtTokenUtil jwtUtil;

    @GetMapping
    public ResponseEntity<?> allOrders(@RequestHeader("Authorization") String authHeader) {

        Long userId = jwtUtil.getUserIdUsingAuthHeader(authHeader);

        List<Order> orderList = orderService.allOrders(userId);

        return ResponseEntity.ok(orderList);
    }

    @GetMapping("/accept/{orderId}")
    public ResponseEntity<?> acceptOrder(@RequestHeader("Authorization") String authHeader, @PathVariable Long orderId) {
        Long userId = jwtUtil.getUserIdUsingAuthHeader(authHeader);
        Order order = orderService.acceptOrder(userId, orderId);
        return ResponseEntity.ok(order);
    }

    @GetMapping("/reject/{orderId}")
    public ResponseEntity<?> rejectOrder(@RequestHeader("Authorization") String authHeader, @PathVariable Long orderId) {
        Long userId = jwtUtil.getUserIdUsingAuthHeader(authHeader);
        Order order = orderService.rejectOrder(userId, orderId);
        return ResponseEntity.ok(order);
    }
}
