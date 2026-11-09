package thread_safety;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ThreadSafetyProblemEX1 {

    private static boolean done = false;
    
    public static void main(String[] args) {
        
        Runnable hello = () -> {
            for (int i = 1; i <= 1000; i++) {
                System.out.println("Hello " + i);
            }
            done=true;
        };
        
        Runnable goodbye = () -> {
            int i = 1;
            while(!done) {
                i++;
            }
            System.out.println("Goodbye " + i);
            
        };
        
        Executor executor = Executors.newCachedThreadPool();
        executor.execute(hello);
        executor.execute(goodbye);
    }//end main
    
}
