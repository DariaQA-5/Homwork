package Lesson10;
public class Factorial {
    public long printFactorial(long factorial) {
        if (factorial < 0) {
            throw new IllegalArgumentException("Число должно быть целым и положительным.");
        }
        long result = 1;
        for (long i = 1; i <= factorial; i++) {
            result *= i;
        }
        return result;
    }
}