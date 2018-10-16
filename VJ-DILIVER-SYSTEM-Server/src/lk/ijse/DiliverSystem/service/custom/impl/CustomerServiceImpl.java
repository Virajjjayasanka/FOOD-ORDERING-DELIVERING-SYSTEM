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
import lk.ijse.DiliverSystem.buisness.customs.CustomerBO;
import lk.ijse.DiliverSystem.dto.CustomerDTO;
import lk.ijse.DiliverSystem.observer.Observer;
import lk.ijse.DiliverSystem.observer.Subject;
import lk.ijse.DiliverSystem.reservation.impl.ReservationImpl;
import lk.ijse.DiliverSystem.service.custom.CustomerServic;

/**
 *
 * @author Viraj jayasanka
 */
public class CustomerServiceImpl extends UnicastRemoteObject implements CustomerServic, Subject {

    private CustomerBO customerBO;
    
    private static ArrayList<Observer> alObservers = new ArrayList<>();
    private static ReservationImpl<CustomerServic> cusResBook = new ReservationImpl<>();
    
     public CustomerServiceImpl() throws RemoteException {
       customerBO = (CustomerBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.CUSTOMER);
    }
    
    @Override
    public boolean addaCustomer(CustomerDTO customerDTO) throws Exception {
        boolean result = customerBO.addCustomer(customerDTO);
        notifyObservers();
        return result;
    }

    @Override
    public boolean deleteCustomer(int Id) throws Exception {
        boolean result = false;
        if (cusResBook.reserve(Id, this, true)) {
            result = customerBO.deleteCustomer(Id);
            notifyObservers();
            if (cusResBook.isInternalReservation(Id)){
                release(Id);
                System.out.print("ssssssssssssssssssssssssS"+Id);
            }
        }

        return result;
    }

    @Override
    public boolean searchCustomer(String CustomerName) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateCustomer(CustomerDTO customerDTO) throws Exception {
        boolean result = false;
        if (cusResBook.reserve(customerDTO.getOrderID(), this, true)) {
          //  result = customerBO.updateCustomer(customerDTO);
            notifyObservers();
            if (cusResBook.isInternalReservation(customerDTO.getOrderID())){
                release(customerDTO.getOrderID());
            }            
        }
        return result;
    }

    @Override
    public List<CustomerDTO> getAllCustomer() throws Exception {
        return customerBO.getAllCustomers();
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

    
    
    @Override
    public List<CustomerDTO> getCustomerName(String name) throws Exception {
         System.out.print("Searvice "+name); 
        return customerBO.getCustomerName(name);
         
        
    }
 
   
    
}
