package Lecture2;

import javax.swing.*;
import java.text.*;

public class ComputeArea {
  /**Main method*/
  public static void main(String[] args) {
    String input;
    double radius, area;

    DecimalFormat twoDigits = new DecimalFormat("0.00");

    // Prompt the user to enter radius
    input = JOptionPane.showInputDialog("Enter Radius");
    radius = Double.parseDouble(input);

    // Compute area
    area = radius*radius*3.14159;

    // Display results

    JOptionPane.showMessageDialog(null, "The area for the circle of radius " +
      radius + " is " + twoDigits.format(area),"Result", JOptionPane.INFORMATION_MESSAGE);

      System.exit(0);

  }
}