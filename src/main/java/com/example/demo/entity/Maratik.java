package com.example.demo.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Maratik extends JpaRepository<Contact, Long> {
    List<Contact> findByName(String name);
}
