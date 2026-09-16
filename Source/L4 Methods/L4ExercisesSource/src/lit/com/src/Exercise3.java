package lit.com.src;


public class Exercise3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int x = primeFactors(1, 20);

        System.out.println(x);

    }//end main

    private static int primeFactors(int start, int limit) {
        boolean flag = false; //Will stay false until a number divisible by all integers between start and limit is found.
        
        int x = limit; //the number being tested for divisibility.

        //loop runs until flag becomes true.
        while (!flag) {
            flag = true; //flag is set to true, assuming the current value of x will be divisible by all numbers in the range

            //Loop to check whether the current value of x is divisible by all numbers in the range.
            for (int i = limit; i >= start; i--) {
                if (x % i != 0) { //check if x is not divisible by i
                    x += limit; //x is increased by limit.Ensuring that the next candidate for divisibility testing is a multiple of the original limit.
                    flag = false; //Since x is not divisible by one of the numbers in the range, flag is set to false, indicating that the while loop must continue.
                }//end if
            }//end for
        }//end while

        /*
        The loop will continue until it finds an x that is divisible by every integer between start and limit.
        When such an x is found (i.e., when flag remains true after one full iteration of the for loop),
        the while loop will terminate.
         */
        return x;

    }//end method

}//end class
