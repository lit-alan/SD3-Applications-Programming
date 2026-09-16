/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lit.com.src;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

/**
 *
 * @author Alan.Ryan
 */
public class Exercise1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        NumberFormat currencyForm = NumberFormat.getCurrencyInstance();
        //System.out.println(currencyForm.format(12345.67)); will print €12,345.67

        Scanner sc = new Scanner(System.in);

        System.out.println("\t\tWELCOME TO TUS CARPARKS\n");
        System.out.println("Enter duration of stay (enter -1 to quit)");

        double duration = sc.nextDouble();

        while (duration != -1) {
            System.out.println("Charge is " + currencyForm.format(calculateCharges(duration)));

            System.out.println("\nEnter duration of stay (enter -1 to quit)");

            duration = sc.nextDouble();
        }
        
        System.out.println("GOODBYE");

    }

    static double calculateCharges(double duration) {
        double totalCharge = 2.0;

        if (duration > 3) {
            totalCharge += (Math.ceil(duration) - 3) * 0.5;
        }

        if (totalCharge > 10.00) {
            totalCharge = 10.00;
        }

        return totalCharge;
    }

}
