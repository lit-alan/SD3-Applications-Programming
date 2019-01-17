package schedulers;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class UsingAScheulerEX1 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

      
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        System.out.println(new Date());
        int aDelay = 5;
        Runnable task = () -> System.out.println("Task is delayed by " + aDelay + " second(s) " + new Date());

        //schedule the task, which is a runnable. Remember a runnable doesn't return a value
        ScheduledFuture<?> future = executor.schedule(task, aDelay, TimeUnit.SECONDS);

        long remainingDelay = future.getDelay(TimeUnit.MILLISECONDS);
        System.out.println("Remaining Delay: " + remainingDelay + "ms");

        System.out.println(new Date());
     
        executor.shutdown();

    }

}
