package LabExerciseSource;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class Exercise10 {

    static final int LIMIT = 10;
    
    static final int UPPERLIMIT = 5;

    static int[] numbers;

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        numbers = new Random().ints(LIMIT, 1, UPPERLIMIT+1).toArray();
        
       //print array
        System.out.println("Numbers in array  " + Arrays.toString(numbers));

        ExecutorService exe = Executors.newCachedThreadPool();
 
        //odd task
        exe.submit(() -> {
            int oddSum = 0;
            for (int i = 0; i < LIMIT; i++) {
                if ( i % 2 != 0)
                    oddSum += i;
            }
//           Alternatively, use streams and a Lambda expression
//           int oddSum = (int) Arrays.stream(numbers)
//                                      .filter(i -> i % 2 != 0)
//                                      .sum();
    
           System.out.println("Sum of odd numbers in array: " + oddSum);
            

        });

        //even task
        exe.submit(()-> {
            int evenSum = 0;
            for (int i = 0; i < LIMIT; i++) {
                if ( i % 2 == 0)
                    evenSum += i;
            }
//            Alternatively, use streams and a Lambda expression
//            int evenSum = (int) Arrays.stream(numbers)
//                                      .filter(i -> i % 2 == 0)
//                                      .sum();
//           
            System.out.println("Sum of even numbers in array: " + evenSum);

        });
        
        
        //produce frequency distribution 
        //You weren't asked to produce this in the exercise, but..
        exe.submit(() -> {
          
            int freq[] = new int[UPPERLIMIT+1];
            
            for (int i = 0; i < LIMIT; i++) {
                int x = numbers[i];
                freq[x]++;
            }
            
            for (int i = 1; i <= UPPERLIMIT; i++) {
            
                System.out.println("Freq of " + i + " is " + freq[i]);
            }
            
        });
        
        //replace maximal seq of 1 with a single 1 task
        //There's a few ways this can be done        
        exe.submit(() -> {

            for (int i = 0; i < LIMIT; i++) {
                System.out.println("here");
                System.out.print(numbers[i] + " ");

                while (numbers[i] == 1) {

                    int n = numbers[i + 1];

                    if (n != 1) {
                        System.out.print(n + " ");
                    }

                    i++;
                }//end while

            }//end for
        });
        

      
        try {
            exe.shutdown();
            exe.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("Tasks Interrupted" + e);
        } finally {
            if (!exe.isTerminated()) {
                System.err.println("All running tasks have been cancelled");
            }
            exe.shutdownNow();
            System.out.println("====>Shutdown complete<====");
        }//end finally

    }//end main
}//end class
