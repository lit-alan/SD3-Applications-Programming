package Lecture5;

import java.util.Scanner;
import javax.swing.*;

public class TestArray {
  /**Main method*/
  public static void main(String[] args) {
      
    Scanner sc = new Scanner(System.in);
            
    int[] number = new int[6];

    // Read all numbers
    for (int i=0; i<number.length; i++) {
        System.out.println("Enter Number " + (i+1));
        number[i] = sc.nextInt();
    }//end for

    // Find the largest number
    int max = number[0];
    for (int i=1; i<number.length; i++) {
      if (max < number[i])
        max = number[i];
    }//end for

    // Find the occurrence of the largest number
    int count = 0;
    for (int i=0; i<number.length; i++) {
      if (number[i] == max) count++;
    }// end for

    // Display the result
    String output = "\nThe array is ";
    for (int i=0; i<number.length; i++) {
      output += number[i] + " ";
    }//end for


    output += "\nThe largest number is " + max;
    output += " - its occurs "  + count + " times in the sequence";
    System.out.println(output);
    System.exit(0);

  }//end main
}//end class TestArray