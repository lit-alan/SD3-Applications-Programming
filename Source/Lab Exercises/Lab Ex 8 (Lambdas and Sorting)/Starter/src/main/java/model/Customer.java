package model;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    private Long customerId;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String address;

    private String phoneNumber;

    private LocalDate dateOfBirth;

    private String paymentMethod;

    private String communicationPreferences;

    private String county;

    //Helper method to get the decade of birth as a String
    public static String getBirthDecade(Customer customer) {
        int yearOfBirth = customer.getDateOfBirth().getYear();

        //Calculate the decade (e.g., 1980s, 1990s)
        int decade = (yearOfBirth / 10) * 10;
        return decade + "s";
    }

    @Override
    public String toString() {
        return  "Customer ID: " + customerId + "\t" +
                "Name: " + firstName + " " + lastName + "\t" +
                "Address: " + address + ", " + county + "\t" +
                "Date of Birth: " + dateOfBirth + "\t" +
                "Payment Method: " + paymentMethod + "\t" +
                "Email: " + email;
    }


}