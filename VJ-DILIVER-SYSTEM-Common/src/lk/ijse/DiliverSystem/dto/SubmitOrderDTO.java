/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverSystem.dto;

/**
 *
 * @author Viraj jayasanka
 */
public class SubmitOrderDTO  extends SuperDTO{
    
    private int SubmitOrderID;
    private String OrderID;
    private String TeleponeOperterName;
    private String CustomerId;
    private String Total;
    private String Payment;
    private String Time;
    private String Date;

    public SubmitOrderDTO() {
    }

    public SubmitOrderDTO( String OrderID, String TeleponeOperterName, String CustomerId, String Total, String Payment, String Time, String Date) {
        this.OrderID = OrderID;
        this.TeleponeOperterName = TeleponeOperterName;
        this.CustomerId = CustomerId;
        this.Total = Total;
        this.Payment = Payment;
        this.Time = Time;
        this.Date = Date;
    }

    public SubmitOrderDTO(int SubmitOrderID, String OrderID, String TeleponeOperterName, String CustomerId, String Total, String Payment, String Time, String Date) {
        this.SubmitOrderID = SubmitOrderID;
        this.OrderID = OrderID;
        this.TeleponeOperterName = TeleponeOperterName;
        this.CustomerId = CustomerId;
        this.Total = Total;
        this.Payment = Payment;
        this.Time = Time;
        this.Date = Date;
    }

    /**
     * @return the SubmitOrderID
     */
    public int getSubmitOrderID() {
        return SubmitOrderID;
    }

    /**
     * @param SubmitOrderID the SubmitOrderID to set
     */
    public void setSubmitOrderID(int SubmitOrderID) {
        this.SubmitOrderID = SubmitOrderID;
    }

    /**
     * @return the OrderID
     */
    public String getOrderID() {
        return OrderID;
    }

    /**
     * @param OrderID the OrderID to set
     */
    public void setOrderID(String OrderID) {
        this.OrderID = OrderID;
    }

    /**
     * @return the TeleponeOperterName
     */
    public String getTeleponeOperterName() {
        return TeleponeOperterName;
    }

    /**
     * @param TeleponeOperterName the TeleponeOperterName to set
     */
    public void setTeleponeOperterName(String TeleponeOperterName) {
        this.TeleponeOperterName = TeleponeOperterName;
    }

    /**
     * @return the CustomerId
     */
    public String getCustomerId() {
        return CustomerId;
    }

    /**
     * @param CustomerId the CustomerId to set
     */
    public void setCustomerId(String CustomerId) {
        this.CustomerId = CustomerId;
    }

    /**
     * @return the Total
     */
    public String getTotal() {
        return Total;
    }

    /**
     * @param Total the Total to set
     */
    public void setTotal(String Total) {
        this.Total = Total;
    }

    /**
     * @return the Payment
     */
    public String getPayment() {
        return Payment;
    }

    /**
     * @param Payment the Payment to set
     */
    public void setPayment(String Payment) {
        this.Payment = Payment;
    }

    /**
     * @return the Time
     */
    public String getTime() {
        return Time;
    }

    /**
     * @param Time the Time to set
     */
    public void setTime(String Time) {
        this.Time = Time;
    }

    /**
     * @return the Date
     */
    public String getDate() {
        return Date;
    }

    /**
     * @param Date the Date to set
     */
    public void setDate(String Date) {
        this.Date = Date;
    }

    @Override
    public String toString() {
        return "SubmitOrderDTO{" + "SubmitOrderID=" + SubmitOrderID + ", OrderID=" + OrderID + ", TeleponeOperterName=" + TeleponeOperterName + ", CustomerId=" + CustomerId + ", Total=" + Total + ", Payment=" + Payment + ", Time=" + Time + ", Date=" + Date + '}';
    }

}
