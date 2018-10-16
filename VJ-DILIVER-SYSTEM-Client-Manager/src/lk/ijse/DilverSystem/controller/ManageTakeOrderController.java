/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DilverSystem.controller;

import java.util.List;
import lk.ijse.DiliverSystem.dto.TakeOrderDTO;
import lk.ijse.DiliverSystem.observer.Subject;
import lk.ijse.DiliverSystem.proxy.ProxyHandler;
import lk.ijse.DiliverSystem.service.custom.TakeOrderService;
import lk.ijse.DiliverSystem.services.ServiceFactory;

/**
 *
 * @author Viraj jayasanka
 */
public class ManageTakeOrderController {
    
     public static boolean addTakeOrder(TakeOrderDTO takeOrderDTO) throws Exception{
         TakeOrderService takeOrderService = (TakeOrderService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.TAKEORDER);
         return takeOrderService.addaTakeOrder(takeOrderDTO);
    }
    
    public static boolean updateTakeOrder(TakeOrderDTO takeOrderDTO) throws Exception{
        TakeOrderService addDiliveryRiderService = (TakeOrderService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.TAKEORDER);
        return addDiliveryRiderService.updateTakeOrder(takeOrderDTO);
    }

    public static boolean deleteTakeOrder(int Id) throws Exception{
        TakeOrderService addDiliveryRiderService = (TakeOrderService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.TAKEORDER);
        return addDiliveryRiderService.deleteTakeOrder(Id);
    }    
    
    public static List<TakeOrderDTO> getAllTakeOrders() throws Exception{
        TakeOrderService addDiliveryRiderService = (TakeOrderService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.TAKEORDER);
        return addDiliveryRiderService.getAllTakeOrder();
    }
    
     public static List<TakeOrderDTO> QureTakeOrder(String name) throws Exception{
        TakeOrderService addDiliveryRiderService = (TakeOrderService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.TAKEORDER);
        return  addDiliveryRiderService.Qure(name);
       
    }    

    
   public static Subject getSubject() throws Exception{
        return (Subject) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.TAKEORDER);
    }
    
    
    public static boolean reserveTakeOrder(String Id) throws Exception{
        TakeOrderService takeOrderService = (TakeOrderService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.TAKEORDER);
        return takeOrderService.reserve(Id);
    }
    
    public static boolean releaseTakeOrder(String Id) throws Exception{
        TakeOrderService takeOrderService = (TakeOrderService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.TAKEORDER);
        return takeOrderService.release(Id);
    }    

}
