package com.exфmple.demo; // Строго пакет твоего проекта!

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyFirstTest {

    @Test
    public void testWithBug() {
        int result = 5 + 5; // Тут гарантированно 10

        // Нагло врём JUnit'у, что ждём 100
        assertEquals(10, result);
        assertTrue(result>11);
    }
}
