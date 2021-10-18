package sd3.com.source;

abstract class StaffMember implements Comparable {

    private String name;
    private String address;
    private String phone;

    public StaffMember(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        String result = "Name: " + getName() + "\n";
        result += "Address: " + getAddress() + "\nPhone: " + getPhone();
        return result;
    }
    
    public abstract double pay();

}//end class StaffMember
