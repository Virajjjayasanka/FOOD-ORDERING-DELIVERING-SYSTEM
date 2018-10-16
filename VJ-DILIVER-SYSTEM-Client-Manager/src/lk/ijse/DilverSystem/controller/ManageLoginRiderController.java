/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DilverSystem.controller;

import java.util.List;
import lk.ijse.DiliverSystem.dto.LoginRiderDTO;
import lk.ijse.DiliverSystem.observer.Subject;
import lk.ijse.DiliverSystem.proxy.ProxyHandler;
import lk.ijse.DiliverSystem.service.custom.LoginRiderService;
import lk.ijse.DiliverSystem.services.ServiceFactory;

/**
 *
 * @author Viraj jayasanka
 */
public class ManageLoginRiderController {
    
    public static boolean addLoginRider(LoginRiderDTO loginRiderDTO) throws Exception{
        LoginRiderService loginRiderService = (LoginRiderService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.LOGINGRIDER);
        return loginRiderService.addaLoginRider(loginRiderDTO);
    }
    
    public static boolean deleteLoginRider(int Id) throws Exception{
        LoginRiderService loginRiderService = (LoginRiderService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.LOGINGRIDER);
        return loginRiderService.deleteLoginRider(Id);
    }    
    
    public static List<LoginRiderDTO> getAllLoginRiders() throws Exception{
        LoginRiderService loginRiderService = (LoginRiderService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.LOGINGRIDER);
        return loginRiderService.getAllLoginRiders();
    }
    
     public static Subject getSubject() throws Exception{
        return (Subject) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.SUBMITORDER);
    }
    
}
