package src;

import java.io.*;

public class Person implements Serializable {

    public String name;
    private int yearOfBirth;
    private String address;
    private int phone;
    private String PPS;
    private String occupation;

    public Person() {

        name = "Jane Doe";
        yearOfBirth = 1972;
        address = "Moylish Park, Limerick";
        phone = 123456;
        PPS = "K44521452";
        occupation = "Unemployed";

    }//end default constructor

    public Person(String name, int YOB, String address, int phone, String PPS, String occupation) {
        this.name = name;
        this.yearOfBirth = YOB;
        this.address = address;
        this.phone = phone;
        this.PPS = PPS;
        this.occupation = occupation;
    }

    public String getName() {
        return name;
    }//end getName

    public void setName(String nme) {
        name = nme;
    }//end setName

    public int getYearOfBirth() {
        return yearOfBirth;
    }//end getYearOfBirth

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }//end setYearOfBirth

    public String getAddress() {
        return address;
    }//end getAddress

    public void setAddress(String add) {
        address = add;
    }//end setAddress

    public int getPhone() {
        return phone;
    }//end getPhone

    public void setPhone(int pne) {
        phone = pne;
    }//end setPhone

    public String getPPS() {
        return PPS;
    }

    public void setPPS(String PPS) {
        this.PPS = PPS;
    }



    public String getOccupation() {
        return occupation;
    }//end getOccupation

    public void setOccupation(String job) {
        occupation = job;
    }//end setOccupation

    public int calculateAge(int year) {
        return 2017 - year;
    }//end calulateAge

    @Override
    public String toString() {

        String output = "Name is " + getName();
        output += "\nAge is " + calculateAge(getYearOfBirth());
        output += "\nAddress is " + getAddress();
        output += "\nPhone Number is " + getPhone();
        output += "\nPPS Number is " + getPPS();
        output += "\nOccupation is " + getOccupation();
        return output;
    }

}//end class Person
