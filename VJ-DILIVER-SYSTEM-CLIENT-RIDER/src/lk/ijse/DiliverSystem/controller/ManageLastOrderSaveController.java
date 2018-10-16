/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverSystem.controller;

import java.util.List;
import lk.ijse.DiliverSystem.dto.LasetOrderSaveDTO;
import lk.ijse.DiliverSystem.observer.Subject;
import lk.ijse.DiliverSystem.proxy.ProxyHandler;
import lk.ijse.DiliverSystem.service.custom.LastSaveOrderService;
import lk.ijse.DiliverSystem.services.ServiceFactory;

/**
 *
 * @author Viraj jayasanka
 */
public class ManageLastOrderSaveController {
   
    
    public static boolean addLastOrderSave(LasetOrderSaveDTO lasetOrderSaveDTO) throws Exception{
        LastSaveOrderService lastSaveOrderService = (LastSaveOrderService)ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.SAVEORDER);
        System.out.print(lasetOrderSaveDTO);
        return lastSaveOrderService.addaLastSaveOrder(lasetOrderSaveDTO);
    }
    
    public static boolean updateLastOrderSave(LasetOrderSaveDTO lasetOrderSaveDTO) throws Exception{
        LastSaveOrderService lastSaveOrderService = (LastSaveOrderService)ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.SAVEORDER);
        return lastSaveOrderService.updateLastSaveOrder(lasetOrderSaveDTO);
    }

    public static boolean deleteLastOrderSave(int Id) throws Exception{
        LastSaveOrderService lastSaveOrderService = (LastSaveOrderService)ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.SAVEORDER);
        return lastSaveOrderService.deleteLastSaveOrder(Id);
    }    
    
    public static List<LasetOrderSaveDTO> getAllLastOrderSaves() throws Exception{
        LastSaveOrderService lastSaveOrderService = (LastSaveOrderService)ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.SAVEORDER);
        return lastSaveOrderService.getAllLastSaveOrder();
    }

    
   public static Subject getSubject() throws Exception{
        return (Subject) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.SAVEORDER);
    }
    
    
    public static boolean reserveLastOrderSave(String Id) throws Exception{
       LastSaveOrderService lastSaveOrderService = (LastSaveOrderService)ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.SAVEORDER);
        return lastSaveOrderService.reserve(Id);
    }
    
    public static boolean releaseLastOrderSave(String Id) throws Exception{
         LastSaveOrderService lastSaveOrderService = (LastSaveOrderService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.SAVEORDER);
        return lastSaveOrderService.release(Id);
    }    

}
