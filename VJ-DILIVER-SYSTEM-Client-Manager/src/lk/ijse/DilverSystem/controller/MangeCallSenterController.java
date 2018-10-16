/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DilverSystem.controller;

import java.util.List;
import lk.ijse.DiliverSystem.dto.CallSenterDTO;
import lk.ijse.DiliverSystem.observer.Subject;
import lk.ijse.DiliverSystem.proxy.ProxyHandler;
import lk.ijse.DiliverSystem.service.custom.CallSenterService;
import lk.ijse.DiliverSystem.services.ServiceFactory;

/**
 *
 * @author Viraj jayasanka
 */
public class MangeCallSenterController {
     
    public static boolean addCallSener(CallSenterDTO callSenterDTO) throws Exception{
        CallSenterService callSenterService = (CallSenterService)ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CALLSENTER);
        return callSenterService.addDiliveryRider(callSenterDTO);
    }
    
    public static boolean updateCallSener(CallSenterDTO callSenterDTO) throws Exception{
        CallSenterService callSenterService = (CallSenterService)ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CALLSENTER);
        return callSenterService.updateDiliveryRider(callSenterDTO);
    }

    public static boolean deleteCallSener(String Id) throws Exception{
        CallSenterService callSenterService = (CallSenterService)ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CALLSENTER);
        return callSenterService.deleteDiliveryRider(Id);
    }    
    
    public static List<CallSenterDTO> getAllDiliverRiders() throws Exception{
        CallSenterService callSenterService = (CallSenterService)ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CALLSENTER);
        return callSenterService.getAllDiliveryRider();
    }

    
   public static Subject getSubject() throws Exception{
        return (Subject) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CALLSENTER);
    }
    
    
    public static boolean reserveDiliverRider(String Id) throws Exception{
       CallSenterService callSenterService = (CallSenterService)ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CALLSENTER);
        return callSenterService.reserve(Id);
    }
    
    public static boolean releaseDiliverRider(String Id) throws Exception{
         CallSenterService callSenterService = (CallSenterService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CALLSENTER);
        return callSenterService.release(Id);
    }    

    
}
