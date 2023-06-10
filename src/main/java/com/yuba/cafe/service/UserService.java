package com.yuba.cafe.service;

import com.yuba.cafe.jwt.JwtTokenUtil;
import com.yuba.cafe.model.Address;
import com.yuba.cafe.model.Role;
import com.yuba.cafe.model.User;
import com.yuba.cafe.reporsitory.AddressRepo;
import com.yuba.cafe.reporsitory.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private AddressRepo addressRepo;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    public User signup(User user) {

        if (findByEmail(user.getEmail()).isPresent()) return null;

        user.setGender("F");
        user.setRole(Role.USER.name());

        User save = userRepo.save(user);

        Address address = new Address();
        address.setName("Yuba Cafe");
        address.setAddressDetail("Integral University");
        address.setPinCode(226016L);
        address.setIsCurrent(true);
        address.setUserId(save.getId());
        addressRepo.save(address);

        return save;
    }

    public List<User> list() {
        List<User> list = new ArrayList<>();

        for (User user : userRepo.findAll()) {
            list.add(user);
        }

        return list;
    }

    public String signIn(String email, String password) {
        Optional<User> byEmailAndPassword = userRepo.findByEmailAndPassword(email, password);

        if (byEmailAndPassword.isPresent()) {
            User user = byEmailAndPassword.get();
            return jwtTokenUtil.generateAccessToken(user);
        }

        return null;
    }

    public Optional<User> findById(Long userId) {
        return userRepo.findById(userId);
    }

    public Optional<User> findByEmail(String emailId) {
        return userRepo.findByEmail(emailId);
    }
}
