package introduction;

import java.util.ArrayList;
import java.util.List;

public class WithStreams {

    public static void main(String[] args) {
        
        List<String> names = new ArrayList<>();
        names.add("Pablo");
        names.add("Javier");
        names.add("Steve");
        names.add("Gustavo");
        names.add("Tata");
        names.add("Valeria");
        names.add("Fernando");
        
        names.stream().forEach(System.out::println);
        
    }
      

}
