package sd3.concurrency;

import java.util.Arrays;

public class OddTask implements Runnable {

    int numbers[];

    public  OddTask(int numbers[]) {

        this.numbers = numbers;
    }

    @Override
    public void run() {

        int sumOfOdds = Arrays.stream(numbers)
                .filter(n -> n % 2 != 0)
                .sum();

//       Alternatively...
//        int sumOfOdds = 0;
//        for (int i = 0; i < numbers.length; i++) {
//            if (numbers[i] % 2 != 0) {
//                sumOfOdds+= numbers[i];
//            }
//        }
        System.out.println("Sum of Odd Numbers " + sumOfOdds);
    }
}
