package src;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.StringTokenizer;

public class ParsingFileUsingStringTokenizer {

    static FileWriter fws = null;
    static PrintWriter out = null;

    public static void main(String[] args) {

        try {
            fws = new FileWriter("summary.dat");
            out = new PrintWriter(fws);

            Path p = Paths.get("in.dat");

            List<String> fileContents = Files.readAllLines(p);

            for (String aLine : fileContents) {
                writeARecord(aLine);
            }

            System.out.println("Done! Check summary file");
        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            try {

                if (fws != null) {
                    fws.close();
                }
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }

    }

    public static void writeARecord(String str) {

        StringTokenizer tokenizer = new StringTokenizer(str, " ");
        String sname = tokenizer.nextToken();
        double midterm1 = Double.parseDouble(tokenizer.nextToken());
        double midterm2 = Double.parseDouble(tokenizer.nextToken());
        double finalScore = Double.parseDouble(tokenizer.nextToken());
        double total = midterm1 * 0.3 + midterm2 * 0.3 + finalScore * 0.4;
        out.println(sname + ": " + total);

    }
}
