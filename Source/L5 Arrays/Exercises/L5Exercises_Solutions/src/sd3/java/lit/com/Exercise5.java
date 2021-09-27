package sd3.java.lit.com;

import java.text.DecimalFormat;
import java.util.Random;

public class Exercise5 {
    
    static DecimalFormat twoDigits = new DecimalFormat("0.00");

    static String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun"};
    static String[] brands = {"BMW", "Ford", "Honda", "Kia", "Nissan", "Opel", "Seat", "Skoda", "Toyota", "Volvo"};
    static int[][] sales = new int[10][6];
   
    static int[] monthlyTotals = new int[months.length];
    static int[] brandTotals = new int[brands.length];
    static double[] brandAverages = new double[brands.length];
           
    public static void main(String[] args) {

        fillArray();
        
        calculateBrandTotals();
        
        calculateBrandAverages();
     
        printData();

        for (int i = 0; i < months.length; i++)
            calculateMonthTotals(i);
        
        printMonthTotals();

        printLargestSales();

        printSmallestSales();
        
        outputMonthOnMonthIncr();

    }//end main()

    /////////////////////////////////////////////////////////////////////////////
    
    private static void fillArray() {
        Random r = new Random();

        for (int row = 0; row < brands.length; row++) {
            for (int col = 0; col < months.length; col++) {
                sales[row][col] = r.nextInt(50);
            }//end for
        }//end for
    }//end fillArray()

    /////////////////////////////////////////////////////////////////////////////
    
    private static void printData() {

        System.out.print("\t");
        for (int i = 0; i < months.length; i++) {
            System.out.print(months[i] + "\t");
        }//end for

        System.out.println("TOT\tAVG");

        for (int row = 0; row < brands.length; row++) {
            System.out.print(brands[row] + "\t");
            for (int col = 0; col < months.length; col++) {
                System.out.print(sales[row][col] + "\t");
            }//end for
            
            System.out.println(brandTotals[row] + "\t" + twoDigits.format(brandAverages[row]));
        
        }//end for
    
    }//end printData()

    /////////////////////////////////////////////////////////////////////////////
    
    private static void printLargestSales() {

        int largestValue = sales[0][0];
        String largestBrand = "", largestMonth = "";

        for (int row = 0; row < brands.length; row++) {
            for (int col = 0; col < months.length; col++) {
                if (sales[row][col] > largestValue) {
                    largestValue = sales[row][col];
                    largestBrand = brands[row];
                    largestMonth = months[col];
                }//end if
            }//end for
        }//end for

        System.out.println("The brand with the highest sales value was "
                + largestBrand + " with " + largestValue + " "
                + "unit(s) sold in the month of " + largestMonth);

    }//end printLargestSales()

    /////////////////////////////////////////////////////////////////////////////
    
    private static void printSmallestSales() {

        int smallestValue = sales[0][0];
        String smallestBrand = "", smallestMonth = "";

        for (int row = 0; row < brands.length; row++) {
            for (int col = 0; col < months.length; col++) {
                if (sales[row][col] < smallestValue) {
                    smallestValue = sales[row][col];
                    smallestBrand = brands[row];
                    smallestMonth = months[col];
                }//end if
            }//end for
        }//end  for

        System.out.println("The brand with the smallest sales value was "
                + smallestBrand + " with " + smallestValue + " "
                + "unit(s) sold in the month of " + smallestMonth);

    }//end printSmallestSales()

    /////////////////////////////////////////////////////////////////////////////
    
    private static void calculateMonthTotals(int col) {

        for (int row = 0; row < brands.length; row++) {
            monthlyTotals[col] += sales[row][col];
        }//end for
    }//end calculateMonthTotals

    /////////////////////////////////////////////////////////////////////////////
    
    private static void printMonthTotals() {
        System.out.print("TOTALS\t");
        
        //also going to calculate and display the overall sales total here
        int overallTotalSales = 0;

        for (int i = 0; i < monthlyTotals.length; i++) {
            overallTotalSales += monthlyTotals[i];
            System.out.print(monthlyTotals[i] + "\t");
        }//end for
        
        System.out.println("\n\nTotal Cars Sold: " + overallTotalSales + "\n");
        
    }//end printMonthTotals()

    /////////////////////////////////////////////////////////////////////////////
    
    private static void calculateBrandTotals() {
        for (int row = 0; row < brands.length; row++) {
            for (int col = 0; col < months.length; col++) {
                 brandTotals[row] += sales[row][col];
            }//end for
        }//end for    
    }//end calculateBrandTotals

    /////////////////////////////////////////////////////////////////////////////
    
    
   private static void calculateBrandAverages() {
       for (int i = 0; i < brandTotals.length; i++) {
            brandAverages[i] = (brandTotals[i] / (double) months.length);
        }//end for
    }//end calculateBrandAverages()

    /////////////////////////////////////////////////////////////////////////////
   
   private static void outputMonthOnMonthIncr() {

        System.out.println("\nBrands with a month on month increase include");
        for (int row = 0; row < brands.length; row++) {
            for (int col = 0; col < months.length; col++) {
                if (col==5) break; //need this check or the code will crash as I will end up trying to index a non-existent row element
                if (sales[row][col] < sales[row][col+1])
                        System.out.println(brands[row] + " for "  + months[col] + " and " + months[col+1]);
            }//end for
        }//end for
    }//end outputMonthOnMonthIncr()

}//end class Exercise5