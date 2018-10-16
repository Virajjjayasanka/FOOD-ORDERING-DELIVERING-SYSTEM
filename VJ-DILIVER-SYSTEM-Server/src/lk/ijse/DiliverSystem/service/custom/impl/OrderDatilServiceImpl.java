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
import lk.ijse.DiliverSystem.buisness.customs.OrderDitailBO;
import lk.ijse.DiliverSystem.dto.OrderDitailsDTO;
import lk.ijse.DiliverSystem.observer.Observer;
import lk.ijse.DiliverSystem.observer.Subject;
import lk.ijse.DiliverSystem.reservation.impl.ReservationImpl;
import lk.ijse.DiliverSystem.service.custom.OrderDitailSperService;

/**
 *
 * @author Viraj jayasanka
 */
public class OrderDatilServiceImpl extends UnicastRemoteObject implements OrderDitailSperService, Subject {

     private OrderDitailBO ditailBO;
    private static ArrayList<Observer> alObservers = new ArrayList<>();
    private static ReservationImpl<OrderDitailSperService> cusResBook = new ReservationImpl<>();
    
    
     public OrderDatilServiceImpl() throws RemoteException {
        ditailBO = (OrderDitailBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ORDERDITAILS);
    }
    
    
    @Override
    public boolean addaOrderDitail(OrderDitailsDTO ditailsDTO) throws Exception {
         boolean result = ditailBO.addOrderDitail(ditailsDTO);
         notifyObservers();
         return result; 
    }

    @Override
    public boolean deleteOrderDitail(int Id) throws Exception {
        
         boolean result = false;
        if (cusResBook.reserve(Id, this, true)) {
            result = ditailBO.deleteOrderDitail(Id);
            notifyObservers();
            if (cusResBook.isInternalReservation(Id)){
                release(Id);
            }
        }
        return result;
    }

    @Override
    public boolean updateOrderDitail(OrderDitailsDTO orderDitailsDTO) throws Exception {

         boolean result = false;
        if (cusResBook.reserve(orderDitailsDTO.getOrderDetailID(), this, true)) {
            result = ditailBO.updateOrderDitail(orderDitailsDTO);
            notifyObservers();
            if (cusResBook.isInternalReservation(orderDitailsDTO.getOrderDetailID())){
                release(orderDitailsDTO.getOrderDetailID());
            }            
        }
        return result;
    }

    @Override
    public List<OrderDitailsDTO> getAllOrderDitails() throws Exception {
         return ditailBO.getAllOrderDitails();
    }

    @Override
    public List<OrderDitailsDTO> getOrderDitailsId(String name) throws Exception {
        return ditailBO.getOrderDitails(name);
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
                    Logger.getLogger(OrderDatilServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }
    
    
    
    
}
