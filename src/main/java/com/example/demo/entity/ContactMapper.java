package com.example.demo.entity;

public class ContactMapper {
    public static Contact toEntity(ContactFto dto){
        if (dto == null){
            return null;
        }
        return new Contact(dto.getName(), dto.getPhone());
    }
    public static ContactFto toDto(Contact entity){
        if (entity == null){
            return null;
        }
        return new ContactFto(entity.getName(), entity.getPhone());
    }
}


