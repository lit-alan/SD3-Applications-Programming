package sd3.com.IO;

import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;
import sd3.com.model.Name;

/**
 *
 * @author Alan.Ryan
 */
public class FileIO {
    
    public static List<Name> parseFile(String file) {
        List<Name> list = new ArrayList();
        
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
        
        return list;

    }
}
