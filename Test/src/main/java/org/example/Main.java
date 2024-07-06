package org.example;

public class Main {
    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        System.out.println(factorial.printFactorial(5));
    }
}

class Factorial {
    public int printFactorial(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
