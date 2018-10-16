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
import lk.ijse.DiliverSystem.dto.ItemPriceDTO;
import lk.ijse.DiliverSystem.service.custom.AddDiliveryRiderService;
import lk.ijse.DiliverSystem.service.custom.CallSenterService;
import lk.ijse.DiliverSystem.service.custom.CustomerDitalService;
import lk.ijse.DiliverSystem.service.custom.CustomerServic;
import lk.ijse.DiliverSystem.service.custom.ItemPriceService;
import lk.ijse.DiliverSystem.service.custom.LoginRiderService;
import lk.ijse.DiliverSystem.service.custom.OrderDitailSperService;
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
    private TakeOrderService takeOrderService;
    private CustomerServic customerServic;
    private CustomerDitalService customerDitalService;
    private SubmitOrderService submitOrderService;
    private LoginRiderService loginRiderService;
    private OrderDitailSperService orderDitailSperService;
    private ItemPriceService itemPriceService;
    
    private ProxyHandler(){
        try {
            
            serviceFactory = (ServiceFactory) Naming.lookup("rmi://localhost:5050/Vj");
            addDiliveryRiderService = (AddDiliveryRiderService) serviceFactory.getService(ServiceTypes.ADDDILIVERYRIDER);
            callSenterService = (CallSenterService) serviceFactory.getService(ServiceTypes.CALLSENTER);
            takeOrderService = (TakeOrderService) serviceFactory.getService(ServiceTypes.TAKEORDER);
            customerServic = (CustomerServic) serviceFactory.getService(ServiceTypes.CUSTOMER);
            customerDitalService = (CustomerDitalService) serviceFactory.getService(ServiceTypes.CUSTOMERDITILS);
            submitOrderService = (SubmitOrderService) serviceFactory.getService(ServiceTypes.SUBMITORDER);
            loginRiderService = (LoginRiderService) serviceFactory.getService(ServiceTypes.LOGINGRIDER);
            orderDitailSperService = (OrderDitailSperService) serviceFactory.getService(ServiceTypes.ORDERDITAILS);
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
           case TAKEORDER:
                return takeOrderService;
           case CUSTOMER:
                return customerServic;
           case CUSTOMERDITILS:
                return customerDitalService;
           case SUBMITORDER:
                return submitOrderService;
           case LOGINGRIDER:
                return loginRiderService;
           case ORDERDITAILS:
                return orderDitailSperService;
           case ITEMPRICE:
                return itemPriceService;
            default:
                return null;
        }

    }
}
