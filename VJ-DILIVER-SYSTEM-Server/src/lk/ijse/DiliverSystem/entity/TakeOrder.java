/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverSystem.entity;

import com.sun.tracing.dtrace.Attributes;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

/**
 *
 * @author Viraj jayasanka
 */

@Entity
@NamedNativeQuery(name="TeleponeOperterName" , query="select  OrderID ,Date , DilveryCharges,ItemTextAriya, Payment,SubTotal,TelepOneOperterName ,Time,Total\n" +
"	from takeorder where  TelepOneOperterName  = ?",resultClass = TakeOrder.class)
public class TakeOrder {
    @Id
    
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int OrderID;
    private String TelepOneOperterName;
    private double DilveryCharges;
    private double SubTotal;
    private double Total;
    private String ItemTextAriya;
    private String Payment;
    private String Date;
    private String Time;

    public TakeOrder() {
    }

    public TakeOrder( String TelepOneOperterName, double DilveryCharges, double SubTotal, double Total, String ItemTextAriya, String Payment, String Date, String Time) {
        this.TelepOneOperterName = TelepOneOperterName;
        this.DilveryCharges = DilveryCharges;
        this.SubTotal = SubTotal;
        this.Total = Total;
        this.ItemTextAriya = ItemTextAriya;
        this.Payment = Payment;
        this.Date = Date;
        this.Time = Time;
    }

    public TakeOrder(int OrderID, String TelepOneOperterName, double DilveryCharges, double SubTotal, double Total, String ItemTextAriya, String Payment, String Date, String Time) {
        this.OrderID = OrderID;
        this.TelepOneOperterName = TelepOneOperterName;
        this.DilveryCharges = DilveryCharges;
        this.SubTotal = SubTotal;
        this.Total = Total;
        this.ItemTextAriya = ItemTextAriya;
        this.Payment = Payment;
        this.Date = Date;
        this.Time = Time;
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
     * @return the TelepOneOperterName
     */
    public String getTelepOneOperterName() {
        return TelepOneOperterName;
    }

    /**
     * @param TelepOneOperterName the TelepOneOperterName to set
     */
    public void setTelepOneOperterName(String TelepOneOperterName) {
        this.TelepOneOperterName = TelepOneOperterName;
    }

    /**
     * @return the DilveryCharges
     */
    public double getDilveryCharges() {
        return DilveryCharges;
    }

    /**
     * @param DilveryCharges the DilveryCharges to set
     */
    public void setDilveryCharges(double DilveryCharges) {
        this.DilveryCharges = DilveryCharges;
    }

    /**
     * @return the SubTotal
     */
    public double getSubTotal() {
        return SubTotal;
    }

    /**
     * @param SubTotal the SubTotal to set
     */
    public void setSubTotal(double SubTotal) {
        this.SubTotal = SubTotal;
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
     * @return the ItemTextAriya
     */
    public String getItemTextAriya() {
        return ItemTextAriya;
    }

    /**
     * @param ItemTextAriya the ItemTextAriya to set
     */
    public void setItemTextAriya(String ItemTextAriya) {
        this.ItemTextAriya = ItemTextAriya;
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
        return "TakeOrder{" + "OrderID=" + OrderID + ", TelepOneOperterName=" + TelepOneOperterName + ", DilveryCharges=" + DilveryCharges + ", SubTotal=" + SubTotal + ", Total=" + Total + ", ItemTextAriya=" + ItemTextAriya + ", Payment=" + Payment + ", Date=" + Date + ", Time=" + Time + '}';
    }
    
}
