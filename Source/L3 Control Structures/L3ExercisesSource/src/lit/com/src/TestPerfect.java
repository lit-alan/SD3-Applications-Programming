package lit.com.src;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Alan.Ryan
 */

public class TestPerfect {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter Number:");
        int value = sc.nextInt();

        int factorSum = 1;

        int b = 2;

        while (b <= value / 2) {

            if (value % b == 0) {
                factorSum += b;
           
            }//end if

            b++;
      
        }//end while    

        if (factorSum == value) {
            System.out.println(value + " is a perfect number");
        } else {
            System.out.println(value + " is NOT a perfect number");
        }

    }//end main
}//end class
