/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advanced;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestPersonWithStreams3 {

    public static void main(String[] args) {
  
        List<Person> persons = Arrays.asList(
                new Person("D94086", "Dave", 40, "Galway"),
                new Person("L87454", "Lisa", 23 , "Waterford"),
                new Person("T93677", "Trevor", 60, "Dublin")
        );


       String name = persons.stream()
                .filter(x -> "lisa".equalsIgnoreCase(x.getName()))
                .map(Person::getName)                         
                .findAny()
                .orElse("Nothing Found");

        System.out.println("name : " + name);

        List<String> collect = persons.stream()
                .map(Person::getName)
                .collect(Collectors.toList());

        collect.forEach(System.out::println);
    }
    
}
