package com.yuba.cafe.contoller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public/health")
public class Health {

    @GetMapping
    public ResponseEntity<?> health() {
        return ResponseEntity.ok("OK");
    }
}
