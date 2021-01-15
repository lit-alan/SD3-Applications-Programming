package sd3.com.src;

import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import sd3.com.CA.model.Name;
import sd3.com.concurrency.Print;
import sd3.com.concurrency.Search;
import static sd3.com.src.SolutionWithStreamTokenizer.list;

public class SolutionWithStringTokenizer {

    static List<Name> list = new ArrayList();
    static NumberFormat nf = NumberFormat.getPercentInstance();
    
    public static void main(String[] args) throws InterruptedException, ExecutionException {
       Path p = Paths.get("CA.txt");

        List<String> lines = null;
        try {
            lines = Files.readAllLines(p);
        } catch (IOException ex) {
            System.err.println(ex);
        }

        if (lines == null || lines.isEmpty()) {
            System.err.println("ERROR: The requested file appears to be empty");
            System.exit(0);
        }

        lines.remove(0); //remove file header with the col headings

        for (String line : lines) {
            list.add(splitRecord(line)); //convert each record in the file to a Name object
        }

        
        ExecutorService exe = Executors.newCachedThreadPool();
        Future<Double> f1 = exe.submit(new Search(list, "Alan",2017, 2000));
        
        nf.setMaximumFractionDigits(2);
        System.out.println("Percentage Diff " + nf.format(f1.get()));
        exe.submit(new Print(list, "Tom"));
        
        exe.shutdown();
    }

   private static Name splitRecord(String line) {

       String timeZone;
       String gender; //could use a char instead of a String
       int year;
       String name;
       int occurrences;
       
       StringTokenizer st = new StringTokenizer(line);

        while (st.hasMoreElements()) {
            timeZone  = st.nextToken();
            gender = st.nextToken();
            year = Integer.parseInt(st.nextToken());
            name = st.nextToken();
            occurrences = Integer.parseInt(st.nextToken());

            return new Name(timeZone, gender, year, name, occurrences);

        }//end while

        return null; //shouldn't get here
    }//end method splitRecord

}



