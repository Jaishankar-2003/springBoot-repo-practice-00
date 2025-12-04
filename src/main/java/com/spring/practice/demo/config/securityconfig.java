package com.spring.practice.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.DefaultSecurityFilterChain;

@Configuration
@EnableWebSecurity
public class securityconfig
{
    @Bean
    public DefaultSecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {

        http.authorizeHttpRequests(authz ->
                        authz
                                .requestMatchers(HttpMethod.POST, "/api/users").permitAll()
                                .requestMatchers("/api/users/**").authenticated()
                                .requestMatchers("/home").permitAll()
                                .anyRequest().permitAll()
                ).formLogin(form -> form.permitAll().defaultSuccessUrl("/dashboard"))
                .csrf(csrf -> csrf.disable());
        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailedService(BCryptPasswordEncoder passwordEncoder)
    {
        UserDetails user = User.withUsername("test").password(passwordEncoder.encode("test")).roles("user").build();
        UserDetails admin = User.withUsername("admin").password(passwordEncoder.encode("admin")).roles("admin").build();

        return new InMemoryUserDetailsManager(user , admin);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }


}
