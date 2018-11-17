package sd3.src.com;

import java.util.Date;

public class Order {
    private int orderNumber;
    private Date orderDate;
    private Date requiredDate;
    private Date shippedDate;
    private String status;
    private String commments;
    private int customerNumber;

    public Order() {
    }

    public Order(int orderNumber, Date orderDate, Date requiredDate, Date shippedDate, String status, String commments, int customerNumber) {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.requiredDate = requiredDate;
        this.shippedDate = shippedDate;
        this.status = status;
        this.commments = commments;
        this.customerNumber = customerNumber;
    }

    /**
     * @return the orderNumber
     */
    public int getOrderNumber() {
        return orderNumber;
    }

    /**
     * @param orderNumber the orderNumber to set
     */
    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * @return the orderDate
     */
    public Date getOrderDate() {
        return orderDate;
    }

    /**
     * @param orderDate the orderDate to set
     */
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * @return the requiredDate
     */
    public Date getRequiredDate() {
        return requiredDate;
    }

    /**
     * @param requiredDate the requiredDate to set
     */
    public void setRequiredDate(Date requiredDate) {
        this.requiredDate = requiredDate;
    }

    /**
     * @return the shippedDate
     */
    public Date getShippedDate() {
        return shippedDate;
    }

    /**
     * @param shippedDate the shippedDate to set
     */
    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the commments
     */
    public String getCommments() {
        return commments;
    }

    /**
     * @param commments the commments to set
     */
    public void setCommments(String commments) {
        this.commments = commments;
    }

    /**
     * @return the customerNumber
     */
    public int getCustomerNumber() {
        return customerNumber;
    }

    /**
     * @param customerNumber the customerNumber to set
     */
    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    @Override
    public String toString() {
        return "Order Number " + getOrderNumber();
    
    }
    
    
            
            
}
