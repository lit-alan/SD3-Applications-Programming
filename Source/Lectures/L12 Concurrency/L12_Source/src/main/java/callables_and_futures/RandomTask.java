package callables_and_futures;

import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class RandomTask implements Callable<Integer> {

    int upperBound = 0;
    int lowerBound = 0;

    public RandomTask(int lowerBound, int upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound; }

    @Override
    public Integer call() throws Exception {
        return ThreadLocalRandom.current().nextInt(1,upperBound+1);
    }
}


