/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sd3.src.com;

import java.sql.Date;
import java.text.NumberFormat;

/**
 *
 * @author alan.ryan
 */
public class Customer {
    
    private NumberFormat nf = NumberFormat.getCurrencyInstance();
    
    private int customerNumber;
    private String customerName;
    private String contactLastName;
    private String contactFirstName;
    private String phone;
    private String city;
    private String country;
    private double creditLimit;
    private Date dateJoined;

    public Customer() {
    }

    public Customer(int customerNumber, String customerName, String contactLastName, String contactFirstName, String phone, String city, String country, double creditLimit, Date dateJoined) {
        this.customerNumber = customerNumber;
        this.customerName = customerName;
        this.contactLastName = contactLastName;
        this.contactFirstName = contactFirstName;
        this.phone = phone;
        this.city = city;
        this.country = country;
        this.creditLimit = creditLimit;
        this.dateJoined = dateJoined;
    }



    /**
     * @return the customerNumber
     */
    public int getCustomerNumber() {
        return customerNumber;
    }

    /**
     * @param customerNumber the customerNumber to set
     */
    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    /**
     * @return the customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * @param customerName the customerName to set
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * @return the contactLastName
     */
    public String getContactLastName() {
        return contactLastName;
    }

    /**
     * @param contactLastName the contactLastName to set
     */
    public void setContactLastName(String contactLastName) {
        this.contactLastName = contactLastName;
    }

    /**
     * @return the contactFirstName
     */
    public String getContactFirstName() {
        return contactFirstName;
    }

    /**
     * @param contactFirstName the contactFirstName to set
     */
    public void setContactFirstName(String contactFirstName) {
        this.contactFirstName = contactFirstName;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }
    
    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return the creditLimit
     */
    public double getCreditLimit() {
       return creditLimit;
    }
    
    public String getFormattedCreditLimit() {
         return  nf.format(creditLimit);
    }

    /**
     * @param creditLimit the creditLimit to set
     */
    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }
    
    /**
     * @return the dateJoined
     */
    public Date getDateJoined() {
        return dateJoined;
    }

    /**
     * @param dateJoined the dateJoined to set
     */
    public void setDateJoined(Date dateJoined) {
        this.dateJoined = dateJoined;
    }

    @Override
    public String toString() {
     return "Customer #          " + getCustomerNumber() + 
            "\nName                " + getCustomerName() +
            "\nContact First Name  " + getContactFirstName() + 
            "\nContact Last Name   " + getContactLastName() + 
            "\nPhone               " + getPhone() + 
            "\nCity                " + getCity() + 
            "\nCountry             " + getCountry() + 
            "\nCredit Limit        " + getFormattedCreditLimit()+
            "\nDate Joined         " + getDateJoined() + 
            "\n-----------------------------------------------------";
    }//end toString()
}