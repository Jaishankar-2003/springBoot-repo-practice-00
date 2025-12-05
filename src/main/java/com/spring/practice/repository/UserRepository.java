// src/main/java/com/spring/practice/repository/UserRepository.java
package com.spring.practice.repository;

import com.spring.practice.entity.userEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<userEntity, Long>
{
    Optional<userEntity> findByUsername(String username);
}
