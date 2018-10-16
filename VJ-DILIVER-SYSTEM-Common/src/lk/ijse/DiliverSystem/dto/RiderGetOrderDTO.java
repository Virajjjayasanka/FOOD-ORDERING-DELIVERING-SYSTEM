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
public class RiderGetOrderDTO extends SuperDTO{
    private int SubmitOrderID;
    private int Orderid;
    private String TeleponeOperterName;
    private String CustomerID;
    private double Total;
    private String RiderName;
    private String Time;

    public RiderGetOrderDTO() {
    }

    public RiderGetOrderDTO(int SubmitOrderID, int Orderid, String TeleponeOperterName, String CustomerID, double Total, String RiderName, String Time) {
        this.SubmitOrderID = SubmitOrderID;
        this.Orderid = Orderid;
        this.TeleponeOperterName = TeleponeOperterName;
        this.CustomerID = CustomerID;
        this.Total = Total;
        this.RiderName = RiderName;
        this.Time = Time;
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
     * @return the Orderid
     */
    public int getOrderid() {
        return Orderid;
    }

    /**
     * @param Orderid the Orderid to set
     */
    public void setOrderid(int Orderid) {
        this.Orderid = Orderid;
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
        return "RiderGetOrderDTO{" + "SubmitOrderID=" + SubmitOrderID + ", Orderid=" + Orderid + ", TeleponeOperterName=" + TeleponeOperterName + ", CustomerID=" + CustomerID + ", Total=" + Total + ", RiderName=" + RiderName + ", Time=" + Time + '}';
    }

  
    
   
}
