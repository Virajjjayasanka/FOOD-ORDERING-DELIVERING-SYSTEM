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
import lk.ijse.DiliverSystem.buisness.customs.RiderGetOrderBO;
import lk.ijse.DiliverSystem.dto.RiderGetOrderDTO;
import lk.ijse.DiliverSystem.observer.Observer;
import lk.ijse.DiliverSystem.observer.Subject;
import lk.ijse.DiliverSystem.reservation.impl.ReservationImpl;
import lk.ijse.DiliverSystem.service.custom.RiderGetOrderService;

/**
 *
 * @author Viraj jayasanka
 */
public class RiderGetOrderServiceImpl extends UnicastRemoteObject implements RiderGetOrderService, Subject{

    private RiderGetOrderBO getOrderBO;
    private static ArrayList<Observer> alObservers = new ArrayList<>();
    private static ReservationImpl<RiderGetOrderService> cusResBook = new ReservationImpl<>();
    
    
     public RiderGetOrderServiceImpl() throws RemoteException{
       getOrderBO =  (RiderGetOrderBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.RIDERGETORDER);
    }
    
    @Override
    public boolean addaRiderGetOrder(RiderGetOrderDTO getOrderDTO) throws Exception {
         boolean result = getOrderBO.addRiderGetOrder(getOrderDTO);
         notifyObservers();
         return result;
    }

    @Override
    public boolean deleteRiderGetOrderr(int Id) throws Exception {
          boolean result = false;
        if (cusResBook.reserve(Id, this, true)) {
            result = getOrderBO.deleteRiderGetOrder(Id);
            notifyObservers();
            if (cusResBook.isInternalReservation(Id)){
                release(Id);
            }
        }
        return result;

    }

    @Override
    public boolean updateRiderGetOrder(RiderGetOrderDTO getOrderDTO) throws Exception {
         boolean result = false;
        if (cusResBook.reserve(getOrderDTO.getSubmitOrderID(), this, true)) {
            result = getOrderBO.updateRiderGetOrder(getOrderDTO);
            notifyObservers();
            if (cusResBook.isInternalReservation(getOrderDTO.getSubmitOrderID())){
                release(getOrderDTO.getSubmitOrderID());
            }            
        }
        return result;
    }

    @Override
    public List<RiderGetOrderDTO> getAllRiderGetOrders() throws Exception {
          return getOrderBO.getAllRiderGetOrders(); 
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
                    Logger.getLogger(RiderGetOrderServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }
    
}
