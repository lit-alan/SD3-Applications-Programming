package sd3.com.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import sd3.com.model.Record;

/**
 *
 * @author Alan.Ryan
 */
public class FileIO {

    static ArrayList<Record> nameList = new ArrayList();

    public static ArrayList<Record> readFile(String file) {

        Path p = Paths.get(file);
        List<String> lines = null;
        try {
            lines = Files.readAllLines(p);
            lines.remove(0);//remove the headers
        } catch (IOException ex) {
            System.out.println(ex);
        }

        for (String line : lines) {
            nameList.add(parseLine(line));
        }

        return nameList;

    }

    private static Record parseLine(String line) {
        String code;
        String indicator;
        String name;
     
        StringTokenizer st = new StringTokenizer(line);

        while (st.hasMoreElements()) {

            code = st.nextToken();
            indicator = st.nextToken();
            name = st.nextToken();
         
            return new Record(code, indicator, name);

        }//end while

        return null; //shouldn't get here
    }
}