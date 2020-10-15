package sd3.com.source;

class Hourly extends Employee implements Comparable {

   private int hoursWorked;

   public Hourly (String name, String address, String phone, String sSN, double payRate, int hoursWorked)   {
      super (name, address, phone, sSN, payRate);
      this.hoursWorked = hoursWorked;
   }

   public void addHours (int moreHours)   {
      hoursWorked += moreHours;
   }
   
   public void subtractHours (int moreHours)   {
      hoursWorked -= moreHours;
   }
   
   public void resetHours ()   {
      hoursWorked = 0;
   }


   @Override
   public double pay ()   {
      double payment = payRate * hoursWorked;
      hoursWorked = 0;
      return payment;
   }

   @Override
   public String toString ()   {
      String result = super.toString();
      result += "\nCurrent hours : " + hoursWorked;
      return result;
   }
   
    @Override
    public int compareTo(Object o) {
        if (this.hoursWorked == ((Hourly)o).hoursWorked)
            return 1;
        else
            return -1;
    }

} 
