package schedulers;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class UsingAScheulerEX2 {

    public static void main(String[] args) {
        
       
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

        Runnable hello = () -> System.out.println("Hello " + new Date());
        Runnable bye = () ->   System.out.println("Goodbye " + new Date());
       
        int initialDelay = 0;
        int period = 1;
        executor.scheduleAtFixedRate(hello, initialDelay, period, TimeUnit.SECONDS);
        
        initialDelay = 8;
        period = 2;
        executor.scheduleAtFixedRate(bye, initialDelay, period, TimeUnit.SECONDS); 
        
    }

}
