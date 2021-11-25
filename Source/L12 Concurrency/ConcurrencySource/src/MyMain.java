
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;


public class MyMain {
    
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        SimpleCallable c = new SimpleCallable(4);
        
         ExecutorService exe = Executors.newCachedThreadPool();
        Future<String> future = exe.submit(c);
        String result = future.get();  
        System.out.println(result);

       
        
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
