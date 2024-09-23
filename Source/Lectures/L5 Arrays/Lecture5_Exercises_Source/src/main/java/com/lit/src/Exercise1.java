/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lit.src;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Alan.Ryan
 */
public class Exercise1 { 

       public static void main(String[] args) {
        int rands[] = new int[100];
        int min = 1;
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
          smallest = getSmallest(rands[i], smallest);

            largest = getLargest(rands[i], largest);

            sevenCount = getSevenCount(rands[i], sevenCount);

            sum = getSum(sum, rands[i]);
        }

        //alternatively use a for each loop to iterate over the array
         //for (int rand : rands) {
           //smallest = getSmallest(rand, smallest);
           //largest = getLargest(rand, largest);
           //sevenCount = getSevenCount(rand, sevenCount);
           //sum = getSum(sum, rand);
         //}


        //compute avg
        avg = (double) sum / rands.length;

        System.out.println(Arrays.toString(rands)); //print the array to the console

        //display answers
        System.out.println("Smallest is " + smallest);
        System.out.println("Largest is " + largest);
        System.out.println("Number of 7's in the array " + sevenCount);
        System.out.println("Sum is " + sum);
        System.out.println("Average is " + avg);

    }

    public static int getSum(int sum, int rands) {
        sum += rands;
        return sum;
    }

    public static int getSevenCount(int value, int sevenCount) {
        if (value == 7) {
            sevenCount++;
        }
        return sevenCount;
    }

    public static int getLargest(int value, int largest) {
        if (value > largest) {
            largest = value;
        }
        return largest;
    }


    public static int getSmallest(int value, int smallest) {
        if (value < smallest) {
            smallest = value;
        }
        return smallest;
    }
}