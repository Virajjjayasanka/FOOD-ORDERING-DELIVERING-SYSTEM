/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverSystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;

/**
 *
 * @author Viraj jayasanka
 */
@Entity
@NamedNativeQuery(name="lastOrderSave" , query="select * from lastordersave where date  = ?",resultClass = LastOrderSave.class)

public class LastOrderSave {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int SaveOrderId;
    private int SumbitOrderID;
    private int OrderID;
    private int CustomerID;
    private String TeleponrOPerterName;
    private String RiderName;
    private String GetOrderTime;
    private String OutOrderTime;
    private String Payament;
    private double Total;
    private String date;

    public LastOrderSave() {
    }

    public LastOrderSave( int SumbitOrderID, int OrderID, int CustomerID, String TeleponrOPerterName, String RiderName, String GetOrderTime, String OutOrderTime, String Payament, double Total, String date) {
       
        this.SumbitOrderID = SumbitOrderID;
        this.OrderID = OrderID;
        this.CustomerID = CustomerID;
        this.TeleponrOPerterName = TeleponrOPerterName;
        this.RiderName = RiderName;
        this.GetOrderTime = GetOrderTime;
        this.OutOrderTime = OutOrderTime;
        this.Payament = Payament;
        this.Total = Total;
        this.date = date;
    }

    public LastOrderSave(int SaveOrderId, int SumbitOrderID, int OrderID, int CustomerID, String TeleponrOPerterName, String RiderName, String GetOrderTime, String OutOrderTime, String Payament, double Total, String date) {
        this.SaveOrderId = SaveOrderId;
        this.SumbitOrderID = SumbitOrderID;
        this.OrderID = OrderID;
        this.CustomerID = CustomerID;
        this.TeleponrOPerterName = TeleponrOPerterName;
        this.RiderName = RiderName;
        this.GetOrderTime = GetOrderTime;
        this.OutOrderTime = OutOrderTime;
        this.Payament = Payament;
        this.Total = Total;
        this.date = date;
    }

    /**
     * @return the SaveOrderId
     */
    public int getSaveOrderId() {
        return SaveOrderId;
    }

    /**
     * @param SaveOrderId the SaveOrderId to set
     */
    public void setSaveOrderId(int SaveOrderId) {
        this.SaveOrderId = SaveOrderId;
    }

    /**
     * @return the SumbitOrderID
     */
    public int getSumbitOrderID() {
        return SumbitOrderID;
    }

    /**
     * @param SumbitOrderID the SumbitOrderID to set
     */
    public void setSumbitOrderID(int SumbitOrderID) {
        this.SumbitOrderID = SumbitOrderID;
    }

    /**
     * @return the OrderID
     */
    public int getOrderID() {
        return OrderID;
    }

    /**
     * @param OrderID the OrderID to set
     */
    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    /**
     * @return the CustomerID
     */
    public int getCustomerID() {
        return CustomerID;
    }

    /**
     * @param CustomerID the CustomerID to set
     */
    public void setCustomerID(int CustomerID) {
        this.CustomerID = CustomerID;
    }

    /**
     * @return the TeleponrOPerterName
     */
    public String getTeleponrOPerterName() {
        return TeleponrOPerterName;
    }

    /**
     * @param TeleponrOPerterName the TeleponrOPerterName to set
     */
    public void setTeleponrOPerterName(String TeleponrOPerterName) {
        this.TeleponrOPerterName = TeleponrOPerterName;
    }

    /**
     * @return the RiderName
     */
    public String getRiderName() {
        return RiderName;
    }

    /**
     * @param RiderName the RiderName to set
     */
    public void setRiderName(String RiderName) {
        this.RiderName = RiderName;
    }

    /**
     * @return the GetOrderTime
     */
    public String getGetOrderTime() {
        return GetOrderTime;
    }

    /**
     * @param GetOrderTime the GetOrderTime to set
     */
    public void setGetOrderTime(String GetOrderTime) {
        this.GetOrderTime = GetOrderTime;
    }

    /**
     * @return the OutOrderTime
     */
    public String getOutOrderTime() {
        return OutOrderTime;
    }

    /**
     * @param OutOrderTime the OutOrderTime to set
     */
    public void setOutOrderTime(String OutOrderTime) {
        this.OutOrderTime = OutOrderTime;
    }

    /**
     * @return the Payament
     */
    public String getPayament() {
        return Payament;
    }

    /**
     * @param Payament the Payament to set
     */
    public void setPayament(String Payament) {
        this.Payament = Payament;
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
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "LastOrderSave{" + "SaveOrderId=" + SaveOrderId + ", SumbitOrderID=" + SumbitOrderID + ", OrderID=" + OrderID + ", CustomerID=" + CustomerID + ", TeleponrOPerterName=" + TeleponrOPerterName + ", RiderName=" + RiderName + ", GetOrderTime=" + GetOrderTime + ", OutOrderTime=" + OutOrderTime + ", Payament=" + Payament + ", Total=" + Total + ", date=" + date + '}';
    }

}