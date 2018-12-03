package sd3.com.src;

import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SolutionWith2DArray {
    //I'm going to read the data from the file into a 2D array
    //Codes will be stored in col 0
    //Indicators will be stored in col 1
    //The names (even though I don't use them in this exercise will be stored in col 2
    static String data[][] = new String[5163][3]; //not going to store the file headers
    
    static final int CODE = 0;
    static final int INDICATOR = 1;
    
    public enum  Keys {
        MF, MO, FO, LY,LN
    }
    
    public static void main(String[] args) {

        parseFile("census.txt");

        ExecutorService exe = Executors.newCachedThreadPool();
        
        //submit tasks individually
        Future<Integer> f1 = exe.submit(new SearchTask(Keys.MF.toString(), data, CODE));
        Future<Integer> f2 = exe.submit(new SearchTask(Keys.MO.toString(), data, CODE));
        Future<Integer> f3 = exe.submit(new SearchTask(Keys.FO.toString(), data, CODE));
        Future<Integer> f4 = exe.submit(new SearchTask(Keys.LY.toString(), data, INDICATOR));
        Future<Integer> f5 = exe.submit(new SearchTask(Keys.LN.toString(), data, INDICATOR));
        
        try {
            //get future values of Callables
            System.out.println(Keys.MF + " found " + f1.get() + " times");
            System.out.println(Keys.MO + " found " + f2.get() + " times");
            System.out.println(Keys.FO + " found " + f3.get() + " times");
            System.out.println(Keys.LY + " found " + f4.get() + " times");
            System.out.println(Keys.LN + " found " + f5.get() + " times");
        } catch (InterruptedException | ExecutionException ex) {
            System.out.println(ex);
        }
        
        exe.shutdown();
    }//end main
 
    private static void parseFile(String file) {
        FileReader frs;
        StreamTokenizer in;

        try {
            frs = new FileReader(file);
            in = new StreamTokenizer(frs);

            //read headers
            in.nextToken();
            in.nextToken();
            in.nextToken();

            in.nextToken();

            int counter = 0;
            while (in.ttype != StreamTokenizer.TT_EOF) {

                //read code
                if (in.ttype == StreamTokenizer.TT_WORD) {
                    data[counter][0] = in.sval.trim();
                } else {
                    System.out.println("Bad file format");
                }

                //read indicator
                if (in.nextToken() == StreamTokenizer.TT_WORD) {
                    data[counter][1] = in.sval.trim();
                } else {
                    System.out.println("Bad file format");
                }

                //read the name (dont need it for this exercise, but I'll read it anyway)
                if (in.nextToken() == StreamTokenizer.TT_WORD) {
                    data[counter][2] = in.sval.trim();
                } else {
                    System.out.println("Bad file format");
                }
                counter++;
                in.nextToken();
            }

        } catch (IOException ex) {
            System.out.println(ex);
        }

    }//end parseFile()

}//end class

class SearchTask implements Callable<Integer> {
    String searchTerm;
    String[][] data;
    int column;

    public SearchTask(String searchTerm, String[][] data, int column) {
        this.searchTerm = searchTerm;
        this.data = data;
        this.column = column;
    }//end constructor

    @Override
    public Integer call() throws Exception {
      int counter = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i][column].equalsIgnoreCase(searchTerm)) {
                counter++;
            }//if
        }//for
       return counter;
    }//end call
}//end SearchTask