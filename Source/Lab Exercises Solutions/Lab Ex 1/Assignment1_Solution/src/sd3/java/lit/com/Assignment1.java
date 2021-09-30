package sd3.java.lit.com;

import java.text.NumberFormat;
import java.util.concurrent.ThreadLocalRandom;

public class Assignment1 {

    String[] stations = {"Acton Town", "Angel", "Arsenal", "Baker Street", "Camden Town", "Charing Cross",
        "Ealing Broadway", "Earls Court", "Elephant & Castle", "Kilburn", "Leicester Square",
        "Liverpool Street", "Oxford Circus", "Paddington", "Piccadilly Circus", "Tooting",
        "Vauxhall", "Victoria", "Wembley Park", "Wimbledon"};

    String[] headers = {"Weekday", "Saturday", "Sunday", "Weekday", "Saturday", "Sunday"};

    int[][] data = new int[stations.length][headers.length];

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void main(String[] args) {
        new Assignment1();
    }//end main


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public Assignment1() {

        fillData(data);

        printData(data);

        findBusiestStation(data);

        findPercChange(data);
        
    }//end constructor

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    private void fillData(int[][] data) {

        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < headers.length; col++) {
                switch (col) {
                    case 0:
                    case 3://weekday
                        data[row][col] = ThreadLocalRandom.current().nextInt(50000, 140000 + 1);
                        break;
                    case 1:
                    case 4: //Saturday
                        data[row][col] = ThreadLocalRandom.current().nextInt(30000, 80000 + 1);
                        break;
                    default: //Sunday
                        data[row][col] = ThreadLocalRandom.current().nextInt(5000, 15000 + 1);
                        break;
                }//end switch
            }//end for
        }//end for

    }//end fillData()

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void printData(int[][] data) {

        System.out.format("%38s%35s\n", "Jan-Jun", "Jul-Dec");

        System.out.format("%-20s", " ");
        for (int i = 0; i < headers.length; i++) {
            System.out.format("%-10s", headers[i]);
            if (i == 2) {
                System.out.format("%-5s", "|");
            }
        }

        System.out.println("");

        for (int row = 0; row < data.length; row++) {
            System.out.format("%-20s", stations[row]);
            for (int col = 0; col < headers.length; col++) {
                System.out.format("%-10d", data[row][col]);

                if (col == 2) {
                    System.out.format("%-5s", "|");
                }//end if
            }//end for
            System.out.println("");
        }//end for
    }//end method printData()

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void findBusiestStation(int[][] data) {

        int[] entryTotals = new int[stations.length];

        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < headers.length; col++) {
                entryTotals[row] += data[row][col];
            }//end for
        }//end for

        int largest = entryTotals[0];
        int largestStation = 0;

        for (int i = 0; i < stations.length; i++) {

            if (entryTotals[i] > largest) {
                largest = entryTotals[i];
                largestStation = i;
            }//end if
        }//end for

        System.out.println("The busiest station is " + stations[largestStation] + " with " + largest + " passengers");

    }//end method findBusiestStation()

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void findPercChange(int[][] data) {

        NumberFormat percForm = NumberFormat.getPercentInstance();
        
        percForm.setMaximumFractionDigits(2);

        int[][] sixMonthTotals = new int[stations.length][2];

        //Jan - Jun
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < 3; col++) {
                sixMonthTotals[row][0] += data[row][col];
            }//end for
        }//end for

        //July - Dec
        for (int row = 0; row < data.length; row++) {
            for (int col = 3; col < headers.length; col++) {
                sixMonthTotals[row][1] += data[row][col];
            }//end for
        }//end for

        //^^small bit of repetition above. Could be reengineered as a single method with two separate calls
        
        double[] percentChange = new double[stations.length];

        for (int row = 0; row < sixMonthTotals.length; row++) {
            for (int col = 0; col <= 1; col++) {
                int diff = sixMonthTotals[row][1] - sixMonthTotals[row][0];
                percentChange[row] = (double) diff / sixMonthTotals[row][0];
            }//end for
        }//end for

        System.out.println("\nPercentage increase/decrease");
        for (int i = 0; i < data.length; i++) {
            System.out.println(stations[i] + ": " + percForm.format(percentChange[i]));
        }//end for

    }//end method findPercChange()
    
}//end class
