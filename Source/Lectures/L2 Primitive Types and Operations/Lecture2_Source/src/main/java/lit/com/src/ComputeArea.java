package lit.com.src;

import java.text.NumberFormat;
import java.util.Scanner;

public class ComputeArea {

    public static void main(String[] args) {
        double radius, area;

        NumberFormat twoDigits = NumberFormat.getNumberInstance();

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
