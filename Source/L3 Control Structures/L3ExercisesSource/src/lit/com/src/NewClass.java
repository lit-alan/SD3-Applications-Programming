package lit.com.src;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class NewClass {
    
    static int[][] array = null;
    static final int ROW = 10;
    static final int COL = 15;
    public static void main(String[] args) {
        
        array  = initArray(ROW,COL);
        print(array);

        printAdjacentSum(45, array);
        
        
        System.out.println("\nRange for each row:");
        for (int i = 0; i < array.length; i++) {
            printRange(array[i],i);
        }
        
    }

    public static void print(int[][] array) {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
              
                System.out.print( array[i][j] + "\t");
            }
            System.out.println("");
        }

    }

    private static int[][] initArray(int x, int y) {
        int rand = 0;
        int[][] array = new int [x][y];
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                
                if (i == 0 || i == 1) {
                    rand = ThreadLocalRandom.current().nextInt(1,100 + 1);
                
                    array[i][j] = rand;
                }
                else {
                    do {
                        rand = ThreadLocalRandom.current().nextInt(1,100 + 1);
                        
                    } while(rand % i !=0);
                    
                     array[i][j] = rand;
                }
                
            }
         }
        
        return array;
    }

    private static void printRange(int array[], int row) {

        Arrays.sort(array);

        int range = array[array.length - 1] - array[0];

        System.out.println("Range for row " + row + " is " + range);
    }
    
   private static void printAdjacentSum(int sum, int[][] array) {
       
         boolean flag = false;
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < 15; col++) {
                int temp = col + 1;
//                System.out.print("ROW [" + row + "] COL [" + col + "]");
//                System.out.print("\tROW [" + row + "] COL [" + temp + "]");
//                System.out.println("");
                if (col == 14)
                    break;
                else if (array[row][col] + array[row][temp] == sum) {
                System.out.print("The adjacent values at ROW[" + row + "] COL[" + col + "]");
               System.out.print(" and ROW[" + row + "] COL[" + temp + "] sum to " + sum + "\n");
//                    System.out.print(" YES ");
                }
            }
           // System.out.println("");
        }   

   }
}
