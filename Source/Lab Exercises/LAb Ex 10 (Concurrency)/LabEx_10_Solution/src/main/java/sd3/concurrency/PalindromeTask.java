package sd3.concurrency;

import java.util.concurrent.Callable;

public class PalindromeTask implements Callable<Integer> {

    int LIMIT;
    int ITERATIONS;

    public PalindromeTask(int LIMIT, int ITERATIONS) {

        this.LIMIT = LIMIT;
        this.ITERATIONS = ITERATIONS;
    }
    
    
    @Override
    public Integer call() throws Exception {
      int count = 0;
      long number = 1;
      while (number <= LIMIT) {
         if (isLychrel(number, ITERATIONS)) {
            System.out.println(number);
            count++;
         }
         number++;
      }    
    
      return count;
    }

    public static boolean isLychrel(long number, int iterations) {

        for (int i = 0; i < iterations; i++) {
            number = number + reverse(number);
            if (isPalindrome(number)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPalindrome(final long number) {
        return number == reverse(number);
    }

    private static long reverse(long number) {
        long reverse = 0;

        while (number > 0) {
            long remainder = number % 10;
            reverse = (reverse * 10) + remainder;
            number = number / 10;
        }
        return reverse;
    }
}

