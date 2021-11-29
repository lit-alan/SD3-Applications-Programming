/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sd3.com.model;

/**
 *
 * @author Alan.Ryan
 */
public class Record {
    private String code;
    private String indicator;
    private String name;

    public Record(String code, String indicator, String name) {
        this.code = code;
        this.indicator = indicator;
        this.name = name;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the indicator
     */
    public String getIndicator() {
        return indicator;
    }

    /**
     * @param indicator the indicator to set
     */
    public void setIndicator(String indicator) {
        this.indicator = indicator;
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

    @Override
    public String toString() {
        return getCode()  + "\t" + getIndicator() + "\t" + getName();
    }
    
    
}
