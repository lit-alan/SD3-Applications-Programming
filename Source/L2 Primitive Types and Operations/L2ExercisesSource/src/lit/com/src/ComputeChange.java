package lit.com.src;

// ComputeChange.java: Break down an amount into smaller units
import java.util.Scanner;

public class ComputeChange {

  public static void main(String[] args) {
    double amount; 
    String input;

    Scanner sc = new Scanner(System.in);
    
    // Receive the amount entered from the keyboard
    System.out.println("Please enter your amount");
    amount = sc.nextDouble();
	
    int remainingAmount = (int)(amount*100);

    // Find the number of two Euro in the remaining amount
    int numOfTwoEuro = remainingAmount/200;
    remainingAmount = remainingAmount%200;
    
    // Find the number of one Euro coins in the remaining amount
    int numOfOneEuro = remainingAmount/100;
    remainingAmount = remainingAmount%100;

	// Find the number of 50's in the remaining amount
    int numOf50 = remainingAmount/50;
    remainingAmount = remainingAmount%50;

    // Find the number of 20's in the remaining amount
    int numOf20 = remainingAmount/20;
    remainingAmount = remainingAmount%20;

    // Find the number of 10's in the remaining amount
    int numOf10 = remainingAmount/10;
    remainingAmount = remainingAmount%10;

    // Find the number of 5's in the remaining amount
    int numOf5 = remainingAmount/5;
    remainingAmount = remainingAmount%5;
    
    // Find the number of 2's in the remaining amount
    int numOf2 = remainingAmount/2;
    remainingAmount = remainingAmount%2;

    // Find the number of 1's in the remaining amount
    int numOf1 = remainingAmount;

    // Display results
    String output = "\nYour amount " + amount + " consists of ";
    output += "\n" + numOfTwoEuro + "    2 Euro pieces";
    output += "\n" + numOfOneEuro + "    1 Euro pieces";
    output += "\n" + numOf50 + "    50 cent pieces";
    output += "\n" + numOf20 + "    20 cent pieces";
    output += "\n" + numOf10 + "    10 cent pieces";
    output += "\n" + numOf5 + "     5 cent pieces";
    output += "\n" + numOf2 + "     2 cent pieces";
    output += "\n" + numOf1 + "     1 cent pieces\n";
    
    System.out.println(output);
    
    System.exit(0);
  }
}
