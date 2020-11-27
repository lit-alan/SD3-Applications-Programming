package sd3.com.src;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import sd3.com.model.Record;
import sd3.com.concurrency.Search;


public class SolutionWithSubstring {

    static List<Record> list = new ArrayList();
    static String file = "census.txt";
    
    public static void main(String[] args) {
        Path p = Paths.get(file);

        //read the file from the disk
        List<String> lines = null;
        try {
            lines = Files.readAllLines(p);

        } catch (IOException ex) {
            System.out.println(ex);
        }//end catch
        
        lines.remove(0); //remove header
        
        //create a Record object for each String in the list
        for (String line : lines) {
            String code = line.substring(0, 2).trim();
            String indicator = line.substring(2, 5).trim();
            
            //dont need the name in this exercise but I will read it anyway
            String name = line.substring(5).trim(); 
            list.add(new Record(code, indicator, name));
        }//end for
        
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
}//end class