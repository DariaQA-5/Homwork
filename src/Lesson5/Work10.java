package Lesson5;

public class Work10 {
    public Work10() {
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 0, 1, 0};

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1 - arr[i]; // Toggle the value
        }

        // Iterate and print the updated array elements
        for (int value : arr) {
            System.out.println(value);
        }
    }
}

