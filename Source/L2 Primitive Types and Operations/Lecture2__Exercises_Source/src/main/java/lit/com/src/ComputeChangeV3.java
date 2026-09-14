package lit.com.src;
import java.util.Scanner;

public class ComputeChangeV3  {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Receive the amount entered from the keyboard
        System.out.print("Please enter your amount: ");
        double amount = sc.nextDouble();

        int remainingAmount = (int) Math.round(amount * 100);

        //Euro coin denominations in cents
        int[] denominations = {200, 100, 50, 20, 10, 5, 2, 1};
        String[] names = {
                "2 Euro pieces", "1 Euro pieces",
                "50 cent pieces", "20 cent pieces",
                "10 cent pieces", "5 cent pieces",
                "2 cent pieces", "1 cent pieces"
        };

        //print report
        System.out.println("\nYour amount " + amount + " consists of:");
        for (int i = 0; i < denominations.length; i++) {
            int count = remainingAmount / denominations[i];
            remainingAmount %= denominations[i];
            System.out.printf("%-5d %s%n", count, names[i]);
        }

        System.exit(0);
    }
}