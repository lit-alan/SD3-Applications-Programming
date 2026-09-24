package app_prog.ui;

import app_prog.model.Investment;
import java.text.NumberFormat;
import java.util.Locale;

public class MainV1 {

    public static void main(String[] args) {

        // create an array to store the investments
        Investment[] investments = new Investment[5];
        int investmentCount = 0;

        // display a welcome message
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

            // add the investment to the array
            investments[investmentCount]
                    = new Investment(monthlyInvestment, yearlyInterestRate, years);

            investmentCount++;

            // see if the user wants to continue
            choice = Console.getString("Continue? (y/n): ");
            Console.displayLine();
        }

        // get the currency and percent formatters
      NumberFormat currency = NumberFormat.getCurrencyInstance();

        NumberFormat percent = NumberFormat.getPercentInstance();
        percent.setMinimumFractionDigits(2);

        String header = "Future Value Calculations";

        displayInvestmentDetails(
                header, investments, investmentCount, currency, percent);

        // increase the interest rate by 2%
        for (int i = 0; i < investmentCount; i++) {

            investments[i].setYearlyInterestRate(
                    1.02 * investments[i].getYearlyInterestRate()
            );
        }

        header = "Future Value Calculations If Rate Increased by 2%";

        displayInvestmentDetails(
                header, investments, investmentCount, currency, percent);

        // create an array to store investments with a future value > 25000
        Investment[] soundInvestments = new Investment[investmentCount];
        int soundInvestmentCount = 0;

        for (int i = 0; i < investmentCount; i++) {

            if (investments[i].calculateFutureValue() > 25000) {

                soundInvestments[soundInvestmentCount] = investments[i];
                soundInvestmentCount++;
            }
        }

        header = "Future Value Calculations If We Remove All Investments < 25000";

        displayInvestmentDetails(
                header, soundInvestments, soundInvestmentCount, currency, percent);

        Console.displayLine("Bye!");
    }

    private static void displayInvestmentDetails(
            String header,
            Investment[] investments,
            int investmentCount,
            NumberFormat currency,
            NumberFormat percent) {

        String result = "";

        for (int i = 0; i < investmentCount; i++) {

            Investment investment = investments[i];

            // format the calculations for each investment
            result += currency.format(investment.getMonthlyInvestment()) + "\t"
                    + percent.format(investment.getYearlyInterestRate() / 100) + "\t"
                    + investment.getYears() + "\t"
                    + currency.format(investment.calculateFutureValue())
                    + "\n";
        }

        Console.displayLine(header);
        Console.displayLine("Inv/Mo.\tRate\tYears\tFuture Value");
        Console.displayLine(result);
        Console.displayLine();
        Console.displayLine();
    }
}