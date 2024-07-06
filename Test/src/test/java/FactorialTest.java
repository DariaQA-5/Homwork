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
        long result = factorial.printFactorial(5);
        assertEquals(120, result);
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void printFactorialNegativeTest() {
        factorial.printFactorial(-5);
    }
}
