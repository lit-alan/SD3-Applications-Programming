package supplementary_exercises;

import java.util.Random;

public class Exercise1 {

    static Random r = new Random();
    static int[][] matrixA = new int[10][5];
    static int[][] matrixB = new int[10][5];

    public static void main(String[] args) {
        
        setUpData(matrixA);
        setUpData(matrixB);
        
        System.out.println("Matrix A");
        printData(matrixA);
        System.out.println("\nMatrix B");
        printData(matrixB);
        
        int[][] addMatrices = addMatrices(matrixA, matrixB);
        
        System.out.println("\nAddition of Matrix A and Matrix B");
        printData(addMatrices);
 
    }

    private static void setUpData(int[][] matrix) {
       
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < 5; col++) {
                matrix[row][col] = r.nextInt(100);
            }//end for
        }//end for
      
    }

    private static void printData(int[][] matrix) {
    
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < 5; col++) {
                System.out.print(matrix[row][col] + "\t");
            }//end for
            System.out.println("");
        }//end for
    }

    private static int[][] addMatrices(int[][] matrixA, int[][] matrixB) {
        
        int[][] addMatrices = new int[10][5];
        for (int row = 0; row < addMatrices.length; row++) {
            for (int col = 0; col < 5; col++) {
                addMatrices[row][col] = matrixA[row][col] + matrixB[row][col];
                
            }
        }
        
        return addMatrices;
        
    }

}
;