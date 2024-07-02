package Lesson5;

public class Work2 {
    public Work2() {
    }

    public static void main(String[] args) {
        checkSumSing();
    }

    private static void checkSumSing() {
        int a = 7;
        int b = 10;
        if (a + b >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }

    }
}

