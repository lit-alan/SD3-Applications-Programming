/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advanced;

import java.util.Arrays;
import java.util.List;

public class TestPersonWithStreams2 {

    public static void main(String[] args) {
  
        List<Person> persons = Arrays.asList(
                new Person("D94086", "Dave", 40, "Galway"),
                new Person("L87454", "Lisa", 23 , "Waterford"),
                new Person("T93677", "Trevor", 60, "Dublin")
        );


        Person result1 = persons.stream()
                .filter((p) -> "dave".equalsIgnoreCase(p.getName()) && 40 == p.getAge())
                .findAny()
                .orElse(null);

        System.out.println("result 1 :" + result1);

        //or like this
        Person result2 = persons.stream()
                .filter(p -> {
                    if ("Alan".equals(p.getName()) && 21 == p.getAge()) {
                        return true;
                    }
                    return false;
                }).findAny()
                .orElse(null);

        System.out.println("result 2 :" + result2);
    }
    
}
