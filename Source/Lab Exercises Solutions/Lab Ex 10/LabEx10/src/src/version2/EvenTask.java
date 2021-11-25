package src.version2;

import java.util.concurrent.Callable;

public class EvenTask implements Callable<Integer> {

    int numbers[];

    public EvenTask(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public Integer call() throws Exception {
        int evenCount = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                evenCount++;
            }
        }
        return evenCount;
    }

}
