package com.garrybest.web;

import com.garrybest.domain.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @PostMapping("/user")
    public User user(@RequestBody User user) {
        return user;
    }
}
