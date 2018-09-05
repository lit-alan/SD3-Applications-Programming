package Lecture3;

import javax.swing.*;

public class TestWhile {

  public static void main(String[] args) {
    String input;
    int number, sum= 0, count = 0;

	count++;
    // Read an initial data
	input = JOptionPane.showInputDialog("Enter Number " + count);
  	number = Integer.parseInt(input);


    // Keep reading data until the input is 0
    while (number != 0) {
      sum += number;
	  count++;
	  input = JOptionPane.showInputDialog("Enter Number " + count + " - The Program Ends When You Enter 0");
	  number = Integer.parseInt(input);

    }//end while
    count--;
    JOptionPane.showMessageDialog(null, "The Sum is " + sum + "\nNumbers Entered =  " + count  ,"Results", JOptionPane.INFORMATION_MESSAGE);

    System.exit(0);
  }
}
