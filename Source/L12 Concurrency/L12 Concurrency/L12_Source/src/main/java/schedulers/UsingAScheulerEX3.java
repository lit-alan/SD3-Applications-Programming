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
       int period = 1;
       executor.scheduleWithFixedDelay(task, initialDelay, period, TimeUnit.SECONDS);

       /*
       For example, if you schedule a task with an initial delay of 5 seconds and a period of 10 seconds, the task will first run after 5 seconds,
       and then it will run again 10 seconds after it has completed its execution, regardless of how long the execution took.
        */

        /*
        Suppose a task takes 3 seconds to execute:
        If scheduled at a fixed rate of 10 seconds, the task will attempt to run every 10 seconds, regardless of the 3-second execution time.
        If scheduled with a fixed delay of 10 seconds, the task will run, then wait 10 seconds after it has finished before running again.
        So, the actual interval between starts of each execution will be 13 seconds (3 seconds of execution plus 10 seconds of delay).
         */

        /*
        scheduleAtFixedRate is about maintaining a consistent frequency, while scheduleWithFixedDelay is about ensuring a fixed rest period between
        xecutions.
        The choice between the two should be based on the specific requirements of the task you are scheduling.
         */
    }
 
}
