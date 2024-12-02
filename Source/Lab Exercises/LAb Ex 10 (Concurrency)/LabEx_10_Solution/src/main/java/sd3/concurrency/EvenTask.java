package sd3.concurrency;

import java.util.Arrays;
import java.util.concurrent.Callable;

public class EvenTask implements Callable<Integer> {

    int numbers[];

    public EvenTask(int numbers[]) {
        this.numbers = numbers;
    }

    @Override
    public Integer call() throws Exception {
        return Arrays.stream(numbers)
                .filter(n -> n % 2 == 0)
                .sum();
    }


//    @Override
//    public void run() {
//
//        int sumOfEvens = Arrays.stream(numbers)
//                .filter(n -> n % 2 == 0)
//                .sum();
////       Alternatively...
////        int sumOfEvens = 0;
////        for (int i = 0; i < numbers.length; i++) {
////            if (numbers[i] % 2 == 0) {
////                sumOfEvens+= numbers[i];
////            }
////        }
//        System.out.println("Sum of Even Numbers " + sumOfEvens);
//
//    }
}
