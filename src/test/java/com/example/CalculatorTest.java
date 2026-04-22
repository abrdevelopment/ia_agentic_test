package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void shouldAddTwoNumbers() {
        Calculator calc = new Calculator();
        assertEquals(5, calc.add(2, 3));
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
