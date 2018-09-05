package Lecture3;

import javax.swing.*;

public class TestSwitch {
	public static void main(String args[]) {
		int days = 0;
		String ans;

		String input = JOptionPane.showInputDialog("Enter Month");
		int month = Integer.parseInt(input);


		switch (month) {
		case 9:
 		case 4:
		case 6:
		case 11: days = 30; break;
		case 2: {
				ans = JOptionPane.showInputDialog("Is This A Leap Year Y/N");
				if (ans.equals("Y"))
					days = 29;
				else
					days = 28;
		   		} break;
		default: days = 31; break;



	}
	JOptionPane.showMessageDialog(null, "There are " + days + " days " + " in the month", "Result", JOptionPane.INFORMATION_MESSAGE);
	System.exit(0);

	}
}
