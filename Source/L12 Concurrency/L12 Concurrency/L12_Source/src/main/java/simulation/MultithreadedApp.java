package simulation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultithreadedApp {
    public static void main(String[] args) {
        System.out.println("Starting concurrent simulation with ExecutorService...");

        //Create a fixed thread pool
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        //Create Runnables for each task
        Runnable fileProcessingTask = createTask("File processing", 8000);
        Runnable networkCallTask = createTask("Network call", 4000);
        Runnable computationTask = createTask("Computation", 5000);

        //Submit tasks to the ExecutorService
        executorService.submit(fileProcessingTask);
        executorService.submit(networkCallTask);
        executorService.submit(computationTask);

        //Shutdown the ExecutorService
        executorService.shutdown();

    }

    private static Runnable createTask(String taskName, int duration) {
        return () -> {
            System.out.println("Starting " + taskName + "...");
            for (int i = 1; i <= duration; i++) {
                System.out.println("Working on " + taskName + " " + i);
            }
            System.out.println(taskName + " completed.");
        };
    }
}