package com.yuba.cafe;

import com.yuba.cafe.fakeData.FakeData;
import com.yuba.cafe.model.*;
import com.yuba.cafe.reporsitory.*;
import com.yuba.cafe.service.AddressService;
import com.yuba.cafe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class CafeApplication {

    @Autowired
    private SnackRepo snackRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private AddressRepo addressRepo;
    @Autowired
    private FilterRepo filterRepo;
    @Autowired
    private UserService userService;
    @Autowired
    private AddressService addressService;

    public static void main(String[] args) {
        SpringApplication.run(CafeApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void initData() {

        if (userService.findByEmail("mahvish@gmail.com").isPresent()) return;

        List<Snack> snacks = FakeData.snacks();
        snackRepo.saveAll(snacks);

        List<Category> categories = FakeData.categories();
        categoryRepo.saveAll(categories);

        userService.signup(new User(1L, "Mahvish Jahan", "user1@gmail.com", "pass123", "F", "USER"));
        userService.signup(new User(2L, "Ali", "user2@gmail.com", "pass123", "M", "USER"));
        userService.signup(new User(3L, "Cafe Manager 1", "manager1@gmail.com", "pass123", "F", "MANAGER"));
        userService.signup(new User(4L, "Cafe Manager 2", "manager2@gmail.com", "pass123", "F", "MANAGER"));

        Optional<User> byEmail = userService.findByEmail("manager@gmail.com");
        if (byEmail.isPresent()) {
            User manager = byEmail.get();
            manager.setRole(Role.MANAGER.name());

            userRepo.save(manager);
        }

        List<Filter> filters = FakeData.filters();
        filterRepo.saveAll(filters);
    }
}
