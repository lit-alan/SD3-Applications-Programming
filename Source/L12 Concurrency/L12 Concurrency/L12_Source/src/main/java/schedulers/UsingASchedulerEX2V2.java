
package schedulers;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Demonstrates how to schedule tasks to execute at specific
 * dates and times using a ScheduledExecutorService.
 *
 * <p>Unlike scheduleAtFixedRate(), which executes tasks
 * repeatedly at fixed intervals, schedule() executes a
 * task once after a specified initial delay.</p>
 *
 * <p>The initial delay is calculated by determining the
 * duration between the current date/time and the desired
 * execution date/time.</p>
 *
 * <p>Two tasks are scheduled independently:
 * <ul>
 *     <li>hello executes on 12 November 2026 at 10:30.</li>
 *     <li>bye executes on 12 November 2026 at 11:00.</li>
 * </ul>
 * </p>
 *
 * <p>Note: Scheduled tasks are held in memory and will
 * not survive application termination.</p>
 *
 * @author
 * @version 2.0
 */
public class UsingASchedulerEX2V2 {

    /**
     * Entry point of the application.
     *
     * <p>Creates a ScheduledExecutorService with two threads,
     * defines two Runnable tasks and schedules each task
     * to execute at a specified date and time.</p>
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {

        ScheduledExecutorService executor =
                Executors.newScheduledThreadPool(2);

        Runnable hello = () ->
                System.out.println("Hello " + LocalDateTime.now());

        Runnable bye = () ->
                System.out.println("Goodbye " + LocalDateTime.now());

        //Schedule bye for Christmas day 2030 at 10:00am
        LocalDateTime targetDateTime =
                LocalDateTime.of(2030, 12, 25, 10, 00);
          

        //Calculate the delay in milliseconds.
        long delay = Duration.between(
                LocalDateTime.now(),
                targetDateTime
        ).toMillis();

        if (delay > 0) {
            executor.schedule(
                    hello,
                    delay,
                    TimeUnit.MILLISECONDS
            );
        }

        //Schedule bye for Christmas day 2030 at 10:30am
        LocalDateTime secondTarget =
                LocalDateTime.of(2030, 12, 25, 10, 30);


        //Calculate the delay in milliseconds.
        long secondDelay = Duration.between(
                LocalDateTime.now(),
                secondTarget
        ).toMillis();

        if (secondDelay > 0) {
            executor.schedule(
                    bye,
                    secondDelay,
                    TimeUnit.MILLISECONDS
            );
        }
    }
}
