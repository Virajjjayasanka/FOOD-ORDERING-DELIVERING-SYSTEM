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
import lk.ijse.DiliverSystem.service.custom.CustomerDitalService;
import lk.ijse.DiliverSystem.service.custom.LastSaveOrderService;
import lk.ijse.DiliverSystem.service.custom.LoginRiderService;
import lk.ijse.DiliverSystem.service.custom.OrderDitailSperService;
import lk.ijse.DiliverSystem.service.custom.RiderGetOrderService;
import lk.ijse.DiliverSystem.service.custom.SubmitOrderService;
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
    private LoginRiderService loginRiderService;
    private SubmitOrderService submitOrderService;
    private CustomerDitalService customerDitalService;
    private RiderGetOrderService getOrderService;
    private LastSaveOrderService lastOrderSaveService;
    private OrderDitailSperService orderDitailSperService;
    
    private ProxyHandler(){
        try {
            
            serviceFactory = (ServiceFactory) Naming.lookup("rmi://localhost:5050/Vj");
            submitOrderService = (SubmitOrderService) serviceFactory.getService(ServiceTypes.SUBMITORDER);
            addDiliveryRiderService = (AddDiliveryRiderService) serviceFactory.getService(ServiceTypes.ADDDILIVERYRIDER);
            loginRiderService = (LoginRiderService) serviceFactory.getService(ServiceTypes.LOGINGRIDER);
            getOrderService = (RiderGetOrderService) serviceFactory.getService(ServiceTypes.RIDERGETORDER);
            lastOrderSaveService = (LastSaveOrderService) serviceFactory.getService(ServiceTypes.SAVEORDER);
            customerDitalService = (CustomerDitalService) serviceFactory.getService(ServiceTypes.CUSTOMERDITILS);
             orderDitailSperService = (OrderDitailSperService) serviceFactory.getService(ServiceTypes.ORDERDITAILS);
            
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
            case SUBMITORDER:
                return submitOrderService;
           case ADDDILIVERYRIDER:
                return addDiliveryRiderService;
          case LOGINGRIDER:
               return loginRiderService;
          case CUSTOMERDITILS:
             return customerDitalService;
          case RIDERGETORDER:
              return getOrderService;
          case SAVEORDER:
              return lastOrderSaveService;
            case ORDERDITAILS:
              return orderDitailSperService;
            default:
                return null;
        }
//
    }
}
