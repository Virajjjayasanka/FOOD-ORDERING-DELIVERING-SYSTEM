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
public class CallSenterDTO extends SuperDTO{
    private String CallSenterID;
    private String Name;
    private String Address;
    private int TeloponeNo;
    private int age;
    private String NIC;
    private double Salary;
    private String Time;
    private String Date;

    public CallSenterDTO() {
    }

    /**
     * @return the CallSenterID
     */
    public String getCallSenterID() {
        return CallSenterID;
    }

    public CallSenterDTO(String CallSenterID, String Name, String Address, int TeloponeNo, int age, String NIC, double Salary, String Time, String Date) {
        this.CallSenterID = CallSenterID;
        this.Name = Name;
        this.Address = Address;
        this.TeloponeNo = TeloponeNo;
        this.age = age;
        this.NIC = NIC;
        this.Salary = Salary;
        this.Time = Time;
        this.Date = Date;
    }

    /**
     * @param CallSenterID the CallSenterID to set
     */
    public void setCallSenterID(String CallSenterID) {
        this.CallSenterID = CallSenterID;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the Address
     */
    public String getAddress() {
        return Address;
    }

    /**
     * @param Address the Address to set
     */
    public void setAddress(String Address) {
        this.Address = Address;
    }

    /**
     * @return the TeloponeNo
     */
    public int getTeloponeNo() {
        return TeloponeNo;
    }

    /**
     * @param TeloponeNo the TeloponeNo to set
     */
    public void setTeloponeNo(int TeloponeNo) {
        this.TeloponeNo = TeloponeNo;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
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
    public double getSalary() {
        return Salary;
    }

    /**
     * @param Salary the Salary to set
     */
    public void setSalary(double Salary) {
        this.Salary = Salary;
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
        return "CallSenterDTO{" + "CallSenterID=" + CallSenterID + ", Name=" + Name + ", Address=" + Address + ", TeloponeNo=" + TeloponeNo + ", age=" + age + ", NIC=" + NIC + ", Salary=" + Salary + ", Time=" + Time + ", Date=" + Date + '}';
    }

   
}
