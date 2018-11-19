package advanced;

import java.util.Arrays;
import java.util.List;

public class TestPersonWithoutStreams {

  
    public static void main(String[] args) {
        
        List<Person> persons = Arrays.asList(
                new Person("D94086", "Dave", 40, "Galway"),
                new Person("L87454", "Lisa", 23 , "Waterford"),
                new Person("T93677", "Trevor", 60, "Dublin")
        );

        Person result = getStudentByName(persons, "Lisa");
        System.out.println(result);

    }

    private static Person getStudentByName(List<Person> persons, String name) {

        Person result = null;
        for (Person temp : persons) {
            if (name.equals(temp.getName())) {
                result = temp;
            }
        }
        return result;
    }
}
