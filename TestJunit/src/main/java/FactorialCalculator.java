public class FactorialCalculator {
    public static long calculateFactorial(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("исло должно быть положительным");
        }
        long result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }
}