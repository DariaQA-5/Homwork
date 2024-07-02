package Lesson5;

import java.util.Scanner;
public class Work5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        int a = scanner.nextInt();

        System.out.print("Введите второе число: ");
        int b = scanner.nextInt();

        compareTwoNumbers(a, b);
    }

    private static void compareTwoNumbers(int a, int b) {
        int sum = a + b;
        if (sum >= 10 && sum <= 20) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}

