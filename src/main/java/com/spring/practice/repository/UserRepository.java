// src/main/java/com/spring/practice/repository/UserRepository.java
package com.spring.practice.repository;

import com.spring.practice.entity.userEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends JpaRepository<userEntity, Long>
{

}
