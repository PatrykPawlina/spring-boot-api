package com.java.springbootapplication.api;

import com.java.springbootapplication.dao.entity.User;
import com.java.springbootapplication.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public Iterable<User> findAll() {
        return userManager.findAllUsers();
    }

    @GetMapping("id")
    public Optional<User> findAllUsersByIdWithParam(@RequestParam Long id) {
        return userManager.findUsersById(id);
    }
}