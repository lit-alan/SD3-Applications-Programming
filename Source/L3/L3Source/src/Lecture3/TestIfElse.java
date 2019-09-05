package Lecture3;

/*
 *User is asked to enter a year. Based on the year entered a different annual interest rate is applied.
 *If the year entered = 7 then the rate applied is 7.25
 *If the year entered = 15 then the rate applied is 8.50
 *If the year entered = 30 then the rate applied is 9.0
 *If the user does not enter a valid year (ie. 7, 15, 30) then an error message is dislayed.
 *Based on this information the monthly repayments & the total amount due is calculated.
 *The program then prompts the user to enter a loan ammount.
 *The program then exits but not before displaying on screen the total payment and monthly repayments.
 */
import java.util.Scanner;
import javax.swing.*;

public class TestIfElse {

    /**
     * Main method
     */
    public static void main(String[] args) {
        double annualInterestRate = 0;
        int numOfYears;
        double loanAmount;

        Scanner scanner = new Scanner(System.in);

        // Enter number of years
        System.out.println("Enter number of years (7, 15 and 30 only):");
        numOfYears = scanner.nextInt();

        // Find interest rate based on year
        if (numOfYears == 7) {
            annualInterestRate = 7.25;
        } else if (numOfYears == 15) {
            annualInterestRate = 8.50;
        } else if (numOfYears == 30) {
            annualInterestRate = 9.0;
        } else {
            System.out.println("Wrong Number of Years");
            System.exit(0);
        } // End else

        // Calculate monthly interest rate
        double monthlyInterestRate = annualInterestRate / 1200;

        // Enter loan amount
        System.out.println("Enter loan amount, for example 120000.95: ");

        // Parse inputLoan from a string to an Double
        loanAmount = scanner.nextDouble();

        // Compute mortgage
        double monthlyPayment = loanAmount * monthlyInterestRate
                / (1 - (Math.pow(1 / (1 + monthlyInterestRate), numOfYears * 12)));
        double totalPayment = monthlyPayment * numOfYears * 12;

        // Create a string which will hold the details of the mortgage
        String output = "The monthly payment is " + (int) (monthlyPayment * 100) / 100.0;
        output += "\nThe total payment is " + (int) (totalPayment * 100) / 100.0;

        // Display the mortgage details
        System.out.println(output);

        // Exit the program
        System.exit(0);

    }// End Main Method

}// End TestIfElse class
