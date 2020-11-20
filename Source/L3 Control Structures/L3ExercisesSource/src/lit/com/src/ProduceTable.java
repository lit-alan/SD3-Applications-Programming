package lit.com.src;

import java.util.Scanner;

/**
 *
 * @author Alan.Ryan
 */
public class ProduceTable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter positive value");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j * i + "\t");
            }

            System.out.println("");

        }//end for
    }

}
