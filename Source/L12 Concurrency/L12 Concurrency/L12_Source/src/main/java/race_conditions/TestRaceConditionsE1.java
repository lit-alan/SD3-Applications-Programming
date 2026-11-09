package race_conditions;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestRaceConditionsE1 {

    public static volatile int count;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 1; i <= 100; i++) {
            int taskId = i;
            Runnable task = () -> {
                for (int k = 1; k <= 1000; k++) {
                    count++;
                }
                System.out.println(taskId + ": " + count);
            };
            executor.execute(task);
        }
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.MINUTES);
        System.out.println("Final value: " + count);
    }//end main
}//end class
