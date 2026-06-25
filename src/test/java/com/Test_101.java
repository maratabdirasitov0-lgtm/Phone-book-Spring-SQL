package com;

// Аннотации для сборки нашего "замка" и настройки робота
import com.example.demo.entity.Contact;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

// Сам пульт управления роботом и инструмент внедрения (Autowired)
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

// Инструмент для создания самого теста (из JUnit 5)
import org.junit.jupiter.api.Test;

// СЕКРЕТНЫЙ ИНГРЕДИЕНТ: статические импорты для команд робота
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest//Полезная функция, которая сокращает время работы чтобы проверить работосппособность
@AutoConfigureMockMvc
public class Test_101 {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void tester() throws Exception{
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("Привет МИр!"));

    }
}
