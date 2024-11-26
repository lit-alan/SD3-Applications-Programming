package io.model;

import lombok.*;

import java.io.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
public class Person implements Serializable {

    public String name;
    private int yearOfBirth;
    private  String address;
    private int phone;
    private String PPS;
    private   String occupation;
    

    public Person() {

        name = "Jane Doe";
        yearOfBirth = 1972;
        address = "Moylish Park, Limerick";
        phone = 123456;
        PPS = "K44521452";
        occupation = "Unemployed";

    }//end default constructor


}//end class io.model.Person
