package com.java.springbootapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LoginPageController {

    @GetMapping("login")
    public String getLoginView() {
        return "login";
    }
}