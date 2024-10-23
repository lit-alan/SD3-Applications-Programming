package main;

import model.Customer;

import java.rmi.StubNotFoundException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        // Create a List to hold Customer objects
        List<Customer> customers = new ArrayList<>();

        // Add 25 Customer objects to list
        customers.add(new Customer(1L, "Aoife", "O'Sullivan", "aoife.osullivan@gmail.com", "password123", "12 High Street", "0851234567", LocalDate.of(1990, 5, 24), "Credit Card", "Email", "Dublin"));
        customers.add(new Customer(2L, "Cian", "Murphy", "c.murphy85@yahoo.com", "password123", "34 North Road", "0859876543", LocalDate.of(1985, 8, 12), "Debit Card", "SMS", "Galway"));
        customers.add(new Customer(3L, "Siobhan", "O'Connor", "siobhan_oconnor@outlook.com", "password123", "56 South Street", "0861239876", LocalDate.of(1992, 11, 30), "PayPal", "Phone", "Cork"));
        customers.add(new Customer(4L, "Liam", "Ryan", "liam.ryano@eir.ie", "password123", "78 Main Street", "0854567890", LocalDate.of(1988, 4, 15), "Credit Card", "Email", "Limerick"));
        customers.add(new Customer(5L, "Niamh", "Ryan", "niamh_ryan93@gmail.com", "password123", "9 Castle Road", "0876543210", LocalDate.of(1993, 3, 22), "Credit Card", "Phone", "Limerick"));

        customers.add(new Customer(6L, "Sean", "Hogan", "s.doyle@outlook.com", "password123", "45 Oakwood", "0867890123", LocalDate.of(1986, 6, 17), "Debit Card", "Email", "Waterford"));
        customers.add(new Customer(7L, "Eoin", "McCarthy", "eoin.mccarthy89@yahoo.com", "password123", "67 Church Lane", "0871234568", LocalDate.of(1970, 2, 11), "PayPal", "SMS", "Kerry"));
        customers.add(new Customer(8L, "Roisin", "Walsh", "roisin.walsh@xmail.com", "password123", "89 Park Street", "0853216549", LocalDate.of(1969, 7, 19), "Credit Card", "Phone", "Carlow"));
        customers.add(new Customer(9L, "Oisin", "Byrne", "oisin.byrne@yahoo.com", "password123", "10 River Road", "0865432109", LocalDate.of(1983, 12, 3), "Debit Card", "Email", "Donegal"));
        customers.add(new Customer(10L, "Aisling", "Sheehan", "sheehanaisling@eir.ie", "password123", "21 Mill Lane", "0856789012", LocalDate.of(1994, 9, 6), "PayPal", "SMS", "Mayo"));

        customers.add(new Customer(11L, "Conor", "Fitzgerald", "conorfitzgerald89@gmail.com", "password123", "32 Abbey Road", "0872345678", LocalDate.of(2004, 10, 25), "Credit Card", "Phone", "Louth"));
        customers.add(new Customer(12L, "Aine", "O'Donnell", "aine.odonnell85@outlook.com", "password123", "54 Ballymore", "0858901234", LocalDate.of(1968, 8, 9), "Debit Card", "Email", "Sligo"));
        customers.add(new Customer(13L, "Padraig", "Keane", "p.keane@gmail.com", "password123", "76 Bridge Street", "0862348765", LocalDate.of(1987, 1, 18), "PayPal", "SMS", "Limerick"));
        customers.add(new Customer(14L, "Grainne", "Collins", "g.collins93@eir.ie", "password123", "98 Orchard Avenue", "0857654321", LocalDate.of(1996, 12, 12), "Credit Card", "Phone", "Offaly"));
        customers.add(new Customer(15L, "Caoimhe", "Hayes", "caoimhe.hayes@yahoo.com", "password123", "11 Market Square", "0874321657", LocalDate.of(1982, 3, 9), "Debit Card", "Email", "Wicklow"));

        customers.add(new Customer(16L, "Fionn", "Kelly", "f.kelly@outlook.com", "password123", "33 Glenview", "0865432789", LocalDate.of(1991, 5, 2), "PayPal", "Phone", "Wexford"));
        customers.add(new Customer(17L, "Sinead", "Murphy", "sinead.Murphy84@gmail.com", "password123", "55 The Green", "0878765432", LocalDate.of(1984, 7, 20), "Credit Card", "SMS", "Carlow"));
        customers.add(new Customer(18L, "Cathal", "Brady", "c.brady@yahoo.com", "password123", "77 Riverwalk", "0857654329", LocalDate.of(1990, 2, 28), "Debit Card", "Email", "Laois"));
        customers.add(new Customer(19L, "Maeve", "Flynn", "maeve.flynn@eir.ie", "password123", "99 Hillcrest", "0869876543", LocalDate.of(1987, 4, 13), "PayPal", "Phone", "Tipperary"));
        customers.add(new Customer(20L, "Darragh", "Griffin", "darragh_griffin@gmail.com", "password123", "22 Beechwood", "0876543298", LocalDate.of(1992, 6, 5), "Credit Card", "SMS", "Kildare"));

        customers.add(new Customer(21L, "Orla", "Murphy", "orlaMurp93@yahoo.com", "password123", "44 The Crescent", "0859876541", LocalDate.of(1993, 9, 10), "Debit Card", "Phone", "Limerick"));
        customers.add(new Customer(22L, "Tadhg", "Hogan", "tadhg.hogan@gmail.com", "password123", "66 The Grove", "0865432198", LocalDate.of(1985, 11, 22), "PayPal", "Email", "Westmeath"));
        customers.add(new Customer(23L, "Deirdre", "Nolan", "deirdre_nolan93@outlook.com", "password123", "88 Cherrywood", "0872345698", LocalDate.of(2001, 10, 16), "Credit Card", "Phone", "Carlow"));
        customers.add(new Customer(24L, "Ronan", "Casey", "ronan.casey@yahoo.com", "password123", "101 Oakfield", "0858765432", LocalDate.of(1989, 3, 26), "Debit Card", "SMS", "Monaghan"));
        customers.add(new Customer(25L, "Eilis", "Moore", "eilis.moore@gmail.com", "password123", "123 Fairview", "0864321987", LocalDate.of(1995, 5, 8), "PayPal", "Email", "Cavan"));

        // Print out an unsorted list of customers
        //customers.forEach(System.out::println);

        //TASK 1
