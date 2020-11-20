package Lecture2;

import java.text.DecimalFormat;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author alan.ryan
 */
public class ComputeAreaV2 {

    public static void main(String[] args) {
        double radius, area;

        DecimalFormat twoDigits = new DecimalFormat("0.00");

        // Prompt the user to enter radius
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a radius");
        radius = scan.nextDouble();

        // Compute area
        area = radius * radius * 3.14159;

        // Display results
        System.out.println("The area for the circle of radius "+ radius + " is " + twoDigits.format(area));
        

        System.exit(0);

    }
}
