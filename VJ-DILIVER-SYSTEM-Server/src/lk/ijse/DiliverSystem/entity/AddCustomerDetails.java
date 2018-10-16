/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverSystem.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import org.hibernate.annotations.NamedNativeQueries;

/**
 *
 * @author Viraj jayasanka
 */
@Entity
@NamedNativeQuery(name = "CustomeReDelatAdd" ,query="select * from addcustomerdetails where CustomeID  = ?",resultClass = AddCustomerDetails.class)
        


//@NamedNativeQueries
public class AddCustomerDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int SaveOrderID;
    private String CustomeID;
    private String OrderID;
    private String CustomerName;
    private String CustomerAddress;
    private int CustomertelponeNO;
    private int CustomerOtherNO;
    private String Time;
    private String Date;

    public AddCustomerDetails() {
    }

    public AddCustomerDetails( String CustomeID, String OrderID, String CustomerName, String CustomerAddress, int CustomertelponeNO, int CustomerOtherNO, String Time, String Date) {
        this.SaveOrderID = SaveOrderID;
        this.CustomeID = CustomeID;
        this.OrderID = OrderID;
        this.CustomerName = CustomerName;
        this.CustomerAddress = CustomerAddress;
        this.CustomertelponeNO = CustomertelponeNO;
        this.CustomerOtherNO = CustomerOtherNO;
        this.Time = Time;
        this.Date = Date;
    }

    public AddCustomerDetails(int SaveOrderID, String CustomeID, String OrderID, String CustomerName, String CustomerAddress, int CustomertelponeNO, int CustomerOtherNO, String Time, String Date) {
        this.SaveOrderID = SaveOrderID;
        this.CustomeID = CustomeID;
        this.OrderID = OrderID;
        this.CustomerName = CustomerName;
        this.CustomerAddress = CustomerAddress;
        this.CustomertelponeNO = CustomertelponeNO;
        this.CustomerOtherNO = CustomerOtherNO;
        this.Time = Time;
        this.Date = Date;
    }

    /**
     * @return the SaveOrderID
     */
    public int getSaveOrderID() {
        return SaveOrderID;
    }

    /**
     * @param SaveOrderID the SaveOrderID to set
     */
    public void setSaveOrderID(int SaveOrderID) {
        this.SaveOrderID = SaveOrderID;
    }

    /**
     * @return the CustomeID
     */
    public String getCustomeID() {
        return CustomeID;
    }

    /**
     * @param CustomeID the CustomeID to set
     */
    public void setCustomeID(String CustomeID) {
        this.CustomeID = CustomeID;
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
     * @return the CustomertelponeNO
     */
    public int getCustomertelponeNO() {
        return CustomertelponeNO;
    }

    /**
     * @param CustomertelponeNO the CustomertelponeNO to set
     */
    public void setCustomertelponeNO(int CustomertelponeNO) {
        this.CustomertelponeNO = CustomertelponeNO;
    }

    /**
     * @return the CustomerOtherNO
     */
    public int getCustomerOtherNO() {
        return CustomerOtherNO;
    }

    /**
     * @param CustomerOtherNO the CustomerOtherNO to set
     */
    public void setCustomerOtherNO(int CustomerOtherNO) {
        this.CustomerOtherNO = CustomerOtherNO;
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
        return "AddCustomerDetails{" + "SaveOrderID=" + SaveOrderID + ", CustomeID=" + CustomeID + ", OrderID=" + OrderID + ", CustomerName=" + CustomerName + ", CustomerAddress=" + CustomerAddress + ", CustomertelponeNO=" + CustomertelponeNO + ", CustomerOtherNO=" + CustomerOtherNO + ", Time=" + Time + ", Date=" + Date + '}';
    }
   
 
}
