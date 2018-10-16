/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverSystem.service.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import lk.ijse.DiliverSystem.service.custom.impl.CallSenterServiceImpl;
import lk.ijse.DiliverSystem.service.custom.impl.CustomerDitailServiceImpl;
import lk.ijse.DiliverSystem.service.custom.impl.CustomerServiceImpl;
import lk.ijse.DiliverSystem.service.custom.impl.DeliveryRiderServiceImpl;
import lk.ijse.DiliverSystem.service.custom.impl.ItemPriceServiceImpl;
import lk.ijse.DiliverSystem.service.custom.impl.LastOrderSeveServiceImpl;
import lk.ijse.DiliverSystem.service.custom.impl.LoginRiderServiceImpl;
import lk.ijse.DiliverSystem.service.custom.impl.OrderDatilServiceImpl;
import lk.ijse.DiliverSystem.service.custom.impl.RiderGetOrderServiceImpl;
import lk.ijse.DiliverSystem.service.custom.impl.SubmitOrderServiceImpl;
import lk.ijse.DiliverSystem.service.custom.impl.TakeOrderServiceImpl;
import lk.ijse.DiliverSystem.services.ServiceFactory;
import lk.ijse.DiliverSystem.services.SuperService;

/**
 *
 * @author Viraj jayasanka
 */
public class ServiceFactoryImpl  extends UnicastRemoteObject implements ServiceFactory {
   
    public static ServiceFactory serviceFactory;
    
    private ServiceFactoryImpl() throws RemoteException{
        
    }
    public static ServiceFactory getInstance() throws RemoteException{
        if (serviceFactory == null){
            serviceFactory = new ServiceFactoryImpl();
        }
        return serviceFactory;
    }
    
    @Override
    public SuperService getService(ServiceTypes type) throws Exception {
     switch(type){
            case ADDDILIVERYRIDER:
                return new DeliveryRiderServiceImpl();
            case CALLSENTER:
                return new CallSenterServiceImpl();
             case TAKEORDER:
                return new TakeOrderServiceImpl();
              case CUSTOMER:
                return new CustomerServiceImpl();
              case CUSTOMERDITILS:
                return new CustomerDitailServiceImpl();
              case SUBMITORDER:
                return new SubmitOrderServiceImpl();
              case LOGINGRIDER:
                return new LoginRiderServiceImpl();
              case RIDERGETORDER:
                return new RiderGetOrderServiceImpl();
              case SAVEORDER:
                return new LastOrderSeveServiceImpl();
              case ITEMPRICE:
                return  new ItemPriceServiceImpl();
               case ORDERDITAILS:
                return  new OrderDatilServiceImpl();
            default:
                return null;
        }
    }    
}