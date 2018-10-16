/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverSystem.controller;

import java.util.List;
import lk.ijse.DiliverSystem.dto.SubmitOrderDTO;
import lk.ijse.DiliverSystem.observer.Subject;
import lk.ijse.DiliverSystem.proxy.ProxyHandler;
import lk.ijse.DiliverSystem.service.custom.SubmitOrderService;
import lk.ijse.DiliverSystem.services.ServiceFactory;

/**
 *
 * @author Viraj jayasanka
 */
public class MangeSubmitOrderController {
    
    public static boolean addSubmitOrder(SubmitOrderDTO submitOrderDTO) throws Exception{
        SubmitOrderService submitOrderService = (SubmitOrderService)ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.SUBMITORDER);
        return submitOrderService.addaSubmitOrder(submitOrderDTO);
    }
    
    public static boolean updateSubmitOrder(SubmitOrderDTO submitOrderDTO) throws Exception{
        SubmitOrderService submitOrderService = (SubmitOrderService)ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.SUBMITORDER);
        return submitOrderService.updateSubmitOrder(submitOrderDTO);
    }

    public static boolean deleteSubmitOrder(int Id) throws Exception{
        SubmitOrderService callSenterService = (SubmitOrderService)ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.SUBMITORDER);
        return callSenterService.deleteSubmitOrder(Id);
    }    
    
    public static List<SubmitOrderDTO> getAllSubmitOrders() throws Exception{
        SubmitOrderService submitOrderService = (SubmitOrderService)ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.SUBMITORDER);
        return submitOrderService.getAllSubmitOrders();
    }

    
   public static Subject getSubject() throws Exception{
        return (Subject) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.SUBMITORDER);
    }
    
    
    public static boolean reserveSubmitOrder(String Id) throws Exception{
       SubmitOrderService submitOrderService = (SubmitOrderService)ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.SUBMITORDER);
        return submitOrderService.reserve(Id);
    }
    
    public static boolean releaseSubmitOrder(String Id) throws Exception{
         SubmitOrderService submitOrderService = (SubmitOrderService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.SUBMITORDER);
        return submitOrderService.release(Id);
    }    

}
