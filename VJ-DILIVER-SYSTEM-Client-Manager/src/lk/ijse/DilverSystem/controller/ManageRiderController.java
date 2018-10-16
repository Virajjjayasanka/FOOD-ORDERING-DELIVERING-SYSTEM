/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DilverSystem.controller;

import java.util.List;
//import javax.security.observer.Subject;
import lk.ijse.DiliverSystem.dto.DiliveryRiderDTO;
import lk.ijse.DiliverSystem.proxy.ProxyHandler;
import lk.ijse.DiliverSystem.service.custom.AddDiliveryRiderService;
import lk.ijse.DiliverSystem.services.ServiceFactory;
import java.util.List;
import lk.ijse.DiliverSystem.observer.Subject;

/**
 *
 * @author Viraj jayasanka
 */
public class ManageRiderController {
    
    public static boolean addDiliveryRider(DiliveryRiderDTO diliveryRiderDTO) throws Exception{
        AddDiliveryRiderService addDiliveryRiderService = (AddDiliveryRiderService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ADDDILIVERYRIDER);
        return addDiliveryRiderService.addDiliveryRider(diliveryRiderDTO);
    }
    
    public static boolean updateDiliverRider(DiliveryRiderDTO diliveryRiderDTO) throws Exception{
        AddDiliveryRiderService addDiliveryRiderService = (AddDiliveryRiderService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ADDDILIVERYRIDER);
        return addDiliveryRiderService.updateDiliveryRider(diliveryRiderDTO);
    }

    public static boolean deleteDiliverRider(String Id) throws Exception{
        AddDiliveryRiderService addDiliveryRiderService = (AddDiliveryRiderService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ADDDILIVERYRIDER);
        return addDiliveryRiderService.deleteDiliveryRider(Id);
    }    
    
    public static List<DiliveryRiderDTO> getAllDiliverRiders() throws Exception{
        AddDiliveryRiderService addDiliveryRiderService = (AddDiliveryRiderService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ADDDILIVERYRIDER);
        return addDiliveryRiderService.getAllDiliveryRider();
    }

    
   public static Subject getSubject() throws Exception{
        return (Subject) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ADDDILIVERYRIDER);
    }
    
    
    public static boolean reserveDiliverRider(String Id) throws Exception{
        AddDiliveryRiderService addDiliveryRiderService = (AddDiliveryRiderService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ADDDILIVERYRIDER);
        return addDiliveryRiderService.reserve(Id);
    }
    
    public static boolean releaseDiliverRider(String Id) throws Exception{
        AddDiliveryRiderService addDiliveryRiderService = (AddDiliveryRiderService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ADDDILIVERYRIDER);
        return addDiliveryRiderService.release(Id);
    }    

    
}
