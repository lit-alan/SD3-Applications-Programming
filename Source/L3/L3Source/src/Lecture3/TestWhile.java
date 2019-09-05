package Lecture3;

import java.util.Scanner;
import javax.swing.*;

public class TestWhile {

    public static void main(String[] args) {
        String input;
        int number, sum = 0, count = 0;

        Scanner scanner= new Scanner(System.in);
        
        count++;
        // Read an initial data
        System.out.println("Enter Number " + count);
        number = scanner.nextInt();

        // Keep reading data until the input is 0
        while (number != 0) {
            sum += number;
            count++;
            System.out.println("Enter Number " + count + " - The Program Ends When You Enter 0");
            number = scanner.nextInt();

        }//end while
        count--;
        System.out.println("The Sum is " + sum + "\nNumbers Entered =  " + count);

        System.exit(0);
    }
}
