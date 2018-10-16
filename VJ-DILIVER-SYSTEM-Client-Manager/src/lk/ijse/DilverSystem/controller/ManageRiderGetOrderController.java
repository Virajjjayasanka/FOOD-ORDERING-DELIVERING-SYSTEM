/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DilverSystem.controller;

import java.util.List;
import lk.ijse.DiliverSystem.dto.RiderGetOrderDTO;
import lk.ijse.DiliverSystem.observer.Subject;
import lk.ijse.DiliverSystem.proxy.ProxyHandler;
import lk.ijse.DiliverSystem.service.custom.RiderGetOrderService;
import lk.ijse.DiliverSystem.services.ServiceFactory;

/**
 *
 * @author Viraj jayasanka
 */
public class ManageRiderGetOrderController {
    
    public static boolean addRiderGetOrder(RiderGetOrderDTO getOrderDTO) throws Exception{
        RiderGetOrderService getOrderService = (RiderGetOrderService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.RIDERGETORDER);
       // System.out.print(getOrderDTO);
        return getOrderService.addaRiderGetOrder(getOrderDTO);
    }
    
    public static boolean updateRiderGetOrder(RiderGetOrderDTO getOrderDTO) throws Exception{
         RiderGetOrderService getOrderService = (RiderGetOrderService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.RIDERGETORDER);
        return getOrderService.updateRiderGetOrder(getOrderDTO);
    }

    public static boolean deleteRiderGetOrder(int Id) throws Exception{
        RiderGetOrderService getOrderService = (RiderGetOrderService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.RIDERGETORDER);
        System.out.print(Id);
        return getOrderService.deleteRiderGetOrderr(Id);
    }    
    
    public static List<RiderGetOrderDTO> getAllRiderGetOrder() throws Exception{
        RiderGetOrderService getOrderService = (RiderGetOrderService)ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.RIDERGETORDER);
        return getOrderService.getAllRiderGetOrders();
    }

    
   public static Subject getSubject() throws Exception{
        return (Subject) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.RIDERGETORDER);
    }
    
    
    public static boolean reserveRiderGetOrder(String Id) throws Exception{
       RiderGetOrderService getOrderService = (RiderGetOrderService)ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.RIDERGETORDER);
        return getOrderService.reserve(Id);
    }
    
    public static boolean releaseRiderGetOrder(String Id) throws Exception{
        RiderGetOrderService getOrderService = (RiderGetOrderService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.RIDERGETORDER);
        return getOrderService.release(Id);
        
    }    
}
