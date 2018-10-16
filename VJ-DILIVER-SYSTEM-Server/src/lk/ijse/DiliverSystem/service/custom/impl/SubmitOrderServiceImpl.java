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
import lk.ijse.DiliverSystem.buisness.customs.SubitOrderBO;
import lk.ijse.DiliverSystem.dto.SubmitOrderDTO;
import lk.ijse.DiliverSystem.observer.Observer;
import lk.ijse.DiliverSystem.observer.Subject;
import lk.ijse.DiliverSystem.reservation.impl.ReservationImpl;
import lk.ijse.DiliverSystem.service.custom.SubmitOrderService;

/**
 *
 * @author Viraj jayasanka
 */
public class SubmitOrderServiceImpl  extends UnicastRemoteObject implements SubmitOrderService , Subject  {

    private SubitOrderBO subitOrderBO;
    private static ArrayList<Observer> alObservers = new ArrayList<>();
    private static ReservationImpl<SubmitOrderService> cusResBook = new ReservationImpl<>();
    
    
     public SubmitOrderServiceImpl() throws RemoteException {
        subitOrderBO = (SubitOrderBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.SUBMITORDER);
    }
    
    
    @Override
    public boolean addaSubmitOrder(SubmitOrderDTO submitOrderDTO) throws Exception {
        boolean result = subitOrderBO.addSubitOrder(submitOrderDTO);
        notifyObservers();
        return result; 
    }

    @Override
    public boolean deleteSubmitOrder(int Id) throws Exception {
          boolean result = false;
        if (cusResBook.reserve(Id, this, true)) {
            result = subitOrderBO.deleteSubitOrder(Id);
            notifyObservers();
            if (cusResBook.isInternalReservation(Id)){
                release(Id);
            }
        }
        return result;
    }

    @Override
    public boolean updateSubmitOrder(SubmitOrderDTO submitOrderDTO) throws Exception {
         boolean result = false;
        if (cusResBook.reserve(submitOrderDTO.getOrderID(), this, true)) {
            result = subitOrderBO.updateSubitOrder(submitOrderDTO);
            notifyObservers();
            if (cusResBook.isInternalReservation(submitOrderDTO.getOrderID())){
                release(submitOrderDTO.getOrderID());
            }            
        }
        return result;
        
    }

    @Override
    public List<SubmitOrderDTO> getAllSubmitOrders() throws Exception {
        return subitOrderBO.getAllSubitOrders(); 
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
                    Logger.getLogger(SubmitOrderServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }
    
}
