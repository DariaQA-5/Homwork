package Lesson_10;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FactorialTest {
    private Factorial factorial;
    @BeforeMethod
    public void setUp() {
        factorial = new Factorial();
    }
    @Test
    public void printFactorialPositiveTest() {
        long result = factorial.printFactorial(3);
        assertEquals(6, result);
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void printFactorialNegativeTest() {
        factorial.printFactorial(-1);
    }
}

