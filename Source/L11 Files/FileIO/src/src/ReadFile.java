package src;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReadFile {

    public static void main(String[] args) {
        Path pathToTargetFile = Paths.get("eventmonitoring.txt");

        List<String> lines;
        try {
            lines = Files.readAllLines(pathToTargetFile, Charset.forName("UTF-8"));

            System.out.println("The file \"" + pathToTargetFile.getFileName() + "\" has " + lines.size() + " lines\n");

            for (String item : lines) {
                System.out.println(item + "\n");
            }//end for

           

        }//end try
        catch (IOException ex) {
            System.out.println("Something has gone wrong, \nEnsure that the file you are trying to view exists & that the path is correct");
        }//end catch
    }//end main
}//end class