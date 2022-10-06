package com.lit.src;

import java.util.Arrays;

public class TestVarArgs {
     
    public static void main(String[] args) {
        int a = 5;
        int b = 2;
        int c = 8;
        int d = 7;
        System.out.println("largest of " + max(a,b));
        System.out.println("largest is " + max(a,b,c));
        System.out.println("largest is " + max(a,b,c,d));
                
       

    }//end main

    static int max(int... values) {
        Arrays.sort(values);
        return values[values.length-1];
    }//end max		
}
