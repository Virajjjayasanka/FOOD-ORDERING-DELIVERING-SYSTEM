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
public class CustomerDTO extends SuperDTO{
    private int customerID;
    private String OrderID;
    private String TeleponeOperterName;
    private String CustomerName;
    private String CustomerAddress;
    private int CustomerTelePoneNO;
    private int OtherTelePoneNO;
    private String StringNote;
    private String Time;
    private String Date;

    public CustomerDTO() {
    }

    public CustomerDTO(String OrderID, String TeleponeOperterName, String CustomerName, String CustomerAddress, int CustomerTelePoneNO, int OtherTelePoneNO, String StringNote, String Time, String Date) {
        
        this.OrderID = OrderID;
        this.TeleponeOperterName = TeleponeOperterName;
        this.CustomerName = CustomerName;
        this.CustomerAddress = CustomerAddress;
        this.CustomerTelePoneNO = CustomerTelePoneNO;
        this.OtherTelePoneNO = OtherTelePoneNO;
        this.StringNote = StringNote;
        this.Time = Time;
        this.Date = Date;
    }

    public CustomerDTO(int customerID, String OrderID, String TeleponeOperterName, String CustomerName, String CustomerAddress, int CustomerTelePoneNO, int OtherTelePoneNO, String StringNote, String Time, String Date) {
        this.customerID = customerID;
        this.OrderID = OrderID;
        this.TeleponeOperterName = TeleponeOperterName;
        this.CustomerName = CustomerName;
        this.CustomerAddress = CustomerAddress;
        this.CustomerTelePoneNO = CustomerTelePoneNO;
        this.OtherTelePoneNO = OtherTelePoneNO;
        this.StringNote = StringNote;
        this.Time = Time;
        this.Date = Date;
    }

    /**
     * @return the customerID
     */
    public int getCustomerID() {
        return customerID;
    }

    /**
     * @param customerID the customerID to set
     */
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
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
     * @return the CustomerName
     */
    public String getCustomerName() {
        return CustomerName;
    }

    /**
     * @param CustomerName the CustomerName to set
     */
    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    /**
     * @return the CustomerAddress
     */
    public String getCustomerAddress() {
        return CustomerAddress;
    }

    /**
     * @param CustomerAddress the CustomerAddress to set
     */
    public void setCustomerAddress(String CustomerAddress) {
        this.CustomerAddress = CustomerAddress;
    }

    /**
     * @return the CustomerTelePoneNO
     */
    public int getCustomerTelePoneNO() {
        return CustomerTelePoneNO;
    }

    /**
     * @param CustomerTelePoneNO the CustomerTelePoneNO to set
     */
    public void setCustomerTelePoneNO(int CustomerTelePoneNO) {
        this.CustomerTelePoneNO = CustomerTelePoneNO;
    }

    /**
     * @return the OtherTelePoneNO
     */
    public int getOtherTelePoneNO() {
        return OtherTelePoneNO;
    }

    /**
     * @param OtherTelePoneNO the OtherTelePoneNO to set
     */
    public void setOtherTelePoneNO(int OtherTelePoneNO) {
        this.OtherTelePoneNO = OtherTelePoneNO;
    }

    /**
     * @return the StringNote
     */
    public String getStringNote() {
        return StringNote;
    }

    /**
     * @param StringNote the StringNote to set
     */
    public void setStringNote(String StringNote) {
        this.StringNote = StringNote;
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
        return "CustomerDTO{" + "customerID=" + customerID + ", OrderID=" + OrderID + ", TeleponeOperterName=" + TeleponeOperterName + ", CustomerName=" + CustomerName + ", CustomerAddress=" + CustomerAddress + ", CustomerTelePoneNO=" + CustomerTelePoneNO + ", OtherTelePoneNO=" + OtherTelePoneNO + ", StringNote=" + StringNote + ", Time=" + Time + ", Date=" + Date + '}';
    }

   
   
}
