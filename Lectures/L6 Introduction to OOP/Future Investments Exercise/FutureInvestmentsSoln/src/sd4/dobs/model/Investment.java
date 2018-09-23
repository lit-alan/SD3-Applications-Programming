package sd4.dobs.model;

public class Investment {
    
    private double monthlyInvestment;
    private double yearlyInterestRate;
    private int years;

    public Investment() {
        this.monthlyInvestment = 0.0;
        this.yearlyInterestRate = 0.0;
        this.years = 0;
    }

    public Investment(double monthlyInvestment, double yearlyInterestRate, int years) {
        this.monthlyInvestment = monthlyInvestment;
        this.yearlyInterestRate = yearlyInterestRate;
        this.years = years;
    }
    
    

    public double calculateFutureValue() {

        // convert yearly values to monthly values
        double monthlyInterestRate = yearlyInterestRate / 12 / 100;
        int months = years * 12;        
        
        // calculate the future value
        double futureValue = 0;
        for (int i = 1; i <= months; i++) {
            futureValue += monthlyInvestment;
            double monthlyInterestAmount = futureValue * monthlyInterestRate;
            futureValue += monthlyInterestAmount;            
        }
        
        return futureValue;
    }

    public double getMonthlyInvestment() {
        return monthlyInvestment;
    }

    public void setMonthlyInvestment(double monthlyInvestment) {
        this.monthlyInvestment = monthlyInvestment;
    }

    public double getYearlyInterestRate() {
        return yearlyInterestRate;
    }

    public void setYearlyInterestRate(double yearlyInterestRate) {
        this.yearlyInterestRate = yearlyInterestRate;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }
}