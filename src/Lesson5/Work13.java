package Lesson5;

public class Work13 {
    public Work13() {
    }

    public static void main(String[] args) {
        int[][] mdarr = new int[4][4];

        for(int i = 0; i < 4; ++i) {
            for(int j = 0; j < 4; ++j) {
                if (i == j) {
                    mdarr[i][j] = 1;
                }

                System.out.print(mdarr[i][j]);
            }

            System.out.println();
        }

    }
}
