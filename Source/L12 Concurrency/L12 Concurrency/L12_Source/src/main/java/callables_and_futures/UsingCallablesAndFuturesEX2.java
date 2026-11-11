package callables_and_futures;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;

public class UsingCallablesAndFuturesEX2 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        List<Callable<Integer>> tasks = Arrays.asList(
                () -> ThreadLocalRandom.current().nextInt(1, 10 + 1),
                () -> ThreadLocalRandom.current().nextInt(11, 20 + 1),
                () -> ThreadLocalRandom.current().nextInt(21, 30 + 1),
                () -> ThreadLocalRandom.current().nextInt(31, 40 + 1),
                () -> ThreadLocalRandom.current().nextInt(41, 50 + 1));

        ExecutorService exe = Executors.newCachedThreadPool();
        List<Future<Integer>> futures = exe.invokeAll(tasks);

        for (Future<Integer> future : futures) { //better to stream the list!
            System.out.println(future.get());
        }



        exe.shutdownNow();

    }

}
