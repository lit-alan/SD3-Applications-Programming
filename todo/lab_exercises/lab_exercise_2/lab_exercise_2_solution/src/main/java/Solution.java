import java.util.Random;

public class Solution {

    final static int NUM_ROWS = 10;
    final static int NUM_COLS = 10;

    public static void main(String[] args) {
        //task 1
        int[][] array = initArray(NUM_ROWS, NUM_COLS);

        //plant some adjacent values that will sum to 12
        array[2][2] = 6;
        array[2][3] = 6;
        array[2][4] = 6;

        array[6][8] = 6;
        array[6][9] = 6;
        array[7][0] = 6;

        array[6][3] = 11;
        array[6][4] = 1;

        //task 2
        printArray(array);
        System.out.println();

        //task 3
        findAdjSums(array, 12);
        System.out.println();

        //task 4
        printSpiralMatrix(array);

        System.out.println();

    }

    //this version of findAdjSums does not wrap around to the next row
//    private static void findAdjSums(int[][] array, int x) {
//        boolean found = false; // Flag to check if any adjacent pairs are found
//
//        // Iterate through each row and find adjacent numbers that sum to x
//        for (int row = 0; row < NUM_ROWS; row++) {
//            for (int col = 0; col < NUM_COLS - 1; col++) {
//                int currentNumber = array[row][col];
//                int nextNumber = array[row][col + 1];
//                if (currentNumber + nextNumber == x) {
//                    System.out.println("The adjacent values at ROW " + row + " and COLS " + col + " and " + (col + 1) + " sum to " + x);
//                    found = true; // Set the flag to true if a pair is found
//                } // end if
//            } // end for
//        } // end for
//
//        // Print error message if no pairs are found
//        if (!found) {
//            System.out.println("No adjacent pairs found that sum to " + x);
//        }
//    } // end method


    //this version of findAdjSums DOES WRAP around to the next row
    private static void findAdjSums(int[][] array, int x) {
        boolean found = false;

        for (int row = 0; row < NUM_ROWS; row++) {

            for (int col = 0; col < NUM_COLS - 1; col++) {

                int currentNumber = array[row][col];
                int nextNumber = array[row][col + 1];

                if (currentNumber + nextNumber == x) {
                    System.out.println("The adjacent values at ROW " + row
                            + " and COLS " + col + " and " + (col + 1)
                            + " sum to " + x);
                    found = true;
                }
            }

            // Check last value in this row against first value in next row
            if (row < NUM_ROWS - 1) {

                int currentNumber = array[row][NUM_COLS - 1];
                int nextNumber = array[row + 1][0];

                if (currentNumber + nextNumber == x) {
                    System.out.println("The adjacent values at ROW " + row
                            + ", COL " + (NUM_COLS - 1)
                            + " and ROW " + (row + 1)
                            + ", COL " + 0
                            + " sum to " + x);
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("No adjacent pairs found that sum to " + x);
        }
    }

    private static void printArray(int[][] array) {
        // Print the generated 2D array
        for (int row = 0; row < NUM_ROWS; row++) {
            for (int col = 0; col < NUM_COLS; col++) {
                System.out.printf("%4d ", array[row][col]);
            }
            System.out.println(); // Move to the next row
        }
    }

    private static int[][] initArray(int numRows, int numCols) {
        Random random = new Random();
        int randomValue;
        int[][] array = new int[numRows][numCols];

        for (int row = 0; row < NUM_ROWS; row++) {
            for (int col = 0; col < NUM_COLS; col++) {
                array[row][col] =  (random.nextInt(100) + 1);
            }
        }


        return array;
    }

    public static void printSpiralMatrix(int[][] matrix) {
        int numRows = matrix.length; //Retrieves the number of rows in the 2D array (matrix).
        int numCols = matrix[0].length; //Obtains the number of columns in the first row of the matrix.
        int top = 0; //Initialises the top boundary of the spiral traversal to the first row.
        int bottom = numRows - 1; //Sets the bottom boundary of the spiral traversal to the last row.
        int left = 0; //Initialises the left boundary of the spiral traversal to the first column.
        int right = numCols - 1; //Sets the right boundary of the spiral traversal to the last column.

        while (top <= bottom && left <= right) {
            // Print top row
            for (int col = left; col <= right; col++) {
                System.out.print(matrix[top][col] + " ");
            }//end for
            top++;

            // Print rightmost column
            for (int row = top; row <= bottom; row++) {
                System.out.print(matrix[row][right] + " ");
            }//end for
            right--;

            // Print bottom row (if there's a row left to print)
            if (top <= bottom) {
                for (int col = right; col >= left; col--) {
                    System.out.print(matrix[bottom][col] + " ");
                }
                bottom--;
            }//end if

            // Print leftmost column (if there's a column left to print)
            if (left <= right) {
                for (int row = bottom; row >= top; row--) {
                    System.out.print(matrix[row][left] + " ");
                }
                left++;
            }//end if
        }//end while
    }//end method
}
