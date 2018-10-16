/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverSystem.controller;

import java.util.List;
import lk.ijse.DiliverSystem.dto.AddCustomerDetailsDTO;
import lk.ijse.DiliverSystem.observer.Subject;
import lk.ijse.DiliverSystem.proxy.ProxyHandler;
import lk.ijse.DiliverSystem.service.custom.CustomerDitalService;
import lk.ijse.DiliverSystem.services.ServiceFactory;

/**
 *
 * @author Viraj jayasanka
 */
public class ManageCustomerDetailControoler {
    
   
    
    public static List<AddCustomerDetailsDTO> SeachCustomerID(String CustomerID) throws Exception{
        CustomerDitalService customerDitalService = (CustomerDitalService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CUSTOMERDITILS);
       System.out.print("Cntoller"+CustomerID);
           return customerDitalService.SearchCustomerDitails(CustomerID);
    }
     public static List<AddCustomerDetailsDTO> getAllSubmitOrders() throws Exception{
         CustomerDitalService customerDitalService = (CustomerDitalService)ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CUSTOMERDITILS);
        return customerDitalService.getAllCustomerDitils();
    }
}
