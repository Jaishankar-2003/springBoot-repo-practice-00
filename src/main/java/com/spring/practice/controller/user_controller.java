package com.spring.practice.controller;

import com.spring.practice.model.user;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
    @RequestMapping("/api/users")
    public class user_controller
    {
//        @GetMapping
//        public String getuers()
//        {
//            return "hello Jvlcode";
//        }
        @GetMapping
        public List<user> getuers()
        {
            return Arrays.asList(new user(1L,"john","john@gmail.com",12L),
                    new user(2L,"joe","jo@gmail.com" , 22L),
            new user(2L,"joy","joi@gmail.com" , 22L)
            );
        }
    }


