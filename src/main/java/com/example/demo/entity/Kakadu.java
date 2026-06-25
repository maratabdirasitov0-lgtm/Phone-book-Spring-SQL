package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Kakadu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String phonenumber;
    public Kakadu(){}
    public Kakadu(String name, String phonenumber){
        this.name = name;
        this.phonenumber = phonenumber;
    }
    public void setId(Long id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setPhonenumber(String phonenumber){
        this.phonenumber = phonenumber;
    }
    public Long getId(){return id;}
    public String getName(){return name;}
    public String getPhonenumber(){return phonenumber;}
}
