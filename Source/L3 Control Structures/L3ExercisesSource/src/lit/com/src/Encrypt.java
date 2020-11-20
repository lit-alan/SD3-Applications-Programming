package lit.com.src;

import java.util.Scanner;

/**
 *
 * @author Alan.Ryan
 */
public class Encrypt {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //vars
        int number, digit1, digit2, digit3, digit4;
        String inputString;

        //Enter four digit number to be encrypted
        System.out.println("Enter your four digit number to encrypt or -1 to QUIT?");
        number = sc.nextInt();

        //loop while the user doesn't enter -1 (as number)
        while (number != -1) {

            //isolate each digit, add 7 to it and mod by ten
            //I'm doing this in one step for each digit, but it can obviously be done in 3
            digit1 = (number / 1000 + 7) % 10;
            digit2 = (number % 1000 / 100 + 7) % 10;
            digit3 = (number % 1000 % 100 / 10 + 7) % 10;
            digit4 = (number % 1000 % 100 % 10 + 7) % 10;

            //swap the digits around using the help of a temp variable
            //swap the first digit with the third and the second digit with the fourth 
            int temp = digit1;
            digit1 = digit3 * 1000;
            digit3 = temp * 10;

            temp = digit2;
            digit2 = digit4 * 100;
            digit4 = temp;

            //assemble the encrypted number
            int encryptedNumber;
            encryptedNumber = digit1 + digit2 + digit3 + digit4;

            //display the encrypted number
            System.out.println("Encrypted number is " + encryptedNumber);
            
            
            //Ask user to enter another four digit number to be encrypted
            //If you don't ask them again inside the loop, you will end up in an infinite loop
            System.out.println("Enter your four digit number? (-1 to quit)");

            number = sc.nextInt();

        }//end while

        //exit the program
        System.exit(0);

    }//end main

}//end Encryptor class
