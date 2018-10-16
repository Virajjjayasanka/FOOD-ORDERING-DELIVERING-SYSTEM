/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverSystem.controller;

import java.util.List;
import lk.ijse.DiliverSystem.dto.CustomerDTO;
import lk.ijse.DiliverSystem.observer.Subject;
import lk.ijse.DiliverSystem.proxy.ProxyHandler;
import lk.ijse.DiliverSystem.service.custom.CustomerServic;
import lk.ijse.DiliverSystem.services.ServiceFactory;

/**
 *
 * @author Viraj jayasanka
 */
public class ManageCustomerController {
    
    public static boolean addCustomer(CustomerDTO customerDTO) throws Exception{
        CustomerServic customerServic = (CustomerServic) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CUSTOMER);
        return customerServic.addaCustomer(customerDTO);
    }
    
    public static boolean updateCustomer(CustomerDTO customerDTO) throws Exception{
        CustomerServic customerServic = (CustomerServic) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CUSTOMER);
        return customerServic.updateCustomer(customerDTO);
    }

    public static boolean deleteCustomer(int Id) throws Exception{
        CustomerServic customerServic = (CustomerServic) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CUSTOMER);
        return customerServic.deleteCustomer(Id);
    }    
    
    public static List<CustomerDTO> getAllCustomers() throws Exception{
        CustomerServic customerServic = (CustomerServic) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CUSTOMER);
        return customerServic.getAllCustomer();
    }
     public static List<CustomerDTO> CustomerNAmeALL(String name) throws Exception{
        CustomerServic customerServic = (CustomerServic) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CUSTOMER);
        System.out.print("+Controller :"+ name);
        // System.out.println(CustomerNAmeALL);
        return  customerServic.getCustomerName(name); 
    }    
    
   public static Subject getSubject() throws Exception{
        return (Subject) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CUSTOMER);
    }
    
    
    public static boolean reserveCustomer(String Id) throws Exception{
        CustomerServic customerServic = (CustomerServic) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CUSTOMER);
        return customerServic.reserve(Id);
    }
    
    public static boolean releaseCustomer(String Id) throws Exception{
        CustomerServic customerServic = (CustomerServic) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CUSTOMER);
        return customerServic.release(Id);
    }    
}
