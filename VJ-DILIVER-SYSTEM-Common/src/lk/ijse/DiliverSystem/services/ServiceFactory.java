/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverSystem.services;

import java.rmi.Remote;

/**
 *
 * @author viraj jaysanka
 */
public interface ServiceFactory extends Remote{
    
    public enum ServiceTypes{
        ADDDILIVERYRIDER,CALLSENTER , TAKEORDER ,CUSTOMER, CUSTOMERDITILS , SUBMITORDER ,LOGINGRIDER ,RIDERGETORDER , SAVEORDER , ITEMPRICE , ORDERDITAILS
    }
    
    public SuperService getService(ServiceTypes type) throws Exception;
    
}
