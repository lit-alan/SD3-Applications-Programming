package using_executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestExecutorsEX1 {

    public static void main(String[] args) {
      
        Runnable goodbye = () -> {
            for (int i = 1; i <= 100; i++) {
                System.out.println("Goodbye " + i);
            }

        };

        Runnable hello = () -> {
            for (int i = 1; i <= 100; i++) {
                System.out.println("Hello " + i);
            }

        };
        
           Runnable soLong = () -> {
            for (int i = 1; i <= 100; i++) {
                System.out.println("so Long " + i);
            }

        };
           Runnable farewell = () -> {
            for (int i = 1; i <= 100; i++) {
                System.out.println("farewell " + i);
            }

        };
        
        ExecutorService exe = Executors.newFixedThreadPool(2);
        exe.submit(hello);
        exe.submit(goodbye);
        exe.submit(soLong);
        exe.submit(farewell);
        
        exe.shutdown();
      
    }//end main
    
}
