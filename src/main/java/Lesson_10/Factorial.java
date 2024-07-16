package Lesson_10;
public class Factorial {
    public long printFactorial(long factorial) {
        if (factorial < 0) {
            throw new IllegalArgumentException("Число должно быть положительным.");
        }
        long result = 1;
        for (long i = 1; i <= factorial; i++) {
            result = result * i;
        }
        return result;
    }
}
