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
import lk.ijse.DiliverSystem.buisness.customs.LastOrderSaveBO;
import lk.ijse.DiliverSystem.dto.LasetOrderSaveDTO;
import lk.ijse.DiliverSystem.observer.Observer;
import lk.ijse.DiliverSystem.observer.Subject;
import lk.ijse.DiliverSystem.reservation.impl.ReservationImpl;
import lk.ijse.DiliverSystem.service.custom.LastSaveOrderService;


/**
 *
 * @author Viraj jayasanka
 */
public class LastOrderSeveServiceImpl extends UnicastRemoteObject implements LastSaveOrderService, Subject{

     private LastOrderSaveBO lastOrderSaveBO;
    private static ArrayList<Observer> alObservers = new ArrayList<>();
    private static ReservationImpl<LastSaveOrderService> cusResBook = new ReservationImpl<>();
    
    
     public LastOrderSeveServiceImpl() throws RemoteException {
        lastOrderSaveBO = (LastOrderSaveBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.SAVEORDER);
    }

    @Override
    public boolean addaLastSaveOrder(LasetOrderSaveDTO lasetOrderSaveDTO) throws Exception {
         boolean result = lastOrderSaveBO.addLastOrderSave(lasetOrderSaveDTO);
         notifyObservers();
         return result;
    }

    @Override
    public boolean  deleteLastSaveOrder(int Id) throws Exception {
         boolean result = false;
        if (cusResBook.reserve(Id, this, true)) {
            result = lastOrderSaveBO.deleteLastOrderSave(Id);
            notifyObservers();
            if (cusResBook.isInternalReservation(Id)){
                release(Id);
            }
        }
        return result;
    }

    @Override
    public boolean updateLastSaveOrder(LasetOrderSaveDTO lasetOrderSaveDTO) throws Exception {
         boolean result = false;
        if (cusResBook.reserve(lasetOrderSaveDTO.getOrderID(), this, true)) {
            result = lastOrderSaveBO.updateLastOrderSave(lasetOrderSaveDTO);
            notifyObservers();
            if (cusResBook.isInternalReservation(lasetOrderSaveDTO.getOrderID())){
                release(lasetOrderSaveDTO.getOrderID());
            }            
        }
        return result;
    }

    @Override
    public List<LasetOrderSaveDTO> getAllLastSaveOrder() throws Exception {
      //  System.out.print(LasetOrderSaveDTO);
                return lastOrderSaveBO.getAllLastOrderSaves(); 
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
                    Logger.getLogger(LastOrderSeveServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }

    @Override
    public List<LasetOrderSaveDTO> getAllDateSaveData(String name) throws Exception {
       
        return lastOrderSaveBO.getDataQure(name);

    }

    
}
