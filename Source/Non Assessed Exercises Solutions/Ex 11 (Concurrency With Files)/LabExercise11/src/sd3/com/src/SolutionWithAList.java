package sd3.com.src;

import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import sd3.com.concurrency.Search;
import sd3.com.model.Record;

public class SolutionWithAList {

    //I'm going to read the data from the file into a List<Record>
    static List<Record> list = new ArrayList();
    static String file = "census.txt";
    
    public static void main(String[] args) {
        
        parseFile(file);

        ExecutorService exe = Executors.newCachedThreadPool();

        //create a list of tasks
        List<Callable<Integer>> tasks = Arrays.asList(
            new Search(list, r -> r.getCode().equalsIgnoreCase("MF")),
            new Search(list, r -> r.getCode().equalsIgnoreCase("MO")),
            new Search(list, r -> r.getCode().equalsIgnoreCase("FO")),
            new Search(list, r -> r.getIndicator().equalsIgnoreCase("LY")),
            new Search(list, r -> r.getIndicator().equalsIgnoreCase("LN")));

        try {
            //invoke all tasks and get a list of futures
            List<Future<Integer>> futures = exe.invokeAll(tasks);
           
            System.out.println(list.size() + " records found in " + file);
            System.out.println("MF found " + futures.get(0).get() + " times");
            System.out.println("MO found " + futures.get(1).get() + " times");
            System.out.println("FO found " + futures.get(2).get() + " times");
            System.out.println("LY found " + futures.get(3).get() + " times");
            System.out.println("LN found " + futures.get(4).get() + " times");
        } catch (InterruptedException | ExecutionException ex) {
            System.out.println(ex);
        }

        exe.shutdown();
    }//end main

    private static void parseFile(String file) {
        FileReader frs;
        StreamTokenizer in;
        
        String code = "";
        String indicator = "";
        String name = "";

        try {
            frs = new FileReader(file);
            in = new StreamTokenizer(frs);

            //read headers
            in.nextToken();
            in.nextToken();
            in.nextToken();

            in.nextToken(); //first token of first record

            while (in.ttype != StreamTokenizer.TT_EOF) {
                
                //read code
                if (in.ttype == StreamTokenizer.TT_WORD) {
                    code = in.sval.trim();
                } else {
                    System.out.println("Bad file format reading code");
                }

                //read indicator
                if (in.nextToken() == StreamTokenizer.TT_WORD) {
                    indicator = in.sval.trim();
                } else {
                    System.out.println("Bad file format reading indicator");
                }

                //read the name (dont need it for this exercise, but I'll read it anyway)
                if (in.nextToken() == StreamTokenizer.TT_WORD) {
                    name = in.sval.trim();
                } else {
                    System.out.println("Bad file format reading name");
                }
                //create a new Record and add it to the list
                list.add(new Record(code, indicator, name));

                in.nextToken();
            }//end while

        } catch (IOException ex) {
            System.out.println(ex);
        }

    }//end parseFile()
}//end class