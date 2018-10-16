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
import lk.ijse.DiliverSystem.buisness.customs.TakeOrderBO;
import lk.ijse.DiliverSystem.dto.TakeOrderDTO;
import lk.ijse.DiliverSystem.observer.Observer;
import lk.ijse.DiliverSystem.observer.Subject;
import lk.ijse.DiliverSystem.reservation.impl.ReservationImpl;
import lk.ijse.DiliverSystem.service.custom.TakeOrderService;

/**
 *
 * @author Viraj jayasanka
 */
public class TakeOrderServiceImpl extends UnicastRemoteObject implements TakeOrderService, Subject{
    
    private TakeOrderBO takeOrderBO;
    private static ArrayList<Observer> alObservers = new ArrayList<>();
    private static ReservationImpl<TakeOrderService> cusResBook = new ReservationImpl<>();
    
    
     public TakeOrderServiceImpl() throws RemoteException {
        takeOrderBO = (TakeOrderBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.TAKEORDER);
    }
    
    @Override
    public boolean addaTakeOrder(TakeOrderDTO takeOrderDTO) throws Exception {
         boolean result = takeOrderBO.addTakeOrder(takeOrderDTO);
         notifyObservers();
         return result; 
    }

    @Override
    public boolean deleteTakeOrder(int Id) throws Exception {
          boolean result = false;
        if (cusResBook.reserve(Id, this, true)) {
            result = takeOrderBO.deleteTakeOrder(Id);
            notifyObservers();
            if (cusResBook.isInternalReservation(Id)){
                release(Id);
            }
        }
        return result;
    }

    @Override
    public boolean updateTakeOrder(TakeOrderDTO takeOrderDTO) throws Exception {
       // return false;
        boolean result = false;
        if (cusResBook.reserve(takeOrderDTO.getOrderID(), this, true)) {
            result = takeOrderBO.updateTakeOrder(takeOrderDTO);
            notifyObservers();
            if (cusResBook.isInternalReservation(takeOrderDTO.getOrderID())){
                release(takeOrderDTO.getOrderID());
            }            
        }
        return result;
    }

    @Override
    public List<TakeOrderDTO> getAllTakeOrder() throws Exception {
          return takeOrderBO.getAllTakeOrder(); 
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
                    Logger.getLogger(DeliveryRiderServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }



    @Override
    public List<TakeOrderDTO> Qure(String name) throws Exception {
                // System.out.print("sivice :"+name);

      // String name="viraj";
        return takeOrderBO.Qure(name);
    }

}
