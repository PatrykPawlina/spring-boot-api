package com.java.springbootapplication.api;

import com.java.springbootapplication.entity.User;
import com.java.springbootapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/users")
public class UserApi {

    private UserService userService;

    @Autowired
    public UserApi(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public Iterable<User> findAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/id")
    public Optional<User> findAllUserByIdWithParam(@RequestParam Long id) {
        return userService.findUserById(id);
    }

    @GetMapping("/id/{id}")
    public Optional<User> findAllUserById(@PathVariable("id") Long id) {
        return userService.findUserById(id);
    }

    @GetMapping("/amounts")
    public Long countUsers() {
        return userService.countUsers();
    }
}