package Lesson5;

import java.util.Scanner;

public class Work14 {
    public Work14() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите длину массива:");
        int len = scanner.nextInt();
        int[] arr = new int[len];
        System.out.println("Введие числа массива:");

        int i;
        for(i = 0; i < len; ++i) {
            arr[i] = scanner.nextInt();
        }

        System.out.println("Ваш массив:");

        for(i = 0; i < len; ++i) {
            System.out.print(" " + arr[i]);
        }

        System.out.println();
    }
}

