package com.spring.practice.entity;


import jakarta.persistence.*;

@Entity
@Table(name= "user")
public class userEntity
{
    public userEntity()
    {
        super();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;


    public userEntity(Long id, String name, String email)
    {
        this.id = id;
        this.name = name;
        this.email = email;
    }


}
