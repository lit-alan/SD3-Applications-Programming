package sd3.com.src;

import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import sd3.com.CA.model.Name;
import sd3.com.concurrency.Print;
import sd3.com.concurrency.Search;

public class SolutionWithStreamTokenizer {

    static List<Name> list = new ArrayList();
    static NumberFormat nf = NumberFormat.getPercentInstance();
    
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        parseFile("CA.txt");

        
        ExecutorService exe = Executors.newCachedThreadPool();
        Future<Double> f1 = exe.submit(new Search(list, "Paul", 2000, 2017));
        
        nf.setMaximumFractionDigits(2);
        System.out.println("Percentage Diff " + nf.format(f1.get()));
        exe.submit(new Print(list, "Zack"));
        
        exe.shutdown();
    }

    private static void parseFile(String file) {
        FileReader frs;
        StreamTokenizer in;

        String timeZone;
        String gender; //could use a char instead of a String
        int year;
        String name;
        int occurrences;

        try {
            frs = new FileReader(file);
            in = new StreamTokenizer(frs);

            in.ordinaryChar('-');

            //read headers

            in.nextToken();
            in.nextToken();
            in.nextToken();
            in.nextToken();
            in.nextToken();

            in.nextToken();// first token proper

            while (in.ttype != StreamTokenizer.TT_EOF) {
              
                timeZone = in.sval;
                in.nextToken();

                timeZone += ((char) in.ttype);
               
                in.nextToken();
                
                timeZone +=  in.nval;
               
                
                in.nextToken();
                gender = in.sval;

                in.nextToken();
                year = (int) in.nval;//year


                in.nextToken();
                name = in.sval;

                in.nextToken();
                occurrences = (int) in.nval; //births

                in.nextToken();

                list.add(new Name(timeZone, gender, year, name, occurrences));

            }
        } catch (IOException ex) {
            System.out.println(ex);
        }

    }

}



