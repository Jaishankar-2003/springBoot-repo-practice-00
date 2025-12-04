package com.spring.practice.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.web.DefaultSecurityFilterChain;

@Configuration
@EnableWebSecurity
public class securityconfig
{
    @Bean
    public DefaultSecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {

        http.authorizeHttpRequests(authz ->
                authz.requestMatchers("/api/users/**").authenticated().requestMatchers("/home").permitAll()
                ).formLogin(AbstractAuthenticationFilterConfigurer::permitAll);



        return http.build();



    }


}