//        sortCustomersByLastName(customers).forEach(System.out::println);

        //TASK 2
//        sortCustomersByDateOfBirth(customers).forEach(System.out::println);

        //TASK 3
//        sortCustomersByMultipleFields(customers).forEach(System.out::println);

        //TASK 4
        Predicate<Customer> isFromLimerickOrCarlow = c -> "Limerick".equals(c.getCounty()) ||
                                                                            "Carlow".equals(c.getCounty());
//        sortCustomersByMultipleFieldsWithFilter(customers, isFromLimerickOrCarlow).forEach(System.out::println);


        //Task 5
        Map<String, List<Customer>> groupedCustomers = filterAndGroupCustomersByBirthDecade(customers);

        groupedCustomers.forEach((decade, customerList) -> {
            System.out.println("Decade: " + decade);
            customerList.forEach(customer ->
                    System.out.println(customer.getFirstName() + " " + customer.getLastName() + ", Born: " + customer.getDateOfBirth()));
        });

    }

    //task 1
    //sorts the list by the lastName field in ascending order. If two customers have the same last name, sort them by firstName.
    public static List<Customer> sortCustomersByLastName(List<Customer> customers) {

        Comparator<Customer> byLastName = Comparator.comparing(Customer::getLastName)
                                        .thenComparing(Customer::getFirstName);
        customers.sort(byLastName);
        return customers;
//        return customers.stream()
//                .sorted(Comparator.comparing(Customer::getLastName)
//                        .thenComparing(Customer::getFirstName))
//                .collect(Collectors.toList());
    }

    //task 2
    //sorts the list of Customer objects by dateOfBirth, from the oldest to the youngest. If two customers have the same birth date, maintain the original insertion order.
    public static List<Customer> sortCustomersByDateOfBirth(List<Customer> customers) {

        Comparator<Customer> byDOB = Comparator.comparing(Customer::getDateOfBirth);
        customers.sort(byDOB);
        return customers;

//     return customers.stream()
//                  .sorted(Comparator.comparing(Customer::getDateOfBirth))
//                  .collect(Collectors.toList());
    }

    //task 3
    //Sort Customer objects by paymentMethod (alphabetically), then by county (alphabetically), and finally by the domain of their email (the part after @).
    public static List<Customer> sortCustomersByMultipleFields(List<Customer> customers) {

        Comparator<Customer> byPaymentMethod = Comparator.comparing(Customer::getPaymentMethod)
                .thenComparing(Customer::getCounty)
                .thenComparing(c -> c.getEmail().substring(c.getEmail().indexOf('@') + 1));

        customers.sort(byPaymentMethod);
        return customers;

//        return customers.stream()
//                .sorted(Comparator.comparing(Customer::getPaymentMethod)
//                        .thenComparing(Customer::getCounty)
//                        .thenComparing(c -> c.getEmail().substring(c.getEmail().indexOf('@') + 1)))
//                .collect(Collectors.toList());
    }

    //task 4
    //Filter the list by those living in Limerick or Carlow then sort  by full name (alphabetically), then by date of birth
    public static List<Customer> sortCustomersByMultipleFieldsWithFilter(List<Customer> customers,
                                                                         Predicate<Customer> p) {
        return customers.stream()
                .filter(p)
                .sorted(Comparator.comparing((Customer c) -> (c.getLastName() + " " + c.getFirstName()))
                        .thenComparing(Customer::getDateOfBirth))
                .collect(Collectors.toList());


    }

    public static Map<String, List<Customer>> filterAndGroupCustomersByBirthDecade(List<Customer> customers) {
        //Sort by last name, then first name
        //Group by the decade of birth, and use a TreeMap to sort the decades
        //I am using a TreeMap to keep the decades in natural order

        return customers.stream()
                .sorted(Comparator.comparing(Customer::getLastName).thenComparing(Customer::getFirstName))
                .collect(Collectors.groupingBy(
                        Customer::getBirthDecade,
                        TreeMap::new,
                        Collectors.toList()));
         /*  The Collectors.groupingBy() method now uses a TreeMap::new as its map supplier.
            This ensures that the decades are ordered in natural ascending order (e.g., 1960s, 1970s, 1980s) in
            the resulting map.
            The TreeMap automatically sorts the keys, which are the decades (Strings) in this case.

         */


        /* alternatively */
//        TreeMap<String, List<Customer>> groupedByBirthDecade = new TreeMap<>();
//        return customers.stream()
//                .sorted(Comparator.comparing(Customer::getLastName)
//                        .thenComparing(Customer::getFirstName))
//                .collect(Collectors.groupingBy(
//                        Customer::getBirthDecade,
//                        () -> groupedByBirthDecade,
//                        Collectors.toList()));



    }



}
