package com.yuba.cafe.contoller;

import com.yuba.cafe.jwt.JwtTokenUtil;
import com.yuba.cafe.model.Address;
import com.yuba.cafe.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/secure/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @Autowired
    private JwtTokenUtil jwtUtil;

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestHeader("Authorization") String authHeader, @RequestBody Address address) {

        Long userId = jwtUtil.getUserIdUsingAuthHeader(authHeader);
        address.setUserId(userId);

        Address createdAddress = addressService.add(address);
        if (createdAddress == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(createdAddress);
    }

    @GetMapping("/list/{userId}")
    public ResponseEntity<?> list(@PathVariable Long userId) {
        List<Address> list = addressService.list(userId);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/currentAddress")
    public ResponseEntity<?> currentAddress(@RequestHeader("Authorization") String authHeader) {
        System.out.println("Current address");
        Long userId = jwtUtil.getUserIdUsingAuthHeader(authHeader);
        Address address = addressService.currentAddress(userId);
        return ResponseEntity.ok(address);
    }
}
