package Lecture2;

import javax.swing.*;
import java.text.*;
import java.util.Scanner;

public class ComputeArea {

    /**
     * Main method
     */
    public static void main(String[] args) {
        String input;
        double radius, area;

        DecimalFormat twoDigits = new DecimalFormat("0.00");

        Scanner scanner = new Scanner(System.in);  // Create a Scanner object

        // Prompt the user to enter radius
        System.out.println("Enter radius");

        radius = scanner.nextInt();

        // Compute area
        area = radius * radius * 3.14159;

        // Display results
        System.out.println("The area for the circle of radius " + radius + " is " + twoDigits.format(area));

        System.exit(0);

    }
}
