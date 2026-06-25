package com.example.demo.entity;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class ContactService {

    @Async//Асихнронность я называю это фоновой задачей
    public CompletableFuture<String> test(String seed){
        System.out.println("Фоновая загрузка пошла...");
        try{
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();

        }
        String result = "Мир успешно загружена под сидом: " + seed;
        return CompletableFuture.completedFuture(result);
    }

    private final Maratik contactRepository;

    public ContactService(Maratik contactRepository) {
        this.contactRepository = contactRepository;
    }

    public String getFormattedPhone(Long id) {//Метод который выдает по ид
        Contact contact = contactRepository.findById(id).orElse(null);
        if (contact == null) {
            return "Контакт не найден";
        }
        return "+7" + contact.getPhone();
    }
}
