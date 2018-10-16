/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverSystem.proxy;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.ijse.DiliverSystem.service.custom.AddDiliveryRiderService;
import lk.ijse.DiliverSystem.service.custom.CallSenterService;
import lk.ijse.DiliverSystem.service.custom.CustomerDitalService;
import lk.ijse.DiliverSystem.service.custom.CustomerServic;
import lk.ijse.DiliverSystem.service.custom.ItemPriceService;
import lk.ijse.DiliverSystem.service.custom.LastSaveOrderService;
import lk.ijse.DiliverSystem.service.custom.LoginRiderService;
import lk.ijse.DiliverSystem.service.custom.RiderGetOrderService;
import lk.ijse.DiliverSystem.service.custom.SubmitOrderService;
import lk.ijse.DiliverSystem.service.custom.TakeOrderService;
import lk.ijse.DiliverSystem.services.ServiceFactory;
import lk.ijse.DiliverSystem.services.ServiceFactory.ServiceTypes;
import lk.ijse.DiliverSystem.services.SuperService;

/**
 *
 * @author Viraj jayasanka
 */
public class ProxyHandler  implements ServiceFactory {
    
    private static ProxyHandler proxyHandler;
    
    private ServiceFactory serviceFactory;
    
    private AddDiliveryRiderService addDiliveryRiderService;
    private CallSenterService callSenterService;
    private CustomerServic customerServic;
    private CustomerDitalService customerDitalService;
    private LoginRiderService loginRiderService;
    private LastSaveOrderService lastSaveOrderService;
    private TakeOrderService takeOrderService1;
    private SubmitOrderService submitOrderService;
    private RiderGetOrderService getOrderService;
    private ItemPriceService itemPriceService;
    
            
    private ProxyHandler(){
        try {
            
            serviceFactory = (ServiceFactory) Naming.lookup("rmi://localhost:5050/Vj");
            addDiliveryRiderService = (AddDiliveryRiderService) serviceFactory.getService(ServiceTypes.ADDDILIVERYRIDER);
            callSenterService = (CallSenterService) serviceFactory.getService(ServiceTypes.CALLSENTER);
            loginRiderService = (LoginRiderService) serviceFactory.getService(ServiceTypes.LOGINGRIDER);
            lastSaveOrderService = (LastSaveOrderService) serviceFactory.getService(ServiceTypes.SAVEORDER);
            takeOrderService1 = (TakeOrderService) serviceFactory.getService(ServiceTypes.TAKEORDER);
            submitOrderService = (SubmitOrderService) serviceFactory.getService(ServiceTypes.SUBMITORDER);
            getOrderService = (RiderGetOrderService) serviceFactory.getService(ServiceTypes.RIDERGETORDER);
            itemPriceService = (ItemPriceService) serviceFactory.getService(ServiceTypes.ITEMPRICE);
            
        } catch (NotBoundException ex) {
            Logger.getLogger(ProxyHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ProxyHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ProxyHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ProxyHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ProxyHandler getInstance(){
        if (proxyHandler == null){
            proxyHandler = new ProxyHandler();
        }
        return proxyHandler;
    }

    @Override
    public SuperService getService(ServiceTypes type) throws Exception {
        switch(type){
            case ADDDILIVERYRIDER:
                return addDiliveryRiderService;
           case CALLSENTER:
                return callSenterService;
           case LOGINGRIDER:
                return loginRiderService;
           case SAVEORDER:
                return lastSaveOrderService;
           case TAKEORDER:
                return  takeOrderService1;
           case SUBMITORDER:
               return  submitOrderService;
           case RIDERGETORDER:
               return  getOrderService;
           case ITEMPRICE:
               return itemPriceService;
            default:
                return null;
        }

    }
}
