package com.yuba.cafe.contoller;

import com.yuba.cafe.jwt.JwtTokenUtil;
import com.yuba.cafe.model.User;
import com.yuba.cafe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserProfileController {

    @Autowired
    private JwtTokenUtil jwtUtil;
    @Autowired
    private UserService userService;

    @GetMapping("/api/secure/profile")
    public ResponseEntity<?> cart(@RequestHeader("Authorization") String authHeader) {

        System.out.println("User");

        Long userId = jwtUtil.getUserIdUsingAuthHeader(authHeader);
        Optional<User> optionalUser = userService.findById(userId);
        if (optionalUser.isPresent()) return ResponseEntity.ok(optionalUser.get());

        return ResponseEntity.notFound().build();
    }
}
