package com.example.demo.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ContactFto {
    @NotBlank(message = "Поле не должна быть пустым")
    private String name;
    @Size(min = 11, max = 12, message = "Длина номера должна быть от 11 до 12")
    private String phone;
    public ContactFto(){}
    public ContactFto(String name, String phone){this.name = name; this.phone = phone;}
    public void setName(String name){this.name = name;}
    public void setPhone(String phone){this.phone = phone;}
    public String getName(){return name;}
    public String getPhone(){return phone;}


}
