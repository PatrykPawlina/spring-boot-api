package com.java.springbootapplication.api;

import com.java.springbootapplication.dao.entity.User;
import com.java.springbootapplication.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/users")
public class UserApi {

    private UserManager userManager;

    @Autowired
    public UserApi(UserManager userManager) {
        this.userManager = userManager;
    }

    @GetMapping("/all")
    public Iterable<User> findAllUsers() {
        return userManager.findAllUsers();
    }

    @GetMapping("/id")
    public Optional<User> findAllUserByIdWithParam(@RequestParam Long id) {
        return userManager.findUserById(id);
    }

    @GetMapping("/id/{id}")
    public Optional<User> findAllUserById(@PathVariable("id") Long id) {
        return userManager.findUserById(id);
    }

    @GetMapping("/amounts")
    public Long countUsers() {
        return userManager.countUsers();
    }
}