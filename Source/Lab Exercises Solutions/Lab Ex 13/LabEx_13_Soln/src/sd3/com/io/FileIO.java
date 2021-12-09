
package sd3.com.io;

import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;
import sd3.com.model.Name;


public class FileIO {
    public static List<Name> parseFile(String file) {

        List<Name> list = new ArrayList();
        FileReader frs;
        StreamTokenizer in;

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
            in.nextToken();

            String state = "";
            String name = "";
            double frequency = 0.0;
            double cumulativeFrequency = 0.0;
            int rank = 0;
            String city = "";

            in.nextToken();// first token proper

            while (in.ttype != StreamTokenizer.TT_EOF) {

                state = in.sval;
                in.nextToken();
                state += (char) in.ttype;
                in.nextToken();
                state += in.sval;

                in.nextToken();
                name = in.sval;

                in.nextToken();
                frequency = in.nval;

                in.nextToken();
                cumulativeFrequency = in.nval;

                in.nextToken();
                rank = (int) in.nval;

                in.nextToken();
                city = in.sval;

                list.add(new Name(state, name, frequency, cumulativeFrequency, rank, city));

                in.nextToken();

            }

        } catch (IOException ex) {
            System.out.println(ex);
        }

        return list;
    }

}