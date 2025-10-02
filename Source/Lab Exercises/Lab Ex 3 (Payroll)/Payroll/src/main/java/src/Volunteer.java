package src;

class Volunteer extends StaffMember implements Comparable{

   public Volunteer (String name, String address, String phone)   {
      super (name, address, phone);
   }

   @Override
   public double pay()   {
      return 0.0;
   }


   @Override
   public int compareTo(Object o) {
        if (this.getName().equalsIgnoreCase(((Volunteer)o).getName()))
            return 1;
        else
            return -1;
    }

}