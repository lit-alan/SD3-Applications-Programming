package lambdas.advanced;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class TestLambdas {

    public static void main(String[] args) {
        List<Contact> contacts = new ArrayList();
        
        contacts.add(new Contact("Alan", "alan.ryan@lit.ie", "061 2083458"));
        contacts.add(new Contact("Des", null, null));
        contacts.add(new Contact("Liz", "elizabeth.bourke@lit.ie", "061 2082147"));
        contacts.add(new Contact("Carol", "carol.rainsford@lit.ie", null));
        contacts.add(new Contact("Brendan", null, null));
        contacts.add(new Contact("Suzanne", "suzanne.ogorman@lit.ie", null));
        
        List<Contact> contactsWithoutPhone = filterContactsWithoutPhone(contacts);
        
//        for (Contact contact : contactsWithoutPhone) {
//            System.out.println(contact.getName());
//        }
        
//        List<Contact> filteredContacts = filterContacts(contacts, c -> c.getPhone() == null);
//        List<Contact> filteredContacts = filterContacts(contacts, c -> c.getEmail()== null);
        List<Contact> filteredContacts = filterContacts(contacts, c -> c.getPhone() == null && c.getEmail()== null);
        
        for (Contact contact : filteredContacts) {
            System.out.println(contact.getName());
        }
        
        
        
    }//end main
    
    public static List<Contact> filterContactsWithoutPhone(List<Contact> contacts) {
        List<Contact> contactsWithoutPhone = new ArrayList();
        for (Contact contact : contacts) {
            if(contact.getPhone() == null) {
                contactsWithoutPhone.add(contact);
            }//end if
                
        }//end for
        return contactsWithoutPhone;
    }//end method
    
    public static List<Contact> filterContacts(List<Contact> contacts, TestContact condition) {
        List<Contact> contactsWithoutPhone = new ArrayList();
        
        for (Contact contact : contacts) {
            if(condition.test(contact)) {
                contactsWithoutPhone.add(contact);
            }//end if
        }//end for
        return contactsWithoutPhone;
    }//end method
    
}//end class
