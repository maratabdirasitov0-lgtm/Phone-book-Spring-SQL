package com.example.demo;

import com.example.demo.entity.Contact;
import com.example.demo.entity.ContactService;
import com.example.demo.entity.Maratik;
// Импорт сервиса убрали, так как они в одном пакете!

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ContactServiceTest {

    @Mock//Виртуально создает пульт
    private Maratik contactRepository;
    @InjectMocks//Притворяется ля какой он
    private ContactService contactService;
    @Test
    public void testing(){
        Contact contact = new Contact("Adina", "9080303979");
        when(contactRepository.findById(100L)).thenReturn(Optional.of(contact));
        String test = contactService.getFormattedPhone(100L);
        assertEquals("+79080303979", test);

    }


}