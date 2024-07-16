package Lesson_10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialTest {
    private Factorial factorial;

    @BeforeEach
    public void setUp() {
        factorial = new Factorial();
    }

    @Test
    public void printFactorialPositive() {
        long result = factorial.printFactorial(5);
        assertEquals(120, result);
    }

    @Test
    public void printFactorialNegative() {
        assertThrows(IllegalArgumentException.class, () -> factorial.printFactorial(-5));
    }
}