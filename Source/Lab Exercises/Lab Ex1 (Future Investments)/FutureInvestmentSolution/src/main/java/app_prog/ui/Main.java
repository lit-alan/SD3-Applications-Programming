package app_prog.ui;

import app_prog.model.Investment;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;


public class Main {

    public static void main(String[] args) {
        // create an array list to store the calculations
        ArrayList<Investment> investments = new ArrayList(5);


        // displayLine a welcome message
        Console.displayLine("Welcome to the Future Value Calculator");
        Console.displayLine();
        String choice = "y";
        String header = "";

        while (choice.equalsIgnoreCase("y")) {

            // get input from user
            double monthlyInvestment
                    = Console.getDouble("Enter monthly investment:   ");
            double yearlyInterestRate
                    = Console.getDouble("Enter yearly interest rate: ");
            int years
                    = Console.getInt("Enter number of years:      ");

            investments.add(new Investment(monthlyInvestment, yearlyInterestRate, years));

            // see if the user wants to continue
            choice = Console.getString("Continue? (y/n): ");
            Console.displayLine();
        }

        // get the currency and percent formatters
       // Locale l = new Locale("pt", "BR");
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        NumberFormat percent = NumberFormat.getPercentInstance();
        percent.setMinimumFractionDigits(2);

        header = "Future Value Calculations";
        displayInvestmentDetails(header, investments, currency, percent);

        for (Investment i : investments) {
            
            i.setYearlyInterestRate((i.getYearlyInterestRate() * 1.02));

        }

        header = "Future Value Calculations If Rate Increased by 2%";
        displayInvestmentDetails(header, investments, currency, percent);

        ArrayList<Investment> soundInvestments = new ArrayList<>();

        for (Investment i : investments) {

            if (i.calculateFutureValue() > 25000) {
                soundInvestments.add(i);
            }

        }
        
                
//        investments = soundInvestments;
//        soundInvestments = null;

        header = "Future Value Calculations If We Remove All Investments < 25000";
        displayInvestmentDetails(header, soundInvestments, currency, percent);
        Console.displayLine("Bye!");
    }

    private static void displayInvestmentDetails(String header, ArrayList<Investment> investments, NumberFormat currency, NumberFormat percent) {

        String result = "";

        for (Investment i : investments) {

            // format the calculations for each investment
            result += currency.format(i.getMonthlyInvestment()) + "\t"
                    + percent.format(i.getYearlyInterestRate() / 100) + "\t"
                    + i.getYears() + "\t"
                    + currency.format(i.calculateFutureValue()) + "\n";

        }

        Console.displayLine(header);
        Console.displayLine("Inv/Mo.\tRate\tYears\tFuture Value");

        Console.displayLine(result);

        Console.displayLine();
        Console.displayLine();
    }
}
