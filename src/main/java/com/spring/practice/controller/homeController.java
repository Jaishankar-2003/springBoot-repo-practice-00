package com.spring.practice.controller;

import com.spring.practice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class homeController
{
//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    public UserRepository userRepository;


    @GetMapping("/home")
    public String getHomepage()
    {
        return "welcome to home page ";
    }

    @GetMapping("/dashboard")
    public String getDashboard()
    {
        return "Login success";
    }

    @GetMapping("/test")
    public String gettest()
    {
        return "permit default success is pass";
    }

}
