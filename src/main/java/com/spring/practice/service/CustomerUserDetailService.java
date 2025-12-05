package com.spring.practice.service;

import com.spring.practice.entity.userEntity;
import com.spring.practice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomerUserDetailService implements UserDetailsService
{
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        // fetch user from database

        userEntity user =  userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("user not found"));


        return new User(user.getUsername(), user.getPassword(),null);
    }
}
