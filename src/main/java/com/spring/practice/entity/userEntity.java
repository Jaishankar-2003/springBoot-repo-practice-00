package com.spring.practice.entity;

//import lombok.NoArgsConstructor;
//import lombok.AllArgsConstructor;
//import lombok.Data;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name= "user")
public class userEntity
{
    public userEntity()
    {

    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @Column(unique = true)
    private String username;
    private String password;

    @JsonProperty("DoB")
    private Integer dob;



    public userEntity(Long id, String name, String email , Integer DoB , String username , String password)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.username = username;
        this.password = password;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Integer getDob() { return (dob); }
    public void setDob(Integer dob) { this.dob = dob; }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }




}
