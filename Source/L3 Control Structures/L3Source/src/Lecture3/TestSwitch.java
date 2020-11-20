package Lecture3;

import java.util.Scanner;
import javax.swing.*;

public class TestSwitch {

    public static void main(String args[]) {
        int days = 0;
        String ans;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a Month");
        int month = scanner.nextInt();

        switch (month) {
            case 9:
            case 4:
            case 6:
            case 11:
                days = 30;
                break;
            case 2: {
                System.out.println("Is This A Leap Year Y/N");
                ans = scanner.next();
                if (ans.equalsIgnoreCase("Y")) {
                    days = 29;
                } else {
                    days = 28;
                }
            }
            break;
            default:
                days = 31;
                break;

        }
        System.out.println("There are " + days + " days " + " in the month");
        System.exit(0);

    }
}
