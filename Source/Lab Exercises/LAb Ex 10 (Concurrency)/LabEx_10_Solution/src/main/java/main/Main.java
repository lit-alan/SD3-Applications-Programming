package main;

import sd3.concurrency.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Predicate;

public class Main {

//    static final int LIMIT = 1000;
    //static int[] numbers = new int[1_00_000];
    static int[] numbers =  {1, 1, 2, 5, 5, 3, 1, 1, 1, 3, 1, 1, 5, 3, 1, 4, 1, 1, 1, 4, 1, 1}; //odd sum = 37, even sum = 10

    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        for (int i = 0; i < LIMIT; i++) {
//           numbers[i] = ThreadLocalRandom.current().nextInt(1, 5 + 1);
//        }

        ExecutorService exe = Executors.newCachedThreadPool();

//        exe.submit(new PrintMaximalSeqTask(numbers));
//        exe.submit(new OddTask(numbers));
      Future<Integer> future =   exe.submit(new EvenTask(numbers));
        System.out.println("Sum of all even number is " + future.get());
     //   exe.submit(new EvenTask(numbers));
        exe.submit(new OddTask(numbers));


        Predicate<Integer> sumEvenPredicate = n -> n  % 2 == 0;
        SumTask st = new SumTask(numbers,sumEvenPredicate);
        exe.submit(st);
//
//
        Predicate<Integer> sumOddPredicate = n -> n  % 2 != 0;
        exe.submit(new SumTask(numbers, sumOddPredicate));


        PrintMaximalSeqTask task3 = new PrintMaximalSeqTask(numbers);
        exe.submit(task3);
//        Future<Integer> future = exe.submit(new PalindromeTask(10000, 50));
//        try {
//            System.out.println("The count of numbers below 10,000 that do not become " +
//                                                "palindromic after 50 iterations is : " + future.get());
//        }
//
//        catch (Exception iex) {
//            System.out.println(iex);
//        }

        exe.shutdown();

    }
}
