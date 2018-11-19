/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advanced;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 * @author Alan.Ryan
 */
public class TestPersonWithStreams4 {
    
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
                new Person("D94086", "Dave", 40, "Galway"),
                new Person("L87454", "Lisa", 23 , "Waterford"),
                new Person("T93677", "Trevor", 60, "Dublin")
        );
        
        Map<String, String> idToName = persons.stream().collect(Collectors.toMap(Person::getId, Person::getName));
        
        for (Map.Entry<String, String> entry : idToName.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());   
        }
        
        
        Map<String, Person> idToObj = persons.stream().collect(Collectors.toMap(Person::getId, Function.identity()));
        
        for (Map.Entry<String, Person> entry : idToObj.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue()); 
        }
    }
    
}
