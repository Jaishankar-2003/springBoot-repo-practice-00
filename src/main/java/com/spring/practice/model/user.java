package com.spring.practice.model;

public class user
{
    private Long id;
    private String name;
    private String email;

    public Long getDoB() {
        return DoB;
    }

    public void setDoB(Long doB) {
        DoB = doB;
    }

    private  Long DoB;

    public user(long id, String name, String email , Long DoB)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.DoB = DoB;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }



}
