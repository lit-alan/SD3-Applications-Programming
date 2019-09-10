package lit.com.src;

import java.util.Scanner;

/**
 *
 * @author Alan.Ryan
 * Reverse.java - a program to reverse a 3 digit number
 */
public class Reverse {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        //get input
        System.out.println("Enter a number between 101 and 999");
        int orginalNumber = sc.nextInt();
        int number = orginalNumber;
        
        //test if number is within the range
        if (number < 101 || number > 999) {
            System.out.println("Number is outside the allowable range");
            System.exit(0);
        }
        
        //seperate the orginal number into 3 seperate digits
        int lastDigit = number % 10;
        number /= 10;
        
        int middleDigit = number % 10;
        number /= 10;
        
        int firstDigit = number;
        
        //build the reverse number 
        int reverse = lastDigit * 100 + middleDigit * 10 + firstDigit;
        
        //display both the orginal and reversed numbers
        System.out.println(orginalNumber + " reversed is " + reverse);
        
        
    }
    
}
