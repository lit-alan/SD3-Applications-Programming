package sd3.java.lit.com;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Exercise4 {

    public static void main(String[] args) {

        final int min = 0;
        final int max = 30;

        final int ROWS = 20;
        final int COLS = 10;

        int table[][] = new int[ROWS][COLS];

        //This array will be used to keep track of what numbers have been used/ranadomly generated.
        //Hence its size is 31 as we will be generating random numbers in the range 0 - 30
        //When we generate a random number, we will set its corresponding element in this array to true -
        //this will indicate that this number has been used.
        //For example if 24 is randomly generated, then usedNumbers[24] will be set to true.
        //All elements in this array will initially be false - indicating that they haven't yet been used
        boolean usedNumbers[] = new boolean[31];

        int occuranceCount = 0;

        int randomNum;

        //Fill the array with data
        //Ensure that each row is filled with random numbers in the range 0 - 30,
        //but that the same number can only occur once in each row
        for (int i = 0; i < ROWS; i++) {

            for (int j = 0; j < COLS; j++) {

                //Continually generate a (random) number while its corresponding element
                //in the usedNumbers array is set to true
                do {

                    randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);

                } while (usedNumbers[randomNum] == true);

                //Put the random number into the array at row i and col j
                table[i][j] = randomNum;

                //Set element randomNum in the usedNumbers array to true
                //This indicates that this number has been used/generated in this row
                usedNumbers[randomNum] = true;
            }
            //After filling a row in the array with numbers, we need to reset all the elements
            //in this array to false in preparation for the filling of the next row
            //This code is a shorthand way of achieving this end
            Arrays.fill(usedNumbers, false);
        }

        //print the array
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                System.out.print(table[i][j] + ", ");
            }
            System.out.println("");
        }

        //determine the how many times 7 and 8 appear sequentially in the array
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {

                //you must break out of the inner loop if you have reached the end of a given row
                //otherwise you will attempt to index a non-existent element in the array
                //this will cause the program to crash
                if (j == COLS - 1) {
                    break;
                }

                //check if 7 and 8 occur sequentially in a row
                if ((table[i][j] == 7 && table[i][j + 1] == 8)) {
                    occuranceCount++;

                }

            }
        }

        System.out.println("\nThe number of times 7 & 8 occur sequentially in a row in this array is " + occuranceCount);

    }

}
