package com.example.demo;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("I'm the calculator test class")
public class TestCalculator {
    @Test
    @DisplayName("testing the sum method")
    public void testSum() {
        Calculator cal = new Calculator();
        assertEquals(12, cal.sum(5,7));
    }

    @Test
    @DisplayName("testing the sum method")
    public void testSubtract() {
        Calculator cal = new Calculator();
        assertEquals(3, cal.subtract(12,9));
    }

    @Test
    @DisplayName("testing the division method")
    public void testDivision() {
        Calculator cal = new Calculator();
        assertEquals(12, cal.division(60, 5));
    }

    @Test
    @DisplayName("testing the division method exception")
    public void testDivisionException() {
        Calculator cal = new Calculator();
        assertThrows(ArithmeticException.class, () -> {cal.division(9, 0);});
    }

    @Test
    @DisplayName("testing the multiplication method")
    public void testMultiplication() {
        Calculator cal = new Calculator();
        assertEquals(100, cal.multiply(10, 10));
    }
}
