package com.source;

class Employee extends StaffMember {

    protected String socialSecurityNumber;
    protected double payRate;

    public Employee(String name, String address, String phone, String sSN, double payRate) {
        super(name, address, phone);
        this.socialSecurityNumber = sSN;
        this.payRate = payRate;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    @Override
    public String toString() {
        String result = super.toString();
        result += "\nSocial Security Number : " + socialSecurityNumber;
        return result;
    }

    @Override
    public double pay() {
        return payRate;
    }

    @Override
    public boolean equals(Object obj) {

        return this.payRate == ((Employee) obj).getPayRate();
    }

    ////////////////////////////////////////////////////////////////////////
    @Override //ignore the commpareTo method for now
    public int compareTo(Object o) {
        if (this.payRate == ((Employee) o).payRate) {
            return 1;
        } else {
            return -1;
        }
    }

}//end class Employee
