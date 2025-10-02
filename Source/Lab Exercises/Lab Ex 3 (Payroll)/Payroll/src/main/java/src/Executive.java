package src;

import java.text.NumberFormat;

class Executive extends Employee implements Comparable {

    private double bonus;

    //need this to format the bonus as a currency in toString()
    private NumberFormat currency = NumberFormat.getCurrencyInstance();

    public double getBonus() {
        return bonus;
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
    public boolean equals(Object obj) {
        return this.bonus == ((Executive) obj).getBonus();
    }

    @Override
    public String toString ()   {
        String result = super.toString();
        result += "\nBonus : " + currency.format(bonus);
        return result;
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
