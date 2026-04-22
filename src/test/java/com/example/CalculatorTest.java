package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void shouldAddTwoNumbers() {
        Calculator calc = new Calculator();
        assertEquals(6, calc.add(2, 3)); //alterado de 5 para 6 para o código falhar, pois 2 + 3 = 5
    }

    @Test
    void shouldDivideNumbers() {
        Calculator calc = new Calculator();
        assertEquals(2, calc.divide(4, 2));
    }

    @Test
    void shouldThrowExceptionWhenDividingByZero() {
        Calculator calc = new Calculator();
        assertThrows(IllegalArgumentException.class,
                () -> calc.divide(10, 0));
    }
}
