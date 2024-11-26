package sd3.concurrency;

import java.util.Arrays;

public class EvenTask implements Runnable {

    int numbers[];
    public EvenTask(int numbers[]) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        int sumOfEvens = Arrays.stream(numbers)
                .filter(n -> n % 2 == 0)
                .sum();
//       Alternatively...
//        int sumOfEvens = 0;
//        for (int i = 0; i < numbers.length; i++) {
//            if (numbers[i] % 2 == 0) {
//                sumOfEvens+= numbers[i];
//            }
//        }
        System.out.println("Sum of Even Numbers " + sumOfEvens);

    }
}
