package sd3.com.source;

class Executive extends Employee {

    private double bonus;

    {
        awardBonus(2500.00);
    }

    public Executive(String name, String address, String phone, String sSN, double payRate, double bonus) {
        super(name, address, phone, sSN, payRate);
        this.bonus = bonus;
    }

    public void awardBonus(double execBonus) {
       bonus += execBonus;
    }

    public void resetBonus() {
        bonus = 0.0;
    }

    @Override
    public double pay() {
        double payment = super.pay() + bonus;
        bonus = 0;
        return payment;
    }

    @Override
    public int compareTo(Object o) {
        if (this.bonus == ((Executive) o).bonus) {
            return 1;
        } else {
            return -1;
        }

    }

}
