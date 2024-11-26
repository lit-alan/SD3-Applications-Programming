package io.serialize_and_deserialize_objects;

import io.model.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersonTester {

    ObjectOutputStream out;
    ObjectInputStream in;
    Person retrievedPerson;
    List<Person> plist = new ArrayList();

    public static void main(String args[]) {

        new PersonTester();
    }

    public PersonTester() {

        try {

            out = new ObjectOutputStream(new FileOutputStream("savedfile.dat"));
            in = new ObjectInputStream(new FileInputStream("savedfile.dat"));

            //process first object
            Person person1 = new Person();
           plist.add(person1);
//          out.writeObject(person1);
//          retrievedPerson = (io.model.Person) in.readObject();
//          System.out.println(retrievedPerson + "\n");

            //process second object
            Person person2 = new Person("Simon Harris", 1979, "Dublin", 4578240, "F78452157", "Taoiseach");
//          out.writeObject(person2);
//          retrievedPerson = (io.model.Person) in.readObject();
//          System.out.println(retrievedPerson + "\n");
            plist.add(person2);

            //process third object
            Person person3 = new Person("Willie ODea", 1950, "Limerick", 123456, "D785235", "Back Bencher");
//          out.writeObject(person3);
//          retrievedPerson = (io.model.Person) in.readObject();
//          System.out.println(retrievedPerson + "\n");
            plist.add(person3);
            out.writeObject(plist);
            ArrayList<Person> newList = (ArrayList<Person>) in.readObject();

            newList.forEach(System.out::println);

            //house keeping
            out.close();
            in.close();

            System.out.println("Done");

        } catch (Exception ioe) {
            System.out.println(ioe);
        } finally {
            System.exit(0);
        }

    }//end default constructor

}//end io.objects.PersonTester class
