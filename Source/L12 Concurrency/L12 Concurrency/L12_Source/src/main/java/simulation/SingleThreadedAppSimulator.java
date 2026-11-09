package simulation;

public class SingleThreadedAppSimulator {

    /*
        Each task starts only after the previous one completes.
        There’s no parallelism, making it inefficient for applications that require concurrent execution, especially for
        tasks that don’t depend on each other.
     */

    public static void main(String[] args) {
        System.out.println("Starting single-threaded simulation...");

        //Simulate task 1: File processing
        performTask("File processing", 8000);

        //Simulate task 2: Network call
        performTask("Network call", 4000);

        //Simulate task 3: Computation
        performTask("Computation", 5000);

    }

    private static void performTask(String taskName, int duration) {
        System.out.println("Starting " + taskName + "...");
        for (int i = 1; i <= duration; i++) {
            System.out.println("Working on " + taskName + " " + i);
        }
        System.out.println(taskName + " completed.");
    }
}
