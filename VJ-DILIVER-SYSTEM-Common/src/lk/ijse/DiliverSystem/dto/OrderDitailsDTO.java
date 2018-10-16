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
public class OrderDitailsDTO extends SuperDTO{
    
    private int OrderDetailID;
    private String OrderID;
    private String CustomerID;
    private String TeleponeOperterName;
    private double DeleiveryChes;
    private double Total;
    private String Date;
    private String Time;

    public OrderDitailsDTO() {
    }

    public OrderDitailsDTO( String OrderID, String CustomerID, String TeleponeOperterName, double DeleiveryChes, double Total, String Date, String Time) {
       
        this.OrderID = OrderID;
        this.CustomerID = CustomerID;
        this.TeleponeOperterName = TeleponeOperterName;
        this.DeleiveryChes = DeleiveryChes;
        this.Total = Total;
        this.Date = Date;
        this.Time = Time;
    }

    public OrderDitailsDTO(int OrderDetailID, String OrderID, String CustomerID, String TeleponeOperterName, double DeleiveryChes, double Total, String Date, String Time) {
        this.OrderDetailID = OrderDetailID;
        this.OrderID = OrderID;
        this.CustomerID = CustomerID;
        this.TeleponeOperterName = TeleponeOperterName;
        this.DeleiveryChes = DeleiveryChes;
        this.Total = Total;
        this.Date = Date;
        this.Time = Time;
    }

    /**
     * @return the OrderDetailID
     */
    public int getOrderDetailID() {
        return OrderDetailID;
    }

    /**
     * @param OrderDetailID the OrderDetailID to set
     */
    public void setOrderDetailID(int OrderDetailID) {
        this.OrderDetailID = OrderDetailID;
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
     * @return the CustomerID
     */
    public String getCustomerID() {
        return CustomerID;
    }

    /**
     * @param CustomerID the CustomerID to set
     */
    public void setCustomerID(String CustomerID) {
        this.CustomerID = CustomerID;
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
     * @return the DeleiveryChes
     */
    public double getDeleiveryChes() {
        return DeleiveryChes;
    }

    /**
     * @param DeleiveryChes the DeleiveryChes to set
     */
    public void setDeleiveryChes(double DeleiveryChes) {
        this.DeleiveryChes = DeleiveryChes;
    }

    /**
     * @return the Total
     */
    public double getTotal() {
        return Total;
    }

    /**
     * @param Total the Total to set
     */
    public void setTotal(double Total) {
        this.Total = Total;
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

    @Override
    public String toString() {
        return "OrderDitailsDTO{" + "OrderDetailID=" + OrderDetailID + ", OrderID=" + OrderID + ", CustomerID=" + CustomerID + ", TeleponeOperterName=" + TeleponeOperterName + ", DeleiveryChes=" + DeleiveryChes + ", Total=" + Total + ", Date=" + Date + ", Time=" + Time + '}';
    }

  
}
