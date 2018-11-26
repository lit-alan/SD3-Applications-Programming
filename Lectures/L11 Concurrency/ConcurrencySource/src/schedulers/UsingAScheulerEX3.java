package schedulers;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class UsingAScheulerEX3 {

    public static void main(String[] args) {
               
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        Runnable task = () -> {
            try {
                TimeUnit.SECONDS.sleep(2); //simulate a delay
                System.out.println("Hello: " + new Date());
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        };

       int initialDelay = 0;
       int delay = 1;
       executor.scheduleWithFixedDelay(task, initialDelay, delay, TimeUnit.SECONDS);
        
    }
 
}
