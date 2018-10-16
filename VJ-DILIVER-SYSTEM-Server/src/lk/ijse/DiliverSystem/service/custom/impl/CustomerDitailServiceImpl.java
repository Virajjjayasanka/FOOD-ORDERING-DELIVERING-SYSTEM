/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverSystem.service.custom.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.ijse.DiliverSystem.buisness.BOFactory;
import lk.ijse.DiliverSystem.buisness.customs.CustomerDetailsBO;
import lk.ijse.DiliverSystem.dto.AddCustomerDetailsDTO;
import lk.ijse.DiliverSystem.observer.Observer;
import lk.ijse.DiliverSystem.observer.Subject;
import lk.ijse.DiliverSystem.reservation.impl.ReservationImpl;
import lk.ijse.DiliverSystem.service.custom.CustomerDitalService;

/**
 *
 * @author Viraj jayasanka
 */
public class CustomerDitailServiceImpl extends UnicastRemoteObject implements CustomerDitalService, Subject {

    private CustomerDetailsBO customerDetailsBO;
    
    private static ArrayList<Observer> alObservers = new ArrayList<>();
    private static ReservationImpl<CustomerDitalService> cusResBook = new ReservationImpl<>();
    
     public CustomerDitailServiceImpl() throws RemoteException {
       customerDetailsBO = (CustomerDetailsBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.CUSTOMERDITILS);
    }
    
    @Override
    public boolean addaCustomerDitils(AddCustomerDetailsDTO addCustomerDetailsDTO) throws Exception {
         boolean result = customerDetailsBO.addCustomer(addCustomerDetailsDTO);
         notifyObservers();
         return result; 
    }

    @Override
    public boolean deleteCustomerDitils(int Id) throws Exception {
        boolean result = false;
        if (cusResBook.reserve(Id, this, true)) {
            result = customerDetailsBO.deleteCustomer(Id);
            notifyObservers();
            if (cusResBook.isInternalReservation(Id)){
                release(Id);
            }
        }

        return result;

    }

    @Override
    public boolean searchCustomerDitils(String CustomerName) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateCustomerDitils(AddCustomerDetailsDTO addCustomerDetailsDTO) throws Exception {
             boolean result = false;
        if (cusResBook.reserve(addCustomerDetailsDTO.getSaveOrderID(), this, true)) {
            notifyObservers();
            if (cusResBook.isInternalReservation(addCustomerDetailsDTO.getSaveOrderID())){
                release(addCustomerDetailsDTO.getSaveOrderID());
            }            
        }
        return result;
    }

    @Override
    public List<AddCustomerDetailsDTO> getAllCustomerDitils() throws Exception {
          return customerDetailsBO.getAllCustomers();
    }

    @Override
    public List<AddCustomerDetailsDTO> SearchCustomerDitails(String name) throws Exception {
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaa"+name);
          return customerDetailsBO.SearchCustomerDetails(name);
    }

    @Override
    public boolean reserve(Object id) throws Exception {
        return cusResBook.reserve(id, this, false);
    }

    @Override
    public boolean release(Object id) throws Exception {
        return cusResBook.release(id);
    }

    @Override
    public void registerObserver(Observer observer) throws Exception {
         alObservers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) throws Exception {
        alObservers.remove(observer);
    }

    @Override
    public void notifyObservers() throws Exception {
         new Thread(() -> {
            for (Observer observer : alObservers) {
                try {
                    observer.updateObservers();
                } catch (Exception ex) {
                    Logger.getLogger(CustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }
//
//    @Override
//    public List<AddCustomerDetailsDTO> SeachCustomerID(int CustomerID) throws Exception {
//               return customerDetailsBO.SeachCustomerID(CustomerID);
//        //return null;
//
//    }
    
}
