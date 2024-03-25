package com.example.springcore5.login.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginHomeController {

    @GetMapping
    public String loginHome() {
        return "redirect:/items";
    }
}
