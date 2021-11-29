package sd3.com.src;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import sd3.com.io.FileIO;
import sd3.com.model.Record;

public class MainV2 {

    //I'm going to read the data from the file into a List<Record>
    static List<Record> list = new ArrayList();
    static String file = "census.txt";
    
    public static void main(String[] args) {
        
        list = FileIO.readFile(file);

        ExecutorService exe = Executors.newCachedThreadPool();

        //submit tasks individually
        Future<Integer> f1 = exe.submit(new SearchCode(list,"MF"));
        Future<Integer> f2 = exe.submit(new SearchCode(list, "MO"));
        Future<Integer> f3 = exe.submit(new SearchCode(list, "FO"));
        Future<Integer> f4 = exe.submit(new Searchindicator(list, "LY"));
        Future<Integer> f5 = exe.submit(new Searchindicator(list, "LN"));

        try {
            //get future values of Callables
            System.out.println(list.size() + " records found in " + file);
            System.out.println("MF found " + f1.get() + " times");
            System.out.println("MO found " + f2.get() + " times");
            System.out.println("FO found " + f3.get() + " times");
            System.out.println("LY found " + f4.get() + " times");
            System.out.println("LN found " + f5.get() + " times");
        } catch (InterruptedException | ExecutionException ex) {
            System.out.println(ex);
        }

        exe.shutdown();
    }//end main

}//end class

////////////////////////////////////////////////////////////////
class SearchCode implements Callable<Integer> {

    List<Record> list;
    String code;

    public SearchCode(List<Record> list, String code) {

        this.list = list;
        this.code = code;
    }//end constructor

    @Override
    public Integer call() throws Exception {
        int counter = 0;
        
        for (Record record : list) {
            if (record.getCode().equals(code)) {
                counter++;
            }
        }
        return counter;
    }//end call
}//end SearchCode

////////////////////////////////////////////////////////////////
class Searchindicator implements Callable<Integer> {

    List<Record> list;
    String indicator;

    public Searchindicator(List<Record> list, String indicator) {

        this.list = list;
        this.indicator = indicator;
    }//end constructor

    @Override
    public Integer call() throws Exception {
        int counter = 0;
        
        for (Record record : list) {
            if (record.getIndicator().equals(indicator)) {
                counter++;
            }
        }
        return counter;
    }//end call
}//end Searchindicator