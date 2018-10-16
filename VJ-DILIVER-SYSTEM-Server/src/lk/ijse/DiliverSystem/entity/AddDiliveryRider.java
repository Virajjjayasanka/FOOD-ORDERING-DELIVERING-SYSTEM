/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverSystem.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Viraj jayasanka
 */
@Entity

public class AddDiliveryRider {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    private String RiderNAme;
    private String RiderAddress;
    private int RiderTelePoneNO;
    private String NIC;
    private Double Salary;
    private String Date;
    private String Time;

    public AddDiliveryRider() {
    }

    public AddDiliveryRider( String RiderNAme, String RiderAddress, int RiderTelePoneNO, String NIC, Double Salary, String Date, String Time) {
        
        this.RiderNAme = RiderNAme;
        this.RiderAddress = RiderAddress;
        this.RiderTelePoneNO = RiderTelePoneNO;
        this.NIC = NIC;
        this.Salary = Salary;
        this.Date = Date;
        this.Time = Time;
    }

    public AddDiliveryRider(int Id, String RiderNAme, String RiderAddress, int RiderTelePoneNO, String NIC, Double Salary, String Date, String Time) {
        this.Id = Id;
        this.RiderNAme = RiderNAme;
        this.RiderAddress = RiderAddress;
        this.RiderTelePoneNO = RiderTelePoneNO;
        this.NIC = NIC;
        this.Salary = Salary;
        this.Date = Date;
        this.Time = Time;
    }

    /**
     * @return the Id
     */
    public int getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(int Id) {
        this.Id = Id;
    }

    /**
     * @return the RiderNAme
     */
    public String getRiderNAme() {
        return RiderNAme;
    }

    /**
     * @param RiderNAme the RiderNAme to set
     */
    public void setRiderNAme(String RiderNAme) {
        this.RiderNAme = RiderNAme;
    }

    /**
     * @return the RiderAddress
     */
    public String getRiderAddress() {
        return RiderAddress;
    }

    /**
     * @param RiderAddress the RiderAddress to set
     */
    public void setRiderAddress(String RiderAddress) {
        this.RiderAddress = RiderAddress;
    }

    /**
     * @return the RiderTelePoneNO
     */
    public int getRiderTelePoneNO() {
        return RiderTelePoneNO;
    }

    /**
     * @param RiderTelePoneNO the RiderTelePoneNO to set
     */
    public void setRiderTelePoneNO(int RiderTelePoneNO) {
        this.RiderTelePoneNO = RiderTelePoneNO;
    }

    /**
     * @return the NIC
     */
    public String getNIC() {
        return NIC;
    }

    /**
     * @param NIC the NIC to set
     */
    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    /**
     * @return the Salary
     */
    public Double getSalary() {
        return Salary;
    }

    /**
     * @param Salary the Salary to set
     */
    public void setSalary(Double Salary) {
        this.Salary = Salary;
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
        return "AddDiliveryRider{" + "Id=" + Id + ", RiderNAme=" + RiderNAme + ", RiderAddress=" + RiderAddress + ", RiderTelePoneNO=" + RiderTelePoneNO + ", NIC=" + NIC + ", Salary=" + Salary + ", Date=" + Date + ", Time=" + Time + '}';
    }

    
}
