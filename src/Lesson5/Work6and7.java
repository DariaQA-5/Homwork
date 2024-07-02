package Lesson5;

import java.util.Scanner;

public class Work6and7 {
    public Work6and7() {
    }

    public static void main(String[] args) {
        compareInteger();
    }

    public static void compareInteger() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число:");
        int a = scanner.nextInt();
        if (a >= 0) {
            System.out.println("Число положительное");
            System.out.println("false");
        } else {
            System.out.println("Число отрицательное");
            System.out.println("true");
        }

    }
}

