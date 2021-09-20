package lit.com.src;

import java.util.Scanner;

public class PrintDateSuccessor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Day");
        int d = sc.nextInt();

        System.out.println("Enter Month");
        int m = sc.nextInt();

        System.out.println("Enter Year");
        int y = sc.nextInt();

        int ndays;

        //generate sucessor date
        //set ndays equal to the number of days in m
        switch (m) {
            case 4:
            case 6:
            case 9:
            case 11:
                ndays = 30;
                break;
            case 2:
                if (y % 4 == 0 && (y % 100 != 0 || y % 400 == 0)) {
                    ndays = 29;
                } else {
                    ndays = 28;
                }   break;
            default:
                ndays = 31;
                break;
        }

        //use ndays to find sucessor date
        if (d < ndays) {
            d++;
        } else {
            d = 1;

            //new month and possibly new year
            if (m < 12) {
                m++;
            } else {
                m = 1;
                y++;
            }//end else
        }//end else

        System.out.println("Sucessor Date is " + d + "/" + m + "/" + y);
    }//end main
}//end class