package Lesson5;

public class Work3 {
    public Work3() {
    }

    public static void main(String[] args) {
        printColor();
    }

    private static void printColor() {
        int value = 25;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) { // removed unnecessary condition
            System.out.println("Жёлтый");
        } else {
            System.out.println("Зелёный");
        }
    }
}
