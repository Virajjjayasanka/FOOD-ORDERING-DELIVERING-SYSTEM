/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverSystem.controller;

import java.util.List;
import lk.ijse.DiliverSystem.dto.OrderDitailsDTO;
import lk.ijse.DiliverSystem.observer.Subject;
import lk.ijse.DiliverSystem.proxy.ProxyHandler;
import lk.ijse.DiliverSystem.service.custom.OrderDitailSperService;
import lk.ijse.DiliverSystem.services.ServiceFactory;

/**
 *
 * @author Viraj jayasanka
 */
public class ManageOrderDitalController {
    
     public static boolean addOrderDital(OrderDitailsDTO orderDitailsDTO) throws Exception{
         OrderDitailSperService orderDitailSperService = (OrderDitailSperService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ORDERDITAILS);
         return orderDitailSperService.addaOrderDitail(orderDitailsDTO);
    }
    
    public static boolean updateOrderDital(OrderDitailsDTO orderDitailsDTO) throws Exception{
         OrderDitailSperService orderDitailSperService = (OrderDitailSperService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ORDERDITAILS);
        return orderDitailSperService.updateOrderDitail(orderDitailsDTO);
    }

    public static boolean deleteOrderDital(int Id) throws Exception{
        OrderDitailSperService orderDitailSperService = (OrderDitailSperService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ORDERDITAILS);
        return orderDitailSperService.deleteOrderDitail(Id);
    }    
    
    public static List<OrderDitailsDTO> getAllOrderDitals() throws Exception{
         OrderDitailSperService orderDitailSperService = (OrderDitailSperService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ORDERDITAILS);
        return orderDitailSperService.getAllOrderDitails();
    }
    
     public static List<OrderDitailsDTO> getOrderDeatilsID(String name) throws Exception{
         OrderDitailSperService orderDitailSperService = (OrderDitailSperService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ORDERDITAILS);
        return  orderDitailSperService.getOrderDitailsId(name);
       
    }    

   public static Subject getSubject() throws Exception{
        return (Subject) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ORDERDITAILS);
    }
    
    public static boolean reserveTakeOrder(String Id) throws Exception{
         OrderDitailSperService orderDitailSperService = (OrderDitailSperService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ORDERDITAILS);
        return orderDitailSperService.reserve(Id);
    }
    
    public static boolean releaseTakeOrder(String Id) throws Exception{
        OrderDitailSperService orderDitailSperService = (OrderDitailSperService)ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ORDERDITAILS);
        return orderDitailSperService.release(Id);
    }    

}
