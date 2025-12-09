package com.spring.practice.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil
{
    private static final String SECRET_KEY_STRING = "c53feef2f939182a0563274105d97de0eafb9b16988533a5d7c354ee1fa7ae6f";

    private final SecretKey SECRET_KEY = Keys.hmacShaKeyFor(SECRET_KEY_STRING.getBytes());


    public String generatetoken(UserDetails userDetails)
    {
        return String.valueOf(Jwts.builder()
                .subject(userDetails.getUsername())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(SECRET_KEY,Jwts.SIG.HS256));
    }
}
