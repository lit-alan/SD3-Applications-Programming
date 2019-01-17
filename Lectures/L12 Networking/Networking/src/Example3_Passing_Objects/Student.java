package Example3_Passing_Objects;

// Student.java: Student class encapsulates student information
import java.io.*;

public class Student implements Serializable {

  private String name;
  private String street;
  private String city;
  private String year;
  private String fee;

  /**Default constructor*/
  public Student() { }

  //Construct a Student with specified name, street, city, year and fee 
  public Student(String name, String street, String city, String year, String fee) {
    this.name = name;
    this.street = street;
    this.city = city;
    this.year = year;
    this.fee = fee;
  }//end student

  /**Return name*/
  public String getName() {
    return name;
  }//end getName

  /**Return street*/
  public String getStreet() {
    return street;
  }//end getStreet

  /**Return city*/
  public String getCity() {
    return city;
  }//end getCity

  /**Return year*/
  public String getYear() {
    return year;
  }//end getYear

  /**Return fee*/
  public String getFee() {
    return fee;
  }///end getFee

}//end student class