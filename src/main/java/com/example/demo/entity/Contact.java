package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Contact{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String phone;
    public Contact(){}
    public Contact(String name, String phone){
        this.name = name;
        this.phone = phone;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setId(Long id){this.id = id;}
    public void setPhone(String phone){this.phone = phone;}
    public String getName(){return name;}
    public String getPhone(){return phone;}
    public Long getId(){return id;}

}