package lit.com.src;

// ComputeChangeV2.java: Break down an amount into smaller units
import java.util.Scanner;

public class ComputeChangeV2 {

    static int remainingAmount = 0;

    public static void main(String[] args) {
        double amount;
        String input;

        Scanner sc = new Scanner(System.in);

        //Receive the amount entered from the keyboard
        System.out.println("Please enter your amount");
        amount = sc.nextDouble();

        remainingAmount = (int)(amount*100);

        //Display results
        String output = "\nYour amount " + amount + " consists of ";
        output += "\n" + determineNumberOfCoins(200) + "\t 2 Euro pieces";
        output += "\n" + determineNumberOfCoins(100) + "\t 1 Euro pieces";
        output += "\n" + determineNumberOfCoins(50) +  "\t 50 cent pieces";
        output += "\n" + determineNumberOfCoins(20) +  "\t 20 cent pieces";
        output += "\n" + determineNumberOfCoins(10) +  "\t 10 cent pieces";
        output += "\n" + determineNumberOfCoins(5) +   "\t 5 cent pieces";
        output += "\n" + determineNumberOfCoins(2) +   "\t 2 cent pieces";
        output += "\n" + determineNumberOfCoins(1) +   "\t 1 cent pieces\n";

        System.out.println(output);

        System.exit(0);
    }

    // Find the number of two Euro in the remaining amount using a method
    public static int determineNumberOfCoins(int coin) {
        int numOfCoins = remainingAmount/coin;
        remainingAmount = remainingAmount%coin;
        return numOfCoins;
    }
}