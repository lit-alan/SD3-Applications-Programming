package introduction;

import java.util.ArrayList;
import java.util.List;

public class WithoutStreams {

    public static void main(String[] args) {

        List<String> names = new ArrayList<>();
        names.add("Pablo");
        names.add("Javier");
        names.add("Steve");
        names.add("Gustavo");
        names.add("Tata");
        names.add("Valeria");
        names.add("Fernando");

        for (String str : names) {
            System.out.println(str);
        }
    }

}
