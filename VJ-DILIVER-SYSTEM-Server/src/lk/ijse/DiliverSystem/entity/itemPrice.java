/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverSystem.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Viraj jayasanka
 */
@Entity
public class itemPrice {
    @Id
    private int ID;
    private String ItemName;
    private double unitPrice;

    public itemPrice() {
    }

    public itemPrice(int ID, String ItemName, double unitPrice) {
        this.ID = ID;
        this.ItemName = ItemName;
        this.unitPrice = unitPrice;
    }

    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * @return the ItemName
     */
    public String getItemName() {
        return ItemName;
    }

    /**
     * @param ItemName the ItemName to set
     */
    public void setItemName(String ItemName) {
        this.ItemName = ItemName;
    }

    /**
     * @return the unitPrice
     */
    public double getUnitPrice() {
        return unitPrice;
    }

    /**
     * @param unitPrice the unitPrice to set
     */
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "itemPrice{" + "ID=" + ID + ", ItemName=" + ItemName + ", unitPrice=" + unitPrice + '}';
    }
    
    
}
