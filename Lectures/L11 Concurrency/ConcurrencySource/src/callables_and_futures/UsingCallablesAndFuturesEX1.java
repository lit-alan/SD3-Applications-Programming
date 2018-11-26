package callables_and_futures;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class UsingCallablesAndFuturesEX1 {

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        
        Callable<Integer> task = () -> {
            //return random int in the range 1 - 100
            //TimeUnit.SECONDS.sleep(5);
            return ThreadLocalRandom.current().nextInt(1,100+1);
        };

        ExecutorService exe = Executors.newCachedThreadPool();
        Future<Integer> future = exe.submit(task);
        Integer result = future.get();  
        System.out.println("result: " + result);

       
        
        try {
            System.out.println("Attempting to shutdown");
            exe.shutdown();
            exe.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("Tasks Interrupted" + e);
        } finally {
            if (!exe.isTerminated()) {
                System.err.println("All running tasks have been cancelled");
            }
            exe.shutdownNow();
            System.out.println("Shutdown complete");
        }
        
        
    }

}
