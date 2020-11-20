package src;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.StringTokenizer;


public class ParsingFileUsingStringTokenizer {

    public static void main(String[] args) throws IOException {

        Path p = Paths.get("in.dat");

        List<String> fileContents = Files.readAllLines(p);

        for (String aLine : fileContents) {
            printTokens(aLine);
        }

    }

    public static void printTokens(String str) {

        StringTokenizer tokenizer = new StringTokenizer(str, " ");
        while (tokenizer.hasMoreElements()) {
            System.out.print(tokenizer.nextToken() + " ");
        }
        System.out.println("");
    }
}
