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
public class LoginRiderDTO extends SuperDTO{
   
    private int RiderID;
    private String RiderNAme;
    private String Password;
    private String Time;

    public LoginRiderDTO() {
    }

    public LoginRiderDTO(int RiderID, String RiderNAme, String Password, String Time) {
        this.RiderID = RiderID;
        this.RiderNAme = RiderNAme;
        this.Password = Password;
        this.Time = Time;
    }

    /**
     * @return the RiderID
     */
    public int getRiderID() {
        return RiderID;
    }

    /**
     * @param RiderID the RiderID to set
     */
    public void setRiderID(int RiderID) {
        this.RiderID = RiderID;
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
     * @return the Password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * @param Password the Password to set
     */
    public void setPassword(String Password) {
        this.Password = Password;
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
        return "LoginRiderDTO{" + "RiderID=" + RiderID + ", RiderNAme=" + RiderNAme + ", Password=" + Password + ", Time=" + Time + '}';
    }
    
    


}