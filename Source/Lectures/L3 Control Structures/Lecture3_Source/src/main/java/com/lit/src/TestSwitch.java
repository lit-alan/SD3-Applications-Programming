package com.lit.src;

import javax.swing.*;
import java.util.Scanner;

public class TestSwitch {
	public static void main(String args[]) {
		int days = 0;
		String ans;

		//Create a scanner
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter Month");
		int month = scan.nextInt();


		switch (month) {
		case 9:
 		case 4:
		case 6:
		case 11: days = 30; break;
		case 2: {
				System.out.println("Is this a leap year Y/N?");
				ans = scan.next();
				if (ans.equals("Y"))
					days = 29;
				else
					days = 28;
		   		} break;
		default: days = 31; break;



	}

	System.out.println("There are " + days + " days " + " in the month");
	System.exit(0);

	}
}
