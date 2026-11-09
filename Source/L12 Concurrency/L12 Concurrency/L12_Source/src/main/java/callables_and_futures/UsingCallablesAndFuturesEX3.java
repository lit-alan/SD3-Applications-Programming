package callables_and_futures;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UsingCallablesAndFuturesEX3 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService executor = Executors.newCachedThreadPool();

        List<Callable<String>> callables = Arrays.asList(
                () -> "Monday",
                () -> "Tuesday",
                () -> "Wednesday",
                () -> "Thursday",
                () -> "Friday",
                () -> "Saturday",
                () -> "Sunday");

        String future = executor.invokeAny(callables);
        
        System.out.println(future);
        
        executor.shutdownNow();

    }

}
