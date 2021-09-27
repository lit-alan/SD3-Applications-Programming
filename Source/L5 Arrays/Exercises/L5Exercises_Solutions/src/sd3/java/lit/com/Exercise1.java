/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sd3.java.lit.com;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Alan.Ryan
 */
public class Exercise1 { 

       public static void main(String[] args) {
        int rands[] = new int[100];
        int min  = 1;
        int max = 1000;

        //init array with random values in range 
        for (int i = 0; i < rands.length; i++) {
            rands[i] = ThreadLocalRandom.current().nextInt(min,max+1);
        }

        int largest = rands[0];
        int smallest = rands[0];
        int sevenCount = 0;
        int sum = 0;
        double avg;

        //find the smallest, largest nums in the array 
        //find the freq of 7 in the array
        //find the sum of all values
        for (int i = 0; i < rands.length; i++) {

            if (rands[i] < smallest) {
                smallest = rands[i];
            }

            if (rands[i] > largest) {
                largest = rands[i];
            }

            if (rands[i] == 7) {
                sevenCount++;
            }

            sum += rands[i];
        }

        //compute avg
        avg = (double) sum / rands.length;

        //display answers
        System.out.println("Smallest is " + smallest);
        System.out.println("Largest is " + largest);
        System.out.println("Number of 7's in the array " + sevenCount);
        System.out.println("Sum is " + sum);
        System.out.println("Average is " + avg);

    }

}