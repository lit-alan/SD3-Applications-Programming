/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import interfaces.MathOperation;

import java.util.Random;

/**
 *
 * @author alan.ryan
 */
public class LabEx4_Main {

    public static void main(String[] args) {

        //task one 
        MathOperation mod = (int a, int b) -> a % b;
        System.out.println("10 mod 5 = " + operate(10, 5, mod));
		
        //task two
        MathOperation rand = (int min, int max)
                -> {
            Random r = new Random();
            return r.nextInt((max - min) + 1) + min;
        };

        System.out.println("Rand Value between 0 and 20 is " + operate(0, 20, rand));

        
        //task three
	    MathOperation add2 = (int a, int b) -> a + b;
        System.out.println("3 + 4 + 1 = " + operate(operate(3, 4, add2), 1, add2));

        //task four
		MathOperation mult2 = (int a, int b) -> a * b;
        System.out.println("2 * 2 * 2 = " + operate(operate(2, 2, mult2), 2, mult2));

        //task five
        MathOperation larger = (int a, int b)
                -> (a > b) ? a : b; //ternary operator (aka short hand if-else statement)

//        {
//            if (a > b) {
//                return a;
//            } else {
//                return b;
//            }
//        };

        System.out.println("Larger of 3 and 4 is " + operate(4, 3, larger));

        //task six
        MathOperation smaller = (int a, int b)
                -> (a < b) ? a : b;

        System.out.println("Smaller of 3 and 4 is " + operate(4, 3, smaller));

        //task seven
        System.out.println("Larger of 3, 4 and 5 is " + operate(operate(4, 3, larger), 5, larger));

        //task eight
        System.out.println("Smaller of 3, 4 and 5 is " + operate(operate(4, 3, smaller), 5, smaller));
    }

    static int operate(int a, int b, MathOperation operation) {
        return operation.test(a, b);
    }

}
