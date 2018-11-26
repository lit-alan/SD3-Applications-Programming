package using_executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestExecutorsEX2 {

    public static void main(String[] args) {
        
       ExecutorService exe = Executors.newCachedThreadPool();

        exe.submit(() -> {
            for (int i = 1; i <= 100; i++) {
                System.out.println("Hello " + i);
            }
        });

        exe.submit(() -> {
            for (int i = 1; i <= 100; i++) {
                System.out.println("Goodbye " + i);
            }
        });

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

    }//end main
    
}
