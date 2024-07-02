package Exception;

public class ArrayProcessor {
    public static int  processArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        // Check array size
        if (array.length != 4 || array[0].length != 4) {
            throw new MyArraySizeException("Array size must be 4x4");
        }
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Invalid data in cell [" + i + "][" + j + "]: " + array[i][j]);
                }
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        try {
            String[][] array = {{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"13", "14",
                    "15", "16"}};
            int result = processArray(array);
            System.out.println("Sum: " + result);
        } catch (MyArraySizeException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}