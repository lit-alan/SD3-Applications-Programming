/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advanced;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author alan.ryan
 */
public class TestPersonWithStreams1 {

    public static void main(String[] args) {
  
        List<Person> persons = Arrays.asList(
                new Person("D94086", "Dave", 40, "Galway"),
                new Person("L87454", "Lisa", 23 , "Waterford"),
                new Person("T93677", "Trevor", 60, "Dublin")
        );
        
        Person result1 = persons.stream()                        // Convert to steam
                .filter(x -> "Lisa".equals(x.getName()))         // we want "Lisa" only
                .findAny()                                       // If 'findAny' then return found
                .orElse(null);                                   // If not found, return null

        System.out.println(result1);

        Person result2 = persons.stream()
                .filter(x -> "Alan".equals(x.getName()))
                .findAny()
                .orElse(null);

        System.out.println(result2);

        
    }
    
}
