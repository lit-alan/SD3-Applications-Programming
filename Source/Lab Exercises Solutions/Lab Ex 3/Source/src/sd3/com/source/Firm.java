package sd3.com.source;

import java.text.NumberFormat;
import java.util.ArrayList;

public class Firm {

   NumberFormat currency = NumberFormat.getCurrencyInstance();

    public static void main(String[] args) {
        new Firm();
      
    }

    public Firm() {

        ArrayList<StaffMember> staffList = new ArrayList(6);

        staffList.add(new Executive("Dave", "Washington St", "345665", "4513-45-89", 15000.45, 0.0));

        staffList.add(new Employee("Dom", "William St", "987654", "94-65-41", 1200.15));

        staffList.add(new Hourly("Liam", "Shop Street", "986532", "984-474-325", 12.45, 5));

        staffList.add(new Volunteer("Grace", "O'Connell St", "557282"));

        ((Executive) staffList.get(0)).awardBonus(9000.00);

        ((Hourly) staffList.get(2)).addHours(40);

        ((Employee) staffList.get(1)).setPayRate(1000.00);

        Executive ex = new Executive("Tom", "Moylish Park", "784211", "4211-99-0", 1799.45, 500.00);

        ex.awardBonus(700.00);

        staffList.add(ex);

        staffList.add(new Employee("Aoife", "Friars Sq", "716234", "99-61-42", 2300.00));

        payday(staffList);
        

    }

    public void payday(ArrayList<StaffMember> list) {
        
        System.out.println("----------------------------------------------------------------------");
      
        double amount;

        for (StaffMember staffMember : list) {
            System.out.println("[" + staffMember.getClass().getSimpleName() + "]");

            System.out.println(staffMember);

            amount = staffMember.pay();

            if (amount == 0.0) {
                System.out.println("Thanks!");
            } else {
                System.out.println("Paid: " + currency.format(amount));
            }

            System.out.println("----------------------------------------------------------------------");
        }

    }

} //end class Firm 

