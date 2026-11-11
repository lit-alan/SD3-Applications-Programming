
package schedulers;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Demonstrates how to schedule tasks for repeated execution
 * using a ScheduledExecutorService.
 *
 * <p>Uses scheduleAtFixedRate() to execute Runnable tasks
 * at regular intervals after an initial delay.</p>
 *
 * <p>Two tasks are scheduled independently:</p>
 * <ul>
 *     <li>hello executes immediately and then every 1 second.</li>
 *     <li>bye executes after an initial delay of 8 seconds
 *         and then every 2 seconds.</li>
 * </ul>
 *
 * <p>A ScheduledExecutorService is used to manage the
 * execution of scheduled tasks using a thread pool.</p>
 *
 * @author
 * @version 1.0
 */
public class UsingASchedulerEX2V1 {

    /**
     * Entry point of the application.
     *
     * <p>Creates a ScheduledExecutorService with two threads,
     * defines two Runnable tasks and schedules them for
     * repeated execution at fixed intervals.</p>
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {

        // Create a thread pool containing two threads.
        ScheduledExecutorService executor =
                Executors.newScheduledThreadPool(2);

        // Define the tasks to be executed.
        Runnable hello = () ->
                System.out.println("Hello " + new Date());

        Runnable bye = () ->
                System.out.println("Goodbye " + new Date());

        // Schedule hello to execute immediately,
        // and then repeatedly every 1 second.
        int initialDelay = 0;
        int period = 1;

        executor.scheduleAtFixedRate(
                hello,
                initialDelay,
                period,
                TimeUnit.SECONDS
        );

        // Schedule bye to execute after an initial delay
        // of 8 seconds, and then repeatedly every 2 seconds.
        initialDelay = 8;
        period = 2;

        executor.scheduleAtFixedRate(
                bye,
                initialDelay,
                period,
                TimeUnit.SECONDS
        );
    }
}
