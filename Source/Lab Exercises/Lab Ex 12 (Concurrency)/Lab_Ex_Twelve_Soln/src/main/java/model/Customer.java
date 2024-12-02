
package model;

import java.util.Date;

public class Customer {
    private int id; //Customer's unique identifier
    private int yob;//Customer's birth year
    private String education; //Customer's education level
    private String maritalStatus; //Customer's marital status
    private double income; //Customer's yearly household income
    private int kidsHome; //Number of children in customer's household
    private int teensHome; //Number of teenagers in customer's household
    private Date dateJoined; //Date of customer's enrollment with the company
    private int recency; //Number of days since customer's last purchase
    private double amtWines; //Amount spent on wine in last 2 years
    private double amtFruits; //Amount spent on fruit in last 2 years
    private double amtMeatProducts; //Amount spent on meat in last 2 years
    private double amtFishProducts; //Amount spent on fish in last 2 years
    private double amtSweetProducts; //Amount spent on sweets in last 2 years
    private double amtGoldProds; //Amount spent on gold in last 2 years
    private boolean complained; //1 if customer complained in the last 2 yrs, 0 otherwise

    public Customer(int id, int yob, String education, String maritalStatus, double income, int kidsHome, int teensHome, Date dateJoined, int recency, double amtWines, double amtFruits, double amtMeatProducts, double amtFishProducts, double amtSweetProducts, double amtGoldProds, boolean complained) {
        this.id = id;
        this.yob = yob;
        this.education = education;
        this.maritalStatus = maritalStatus;
        this.income = income;
        this.kidsHome = kidsHome;
        this.teensHome = teensHome;
        this.dateJoined = dateJoined;
        this.recency = recency;
        this.amtWines = amtWines;
        this.amtFruits = amtFruits;
        this.amtMeatProducts = amtMeatProducts;
        this.amtFishProducts = amtFishProducts;
        this.amtSweetProducts = amtSweetProducts;
        this.amtGoldProds = amtGoldProds;
        this.complained = complained;
    }

    public Customer() {
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the yob
     */
    public int getYob() {
        return yob;
    }

    /**
     * @param yob the yob to set
     */
    public void setYob(int yob) {
        this.yob = yob;
    }

    /**
     * @return the education
     */
    public String getEducation() {
        return education;
    }

    /**
     * @param education the education to set
     */
    public void setEducation(String education) {
        this.education = education;
    }

    /**
     * @return the maritalStatus
     */
    public String getMaritalStatus() {
        return maritalStatus;
    }

    /**
     * @param maritalStatus the maritalStatus to set
     */
    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    /**
     * @return the income
     */
    public double getIncome() {
        return income;
    }

    /**
     * @param income the income to set
     */
    public void setIncome(double income) {
        this.income = income;
    }

    /**
     * @return the kidsHome
     */
    public int getKidsHome() {
        return kidsHome;
    }

    /**
     * @param kidsHome the kidsHome to set
     */
    public void setKidsHome(int kidsHome) {
        this.kidsHome = kidsHome;
    }

    /**
     * @return the teensHome
     */
    public int getTeensHome() {
        return teensHome;
    }

    /**
     * @param teensHome the teensHome to set
     */
    public void setTeensHome(int teensHome) {
        this.teensHome = teensHome;
    }

    /**
     * @return the dateJoined
     */
    public Date getDateJoined() {
        return dateJoined;
    }

    /**
     * @param dateJoined the dateJoined to set
     */
    public void setDateJoined(Date dateJoined) {
        this.dateJoined = dateJoined;
    }

    /**
     * @return the recency
     */
    public int getRecency() {
        return recency;
    }

    /**
     * @param recency the recency to set
     */
    public void setRecency(int recency) {
        this.recency = recency;
    }

    /**
     * @return the amtWines
     */
    public double getAmtWines() {
        return amtWines;
    }

    /**
     * @param amtWines the amtWines to set
     */
    public void setAmtWines(double amtWines) {
        this.amtWines = amtWines;
    }

    /**
     * @return the amtFruits
     */
    public double getAmtFruits() {
        return amtFruits;
    }

    /**
     * @param amtFruits the amtFruits to set
     */
    public void setAmtFruits(double amtFruits) {
        this.amtFruits = amtFruits;
    }

    /**
     * @return the amtMeatProducts
     */
    public double getAmtMeatProducts() {
        return amtMeatProducts;
    }

    /**
     * @param amtMeatProducts the amtMeatProducts to set
     */
    public void setAmtMeatProducts(double amtMeatProducts) {
        this.amtMeatProducts = amtMeatProducts;
    }

    /**
     * @return the amtFishProducts
     */
    public double getAmtFishProducts() {
        return amtFishProducts;
    }

    /**
     * @param amtFishProducts the amtFishProducts to set
     */
    public void setAmtFishProducts(double amtFishProducts) {
        this.amtFishProducts = amtFishProducts;
    }

    /**
     * @return the amtSweetProducts
     */
    public double getAmtSweetProducts() {
        return amtSweetProducts;
    }

    /**
     * @param amtSweetProducts the amtSweetProducts to set
     */
    public void setAmtSweetProducts(double amtSweetProducts) {
        this.amtSweetProducts = amtSweetProducts;
    }

    /**
     * @return the amtGoldProds
     */
    public double getAmtGoldProds() {
        return amtGoldProds;
    }

    /**
     * @param amtGoldProds the amtGoldProds to set
     */
    public void setAmtGoldProds(double amtGoldProds) {
        this.amtGoldProds = amtGoldProds;
    }

    /**
     * @return the complained
     */
    public boolean isComplained() {
        return complained;
    }

    /**
     * @param complained the complained to set
     */
    public void setComplained(boolean complained) {
        this.complained = complained;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", yob=" + yob + ", education=" + education + ", maritalStatus=" + maritalStatus + ", income=" + income + ", kidsHome=" + kidsHome + ", teensHome=" + teensHome + ", dateJoined=" + dateJoined + ", recency=" + recency + ", amtWines=" + amtWines + ", amtFruits=" + amtFruits + ", amtMeatProducts=" + amtMeatProducts + ", amtFishProducts=" + amtFishProducts + ", amtSweetProducts=" + amtSweetProducts + ", amtGoldProds=" + amtGoldProds + ", complained=" + complained + '}';
    }

    
}
