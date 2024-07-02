package Lesson5;

public class Work11 {
    public Work11() {
    }

    public static void main(String[] args) {
        int[] arr = new int[100];
        arr[0] = 1;
        System.out.println(arr[0]);

        for(int i = 1; i < arr.length; ++i) {
            arr[i] = arr[i - 1] + 1;
            System.out.println(arr[i]);
        }

    }
}

