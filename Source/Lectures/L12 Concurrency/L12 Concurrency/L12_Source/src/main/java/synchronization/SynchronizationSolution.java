package synchronization;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SynchronizationSolution {

    int count = 0;

    int getCount() {
        return count;
    }

    synchronized void increment() {
        count = count + 1;
    }

    public SynchronizationSolution() {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Runnable incrTask = () -> {
            increment();
        };

        for (int i = 0; i < 10000; i++) {
            executor.submit(incrTask);
        }

        //neater using lambdas
        //IntStream.range(0, 10000).forEach(i -> executor.submit(this::increment));
        
        executor.shutdown();
        
        try {
            executor.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        } finally {
            if (!executor.isTerminated()) {
                System.out.println("killing non finished tasks");
            }
            executor.shutdownNow();

        }
        System.out.println("Count is " + getCount());

    }

    public static void main(String[] args) {
        new SynchronizationSolution();

    }

}
