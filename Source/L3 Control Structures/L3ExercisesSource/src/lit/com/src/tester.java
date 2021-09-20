/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lit.com.src;

/**
 *
 * @author Alan.Ryan
 */
public class tester {
    public static void main(String[] args) {
        int[][] arr = {
            
                        {20,10,16, 20, 25},
                        {20,5,0, 20, 25},
                        {5,40,4, 1, 1},
                        {4,1,16, 20, 257},
                      };
        
        printAdjacentSum(5, arr);
    }
    
     private static void printAdjacentSum(int sum, int[][] array) {
        boolean flag = false;
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < 5; col++) {
                int temp = col + 1;
//                System.out.print("ROW [" + row + "] COL [" + col + "]");
//                System.out.print("\tROW [" + row + "] COL [" + temp + "]");
//                System.out.println("");
                if (col == 4)
                    break;
                else if (array[row][col] + array[row][temp] == sum) {
                    System.out.println(array[row][col] + " " + array[row][col+1] );
                   // int temp = col++;
                    System.out.println("The adjacent values at ROW[" + row +  "] COL["+ col + "] sum to " + sum);
                     System.out.println("The adjacent values at ROW[" + row +  "] COL["+ temp + "] sum to " + sum);
                    flag = true;
                }
            }
           // System.out.println("");
        }
}
}
