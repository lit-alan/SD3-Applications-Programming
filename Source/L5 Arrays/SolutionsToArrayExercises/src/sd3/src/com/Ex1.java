package sd3.src.com;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Ex1 {

    static int rands[] = new int[1000];

    public static void main(String[] args) {

        int min = 1;
        int max = 10;

        initArray(min, max, rands);

        //display answers
        System.out.println(Arrays.toString(rands));
        System.out.println("Smallest is " + determineSmallest(rands));
        System.out.println("Largest is " + determineLargest(rands));
        System.out.println("Number of 7's in the array " + sevenCount(rands));
        System.out.println("Sum is " + calculateSum(rands));
        System.out.println("Average is " + calculateAvg(rands));

    }

    private static void initArray(int min, int max, int[] rands) {
        //init array with random values in range 
        for (int i = 0; i < rands.length; i++) {
            rands[i] = ThreadLocalRandom.current().nextInt(min, max + 1);
        }
    }

    public static int determineSmallest(int[] rands) {
        int smallest = rands[0];

        for (int i = 1; i < rands.length; i++) {
            if (rands[i] < smallest) {
                smallest = rands[i];
            }
        }
        return smallest;
    }

    public static int determineLargest(int[] rands) {
        int largest = rands[0];

        for (int i = 1; i < rands.length; i++) {
            if (rands[i] > largest) {
                largest = rands[i];
            }
        }
        return largest;
    }

    public static int sevenCount(int[] rands) {
        int sevenCount = 0;

        for (int i = 0; i < rands.length; i++) {
            if (rands[i] == 7) {
                sevenCount++;
            }
        }
        return sevenCount;
    }

    public static int calculateSum(int[] rands) {
        int sum = 0;
        for (int i = 0; i < rands.length; i++) {
            sum += rands[i];
        }
        return sum;
    }

    public static double calculateAvg(int[] rands) {
        int sum = 0;

        for (int i = 0; i < rands.length; i++) {
            sum += rands[i];
        }
        //compute avg
        return (double) sum / rands.length;

    }
}//end class

