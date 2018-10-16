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
    
    
    public static boolean addCustomerDetail(AddCustomerDetailsDTO addCustomerDetailsDTO) throws Exception{
        CustomerDitalService customerDitalService = (CustomerDitalService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CUSTOMERDITILS);
        return customerDitalService.addaCustomerDitils(addCustomerDetailsDTO);
    }
    
    public static boolean updateCustomerDetail(AddCustomerDetailsDTO addCustomerDetailsDTO) throws Exception{
        CustomerDitalService customerDitalService = (CustomerDitalService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CUSTOMERDITILS);
        return customerDitalService.updateCustomerDitils(addCustomerDetailsDTO);
    }

    public static boolean deleteCustomerDetail(int Id) throws Exception{
        CustomerDitalService customerDitalService = (CustomerDitalService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CUSTOMERDITILS);
        return customerDitalService.deleteCustomerDitils(Id);
    }    
    
    public static List<AddCustomerDetailsDTO> getAllCustomerDetails() throws Exception{
        CustomerDitalService customerDitalService = (CustomerDitalService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CUSTOMERDITILS);
        return customerDitalService.getAllCustomerDitils();
    }
    
//     public static List<AddCustomerDetailsDTO> SearchCustomerDetail(String name) throws Exception{
//        CustomerDitalService customerDitalService = (CustomerDitalService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CUSTOMERDITILS);
//        return  customerDitalService.SearchCustomerDitails(name);
//    }   
    
    public static Subject getSubject() throws Exception{
        return (Subject) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CUSTOMERDITILS);
    }
    
    
    public static boolean reserveCustomerDetail(String Id) throws Exception{
        CustomerDitalService customerDitalService = (CustomerDitalService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CUSTOMERDITILS);
        return customerDitalService.reserve(Id);
    }
    
    public static boolean releaseCustomerDetail(String Id) throws Exception{
        CustomerDitalService customerDitalService = (CustomerDitalService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CUSTOMERDITILS);
        return customerDitalService.release(Id);
    }    
}
