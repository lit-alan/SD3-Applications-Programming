import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    final static int ROWS =10;
    final static int COLS = 5;
    static int[][] matrix = new int[ROWS][COLS];

    public static void main(String[] args) {

        initMatrix();

        printMatrix();

        raise2DArray();

        System.out.println();

        printMatrix();



    }

    public static void initMatrix() {
        int random;
        boolean[] usedNumbers = new boolean[11];

        for(int i=0; i<ROWS; i++) {
           for(int j=0; j<COLS; j++) {

                do{
                    random = ThreadLocalRandom.current().nextInt(1, 10 + 1);
                }while(isDuplicateOrSameParity(j, usedNumbers, random));

                matrix[i][j] = random;
                usedNumbers[random] = true;
            }
           Arrays.fill(usedNumbers, false); //reset the array elements to false for the next row
        }
    }

    //Check whether a number is a duplicate or has the same parity as an index
    //parity refers to whether a number is even or odd. Even numbers have a parity of 0, while odd numbers have a parity of 1.
    public static boolean isDuplicateOrSameParity(int index, boolean[] usedNumbers, int random) {
        return usedNumbers[random] || (isEven(index) != isEven(random));
        //the above line can be rewritten as follows:
        // if (duplicates[random] || (isEven(index) != isEven(random)))
        //  return true;
        // else
        //return false;
    }

    //check if a given number is even
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    //print the matrix
    public static void printMatrix() {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }

    public static void raise2DArray() {

        int firstValue = matrix[0][0];
        int lastValue = matrix[ROWS-1][COLS-1];

            for (int i = 0; i < ROWS; i++) {
            int nextRowIndex = (i + 1) % ROWS; //Calculate the index of the next row in the 2D array, wrapping around to the first row if the current row is the last row.
            for (int j = 0; j < COLS - 1; j++) {
                matrix[i][j] = (int) Math.pow(matrix[i][j], matrix[i][j + 1]);
            }

            // Raise the last element in the row to the power of the first element in the next row.
            matrix[i][COLS - 1] = (int) Math.pow(matrix[i][COLS - 1], matrix[nextRowIndex][0]);
        }

        //raise the last element in the array to the pow of the first element
        matrix[ROWS-1][COLS-1] = (int) Math.pow(lastValue, firstValue);
    }

}
