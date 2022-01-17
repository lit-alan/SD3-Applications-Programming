package src;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class WriteToFile {

    public static void main(String[] args) {
String text = "This is the text I want to write to a file\n";


Path target = Paths.get("outputFile.txt");

try {
     Files.write(target, text.getBytes());

     //If you want to append text to a file use this
     //Files.write(target, text.getBytes(), StandardOpenOption.APPEND);
}//end try
catch (IOException ex) {
    System.out.println("Error: " + ex.toString());
}//end catch

System.out.println("Done!");
    }//end main 
}//WriteToFile

class b {
    
}