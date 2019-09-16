package lit.com.src;

import java.util.Scanner;

/**
 *
 * @author Alan.Ryan
 */
public class Decrypt {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int number = 0, digit1, digit2, digit3, digit4;

        //Enter four digit number to be decrypted
        System.out.println("Enter your four digit number? (-1 to quit)");

        number = sc.nextInt();

        //loop while the user doesn't enter -1 (as number)
        while (number != -1) {

            digit1 = number / 1000;
            digit2 = number % 1000 / 100;
            digit3 = number % 1000 % 100 / 10;
            digit4 = number % 1000 % 100 % 10;

            int temp = (digit1 + 3) % 10;
            digit1 = (digit3 + 3) % 10;
            digit3 = temp;

            temp = (digit2 + 3) % 10;
            digit2 = (digit4 + 3) % 10;
            digit4 = temp;

                int decryptedNumber;
            decryptedNumber = digit1 * 1000 + digit2 * 100 + digit3 * 10 + digit4;

            System.out.println("Decrypted number is " + decryptedNumber);

            //Enter four digit number to be decrypted
            System.out.println("Enter your four digit number? (-1 to quit)");

            number = sc.nextInt();
        }
        System.exit(0);
    }

}
