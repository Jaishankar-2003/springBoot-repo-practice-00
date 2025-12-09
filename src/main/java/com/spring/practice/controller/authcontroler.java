package com.spring.practice.controller;


import com.spring.practice.entity.userEntity;
import com.spring.practice.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController()
@RequestMapping("/auth")
public class authcontroler
{

    @Autowired
    private AuthenticationManager authmanager;

    @Autowired
    private JwtUtil jwtUtil;


    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody userEntity user)
    {
        try {
            // auth user
            Authentication authentication = authmanager
                    .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));


            UserDetails userDetails = (UserDetails) authentication.getPrincipal();


            String token = jwtUtil.generatetoken(userDetails);

            return ResponseEntity.ok(Map.of("token", token));

        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error","Invalid username or password"));
        }

    }
}
