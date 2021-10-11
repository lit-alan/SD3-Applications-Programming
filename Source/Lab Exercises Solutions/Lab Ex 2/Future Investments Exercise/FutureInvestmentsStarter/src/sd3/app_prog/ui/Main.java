package sd3.app_prog.ui;

import java.text.NumberFormat;

public class Main {

    public static void main(String[] args) {
        

        // displayLine a welcome message
        Console.displayLine("Welcome to the Future Value Calculator");
        Console.displayLine();
        String choice = "y";


        while (choice.equalsIgnoreCase("y")) {

            // get input from user
            double monthlyInvestment
                    = Console.getDouble("Enter monthly investment:   ");
            double yearlyInterestRate
                    = Console.getDouble("Enter yearly interest rate: ");
            int years
                    = Console.getInt("Enter number of years:      ");

       

            // see if the user wants to continue
            choice = Console.getString("Continue? (y/n): ");
            Console.displayLine();
        }


 
        Console.displayLine("Bye!");
    }

}