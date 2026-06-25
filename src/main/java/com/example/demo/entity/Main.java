package com.example.demo.entity;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@SpringBootApplication
@EnableAsync
public class Main implements CommandLineRunner {
    @Autowired
    private Maratik ContactRepository;
    @Autowired
    public ContactService contactService;

    public static void main(String... args) {
        SpringApplication.run(Main.class, args);
    }
    @PostMapping("/api/contacts")//Ловим ПОСТ запросы)
    public ResponseEntity<?> addContact(@Valid @RequestBody ContactFto contactFto){
        // Если лезут под админом — даём от ворот поворот (400 Bad Request)
        if("Админ".equalsIgnoreCase(contactFto.getName())){
            return ResponseEntity.badRequest().body("Админ? ты серьезно? отвали ебень");
        }
        Contact contact = ContactMapper.toEntity(contactFto);
        Contact saveContact = ContactRepository.save(contact);
        // Возвращаем статус 201 и сам созданный контакт
        return ResponseEntity.status(HttpStatus.CREATED).body(saveContact);
    }

    @GetMapping("/api/contacts")//Выдаем список контактовДто
    public ResponseEntity<List<ContactFto>> getAllContacts() {
        List<Contact> allEntities = ContactRepository.findAll();
        List<ContactFto> resultDtoList = new java.util.ArrayList<>();

        for (Contact contact : allEntities) {
            ContactFto dto = ContactMapper.toDto(contact);
            resultDtoList.add(dto);
        }
        // Возвращаем список и статус 200
        return ResponseEntity.ok(resultDtoList);
    }

    @GetMapping("/api/contacts/{id}")//Выдаем контакты по этому ид
    public ResponseEntity<?> getFindById(@PathVariable Long id){
        Contact contact = ContactRepository.findById(id).orElse(null);
        // Если контакта нет в базе — возвращаем 404 без тела
        if (contact == null){
            return ResponseEntity.notFound().build();
        }
        ContactFto dto = ContactMapper.toDto(contact);

        // Если есть — отдаем 200 и данные
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/api/contacts/{id}")//Удаление
    public ResponseEntity<Void> deleteContact(@PathVariable Long id) {

        if (!ContactRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        ContactRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
    @GetMapping("run-cfg")
    public ResponseEntity<String> test(){
        contactService.test("123123");
        return ResponseEntity.ok("Успех");

    }

    @Override
    public void run(String... args){
        ContactRepository.deleteAll(); // Очистка базы при старте
        Contact c1 = new Contact("Marat", "89080303979");
        ContactRepository.save(c1);
        System.out.println("Марат, ты большой молодец, так держать, красавчик!");
    }
}
