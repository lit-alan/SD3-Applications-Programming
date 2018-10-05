package sd4.dobs.ui;

import java.text.NumberFormat;
import java.util.ArrayList;
import sd4.dobs.model.Investment;

public class Main {

    public static void main(String[] args) {
        // create an array list to store the calculations
        ArrayList<Investment> investments = new ArrayList<>();

        // displayLine a welcome message
        Console.displayLine("Welcome to the Future Value Calculator");
        Console.displayLine();
        String result = "";
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
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        NumberFormat percent = NumberFormat.getPercentInstance();
        percent.setMinimumFractionDigits(2);

        header = "Future Value Calculations";
        displayInvestmentDetails(header, investments, result, currency, percent);

        for (Investment i : investments) {
            
            i.setYearlyInterestRate(( (double) 102 / 100) * ( (double) i.getYearlyInterestRate() / 1));

        }

        header = "Future Value Calculations If Rate Increased by 2%";
        displayInvestmentDetails(header, investments, result, currency, percent);

        ArrayList<Investment> soundInvestments = new ArrayList<>();

        for (Investment i : investments) {

            if (i.calculateFutureValue() > 25000) {
                soundInvestments.add(i);
            }

        }
        
                
        investments = soundInvestments;
        soundInvestments = null;

        header = "Future Value Calculations If We Remove All Investments < 25000";
        displayInvestmentDetails(header, investments, result, currency, percent);
        Console.displayLine("Bye!");
    }

    private static void displayInvestmentDetails(String header, ArrayList<Investment> investments, String result, NumberFormat currency, NumberFormat percent) {
        for (Investment i : investments) {

            // format the calculations for each investment
            result += currency.format(i.getMonthlyInvestment()) + "\t"
                    + percent.format(i.getYearlyInterestRate() / 100) + "\t"
                    + Integer.toString(i.getYears()) + "\t"
                    + currency.format(i.calculateFutureValue()) + "\n";

        }

        Console.displayLine(header);
        Console.displayLine("Inv/Mo.\tRate\tYears\tFuture Value");

        Console.displayLine(result);

        Console.displayLine();
        Console.displayLine();
    }
}
