/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sd3.java.lit.com;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Alan.Ryan
 */
public class Exercise3 {

  
    public static void main(String[] args) {
        int rands[] = new int[5000];
        int min = 5;
        int max = 50;
        boolean flag = false;
        
        for (int i = 0; i < rands.length; i++) {
            rands[i] = ThreadLocalRandom.current().nextInt(min, max + 1);
        }
        
        for (int i = 0; i < rands.length; i++) {
            
            if (i % 20 == 0)
                System.out.println("");
            
            System.out.print(rands[i] + "\t");
            
        }
        
        System.out.println("\n\n");
        
        for (int i = 0; i < rands.length; i++) {
            
            if ((rands[i] % 8==0) &&  (rands[i] % 7==0)&& (rands[i] % 6==0))  {
                System.out.println(rands[i] + " at index " + i + " is a multiple of 6, 7 and 8");
                flag = true;
            }

        }
        
        if (!flag)
            System.out.println("\nThere were no numbers in the array that are multiples of 6, 7 and 8 ");
        
    }
    
}
