public class Factorial {
    public long printFactorial(long factorial) {
        if (factorial < 0) {
            throw new IllegalArgumentException("Число должно быть целым и положительным.");
        }
        long result = 1L;
        for (long i = 1L; i <= factorial; i++) {
            result = result * i;
        }
        return result;
    }
}