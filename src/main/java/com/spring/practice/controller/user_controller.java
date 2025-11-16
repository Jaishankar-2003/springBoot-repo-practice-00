package com.spring.practice.controller;

import com.spring.practice.entity.userEntity;
import com.spring.practice.exception.ResourceNotFound;
import com.spring.practice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

        @PutMapping("/{id}")
        public userEntity updateuser(@PathVariable Long id , @RequestBody userEntity user)
        {
          userEntity userdata =  userRepository.findById(id).orElseThrow(() -> new ResourceNotFound("User not found " + id));

          userdata.setEmail(user.getEmail());
            userdata.setName(user.getName());
            userdata.setDob(user.getDob());
            userRepository.save(userdata);
            return userdata;
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Object> deleteuser(@PathVariable Long id)
        {
           userEntity userdata =  userRepository.findById(id).orElseThrow(() -> new ResourceNotFound("User not found " + id));
           userRepository.delete(userdata);
           return ResponseEntity.ok().build();

        }



    }


