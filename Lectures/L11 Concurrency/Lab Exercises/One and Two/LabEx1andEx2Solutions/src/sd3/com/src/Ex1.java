package sd3.com.src;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;

public class Ex1 {
    static final int SIZE = 1_000_000;
    static final int LOWER_LIMIT = 1;
    static final int UPPER_LIMIT = 10;
    static int[] data = new int[SIZE];
    public static void main(String[] args) {
        for (int i = 0; i < SIZE; i++) {
            data[i] = ThreadLocalRandom.current().nextInt(LOWER_LIMIT, UPPER_LIMIT + 1);
        }
        Runnable evenTask = () -> {
            int evenTotal = 0;
            for (int i = 0; i < SIZE; i++) {
                if (data[i] % 2 == 0) {
                    evenTotal += data[i];
                }
            }
           
            System.out.println("Even total is " + evenTotal  + "\n");
        };
        Callable<Integer> oddTask = () -> {
            int oddTotal = 0;
            for (int i = 0; i < SIZE; i++) {
                if (data[i] % 2 != 0) {
                    oddTotal += data[i];
                }
            }
            return oddTotal;
        };
        ExecutorService exe = Executors.newCachedThreadPool();
        Future<Integer> oddTotalFuture = exe.submit(oddTask);
        exe.submit(evenTask);
        int oddTotal = 0;
        try {
            oddTotal = oddTotalFuture.get();
        } catch (InterruptedException | ExecutionException ex) {
            System.out.println(ex);
        }
        System.out.println("Odd total is: " + oddTotal + "\n");
        
        int arr[] = {2, 5, 6, 7, 1, 1, 1, 7, 1, 1, 6, 7, 1, 6, 1, 1, 1, 9, 1, 1};
        Runnable printTask = () -> {
            System.out.print(arr[0] + ", ");
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] == 1 && arr[i - 1] == 1)
                         ; //do nothing
                else {
                    System.out.print(arr[i] + ", ");
                }
            }//end for
            System.out.println("");
        };
        exe.submit(printTask);
        
        exe.shutdownNow();
    }
}