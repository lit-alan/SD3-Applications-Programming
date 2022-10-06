package com.lit.src;

import javax.swing.*;
import java.util.Scanner;

public class TestWhile {

  public static void main(String[] args) {
    String input;
    int number, sum= 0, count = 0;

    //Create a scanner
    Scanner scan = new Scanner(System.in);


	count++;
    // Read an initial data
    System.out.println("Enter Number " + count);
  	number = scan.nextInt();


    // Keep reading data until the input is 0
    while (number != 0) {
      sum += number;
	  count++;
      System.out.println("Enter Number " + count + " - The Program Ends When You Enter 0");
	  number = scan.nextInt();

    }//end while
    count--;
    System.out.println("The Sum is " + sum + "\nNumbers Entered =  " + count );


    System.exit(0);
  }
}
