package sd3.com.src;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Predicate;
import sd3.com.io.FileIO;
import sd3.com.model.Record;


public class Main {

    //I'm going to read the data from the file into a List<Record>
    static List<Record> list = new ArrayList();
    static String file = "census.txt";
    
    public static void main(String[] args) {
         
        list = FileIO.readFile(file);

        ExecutorService exe = Executors.newCachedThreadPool();

        //submit tasks individually
        Future<Integer> f1 = exe.submit(new Search(list, r -> r.getCode().equalsIgnoreCase("MF")));
        Future<Integer> f2 = exe.submit(new Search(list, r -> r.getCode().equalsIgnoreCase("MO")));
        Future<Integer> f3 = exe.submit(new Search(list, r -> r.getCode().equalsIgnoreCase("FO")));
        Future<Integer> f4 = exe.submit(new Search(list, r -> r.getIndicator().equalsIgnoreCase("LY")));
        Future<Integer> f5 = exe.submit(new Search(list, r -> r.getIndicator().equalsIgnoreCase("LN")));
        Future<Integer> f6 = exe.submit(new Search(list, r -> r.getName().toLowerCase().startsWith("abb")));

        try {
            //get future values of Callables
            System.out.println(list.size() + " records found in " + file);
            System.out.println("MF found " + f1.get() + " times");
            System.out.println("MO found " + f2.get() + " times");
            System.out.println("FO found " + f3.get() + " times");
            System.out.println("LY found " + f4.get() + " times");
            System.out.println("LN found " + f5.get() + " times");
            System.out.println("Names found starting with abb " + f6.get());
        } catch (InterruptedException | ExecutionException ex) {
            System.out.println(ex);
        }

        exe.shutdown();
    }//end main

}//end class

class Search implements Callable<Integer> {

    List<Record> list;
    Predicate<Record> condition;

    public Search(List<Record> list, Predicate<Record> condition) {

        this.list = list;
        this.condition = condition;
    }//end constructor

    @Override
    public Integer call() throws Exception {
        int counter = 0;

        for (Record record : list) {
            if (condition.test(record)) {
                counter++;
            }
        }
        return counter;
    }//end call
}//end Search