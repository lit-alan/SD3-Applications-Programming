package sd3.com.model;

public class Name {

    private String state;
    private String name;
    private double frequency;
    private double cumulativeFrequency;
    private int rank;
    private String city;

    public Name(String state, String name, double frequency, double cumulativeFrequency, int rank, String city) {
        this.state = state;
        this.name = name;
        this.frequency = frequency;
        this.cumulativeFrequency = cumulativeFrequency;
        this.rank = rank;
        this.city = city;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the frequency
     */
    public double getFrequency() {
        return frequency;
    }

    /**
     * @param frequency the frequency to set
     */
    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    /**
     * @return the cumulativeFrequency
     */
    public double getCumulativeFrequency() {
        return cumulativeFrequency;
    }

    /**
     * @param cumulativeFrequency the cumulativeFrequency to set
     */
    public void setCumulativeFrequency(double cumulativeFrequency) {
        this.cumulativeFrequency = cumulativeFrequency;
    }

    /**
     * @return the rank
     */
    public int getRank() {
        return rank;
    }

    /**
     * @param rank the rank to set
     */
    public void setRank(int rank) {
        this.rank = rank;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return state + "\t" + name + "\t" 
                + frequency + "\t" 
                + cumulativeFrequency + "\t" 
                + rank + "\t" 
                + city;
    }
    
    
    
}
