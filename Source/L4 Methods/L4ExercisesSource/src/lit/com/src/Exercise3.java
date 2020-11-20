package lit.com.src;


public class Exercise3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int x = primeFactors(20);

        System.out.println(x);

    }//end main

    private static int primeFactors(int limit) {
        boolean flag = false;
        
        int x = limit;
        
        while (!flag) {
            flag = true;
        
            for (int i = limit; i >= 11; i--) {
                if (x % i != 0) {
                    x += limit;
                    flag = false;
                }//end if
            }//end for
        }//end while
        
        return x;

    }//end method

}//end class
