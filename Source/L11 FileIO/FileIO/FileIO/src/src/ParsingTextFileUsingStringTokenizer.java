
package src;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ParsingTextFileUsingStringTokenizer {
    
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList();
        
        Path p = Paths.get("in.dat");

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
        
         for (String line : lines) {
            studentList.add(splitRecord(line)); //convert each record in the file to a Student object
        }
         
         studentList.forEach(System.out::println);
                
        

    }

    private static Student splitRecord(String line) {
        String name;
        int grade1;
        int grade2;
        int grade3;
        
        StringTokenizer st = new StringTokenizer(line);
        
         while (st.hasMoreElements()) {
             name = st.nextToken();
             grade1 = Integer.parseInt(st.nextToken());  
             grade2 = Integer.parseInt(st.nextToken());  
             grade3 = Integer.parseInt(st.nextToken());  
             
             return new src.Student(name, grade1, grade2, grade3);
             
         
         }
         
          return null; //shouldn't get here
    
    }
}
