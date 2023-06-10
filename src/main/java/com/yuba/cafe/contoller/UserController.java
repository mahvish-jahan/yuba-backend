package com.yuba.cafe.contoller;

import com.yuba.cafe.dto.TokenDto;
import com.yuba.cafe.model.User;
import com.yuba.cafe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/api/public/user/signup")
    public ResponseEntity<?> signup(@RequestBody User user) {
        User createdUser = userService.signup(user);
        if (createdUser == null) {
            return ResponseEntity.badRequest().build();
        }

        String email = user.getEmail();
        String password = user.getPassword();

        String token = userService.signIn(email, password);

        TokenDto tokenDto = new TokenDto();
        tokenDto.setToken(token);

        return ResponseEntity.ok(tokenDto);
    }

    @PostMapping("/api/public/user/signin")
    public ResponseEntity<TokenDto> signIn(@RequestBody User user) {

        String email = user.getEmail();
        String password = user.getPassword();

        String token = userService.signIn(email, password);
        if (token == null) {
            return ResponseEntity.notFound().build();
        }


        TokenDto tokenDto = new TokenDto();
        tokenDto.setToken(token);

        return ResponseEntity.ok(tokenDto);
    }

    @GetMapping("/api/secure/user/list")
    public ResponseEntity<?> list() {
        List<User> list = userService.list();
        return ResponseEntity.ok(list);
    }
}
