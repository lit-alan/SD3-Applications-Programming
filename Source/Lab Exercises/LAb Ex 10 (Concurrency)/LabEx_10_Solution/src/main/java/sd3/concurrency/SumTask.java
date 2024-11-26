package sd3.concurrency;

import java.util.Arrays;
import java.util.function.Predicate;

public class SumTask implements Runnable {

    int numbers[];
    Predicate p;

    public SumTask(int numbers[], Predicate p) {
        this.numbers = numbers;
        this.p = p;
    }

    @Override
    public void run() {
        int value = Arrays.stream(numbers)
                .filter(n -> p.test(n))
                .sum();

        System.out.println("Sum of numbers is that meet criteria " + value);
    }
}

