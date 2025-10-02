import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    static final int ROWS = 10;
    static final int COLS = 5;

   public static void main(String[] args) {

        int[][] matrix = new int[ROWS][COLS];

        initMatrix(matrix);
        printMatrix(matrix,3);

        powerTransformMatrix(matrix);
        printMatrix(matrix,11);
    }

    /** Initialises matrix with random unique numbers per row,
     *  ensuring parity of index matches parity of number.
     *
     */
    public static void initMatrix(int[][] matrix) {
        /** Im using a boolean array here to track which numbers have been used in a given row of the array
         *  It enforces uniqueness of numbers within a row.
         *  The index corresponds to the number itself (1–10), where a value of true at a given index would
         *  indicate that the number is already used in that row.
         */
        boolean[] usedNumbers = new boolean[11]; //values 1–10

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int random;
                do {
                    random = ThreadLocalRandom.current().nextInt(1, 11);
                } while (usedNumbers[random] || isParityMismatch(j, random));

                matrix[i][j] = random;
                usedNumbers[random] = true;
            }
            Arrays.fill(usedNumbers, false); //reset for next row
        }
    }

    /**
     * Checks whether the parity (even/odd status) of a column index
     * does not match the parity of a given number.
     *
     * @param index the column index to check (0-based)
     * @param number the number to compare against
     * @return {@code true} if the index and number have different parity
     *         (one even, the other odd); {@code false} otherwise
     */
    private static boolean isParityMismatch(int index, int number) {
        return (index % 2 == 0) != (number % 2 == 0);
    }

    /**
     * Prints a 2D integer matrix to standard output in a grid-like format.
     * <p>
     * Each value is printed with left justification and padded with spaces
     * to a fixed width so that columns align properly.
     * The spacing width is supplied as a parameter.
     * </p>
     *
     * @param matrix  the 2D integer array to print
     * @param spacing the minimum width of each printed number including padding
     */
    public static void printMatrix(int[][] matrix, int spacing) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.printf("%-" + spacing + "d", value);
            }
            System.out.println();
        }
        System.out.println();
    }



    /** Raises each element to the power of the next element in row,
     *  and last element in a row to the power of first element in next row.
     *  The final element in the array is raised to the power of very first element.
     */
    public static void powerTransformMatrix(int[][] matrix) {
        int firstValue = matrix[0][0];
        int lastValue = matrix[matrix.length - 1][matrix[0].length - 1];

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            int nextRowIndex = (i + 1) % rows;
            for (int j = 0; j < cols - 1; j++) {
                matrix[i][j] = (int) Math.pow(matrix[i][j], matrix[i][j + 1]);
            }
            matrix[i][cols - 1] = (int) Math.pow(matrix[i][cols - 1], matrix[nextRowIndex][0]);
        }

        //explicitly handle last element
        matrix[rows - 1][cols - 1] = (int) Math.pow(lastValue, firstValue);
    }

}
