package com.spring.practice.controller;

import com.spring.practice.entity.userEntity;
import com.spring.practice.exception.ResourceNotFound;
import com.spring.practice.model.user;
import com.spring.practice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
    @RequestMapping("/api/users")
    public class user_controller
    {
        @Autowired
        public UserRepository userRepository;

//        @GetMapping
//        public String getuers()
//        {
//            return "hello Jvlcode";
//        }
        @GetMapping
        //public List<user> getuser()
        public List<userEntity> getusers()
        {
//            return Arrays.asList(new user(1L,"john","john@gmail.com",12L),
//                    new user(2L,"joe","jo@gmail.com" , 22L),
//            new user(2L,"joy","joi@gmail.com" , 22L)
//            );
            return  userRepository.findAll();
        }


        @PostMapping
        public userEntity createUser(@RequestBody userEntity user)
        {
            System.out.println("user data: " + user.getName()+"," + user.getEmail());
            return userRepository.save(user);

        }
        
        
        @GetMapping("/{id}")
        public userEntity getuserById(@PathVariable Long id)
        {
            //return Optional.ofNullable(userRepository.findById(id).orElseThrow(() -> new ResourceNotFound("user not found " + id)));
            return userRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFound("User not found " + id));
        }



    }


