package src;

import java.io.*;

public class PersonTester {

    ObjectOutputStream out;
    ObjectInputStream in;
    Person retrievedPerson;

    public static void main(String args[]) {

        new PersonTester();
    }

    public PersonTester() {

        try {

            out = new ObjectOutputStream(new FileOutputStream("savedfile.dat"));
            in = new ObjectInputStream(new FileInputStream("savedfile.dat"));

            //process first object
            Person person1 = new Person();
            out.writeObject(person1);
            retrievedPerson = (Person) in.readObject();
            System.out.println(retrievedPerson + "\n");

            //process second object
            Person person2 = new Person("Leo Varadkar", 1979, "Dublin", 4578240, "F78452157", "Taoiseach");
            out.writeObject(person2);
            retrievedPerson = (Person) in.readObject();
            System.out.println(retrievedPerson + "\n");

            //process third object
            Person person3 = new Person("Frances Fitzgerald", 1950, "Limerick", 123456, "D785235", "Tanaiste");
            out.writeObject(person3);
            retrievedPerson = (Person) in.readObject();
            System.out.println(retrievedPerson + "\n");

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

}//end PersonTester class
