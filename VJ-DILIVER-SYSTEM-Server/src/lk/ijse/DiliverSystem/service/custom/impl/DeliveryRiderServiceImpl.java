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
import lk.ijse.DiliverSystem.buisness.customs.AddDiliveryRidersBO;
import lk.ijse.DiliverSystem.dto.DiliveryRiderDTO;
import lk.ijse.DiliverSystem.observer.Observer;
import lk.ijse.DiliverSystem.observer.Subject;
import lk.ijse.DiliverSystem.reservation.impl.ReservationImpl;
import lk.ijse.DiliverSystem.service.custom.AddDiliveryRiderService;


/**
 *
 * @author Viraj jayasanka
 */
public class DeliveryRiderServiceImpl extends UnicastRemoteObject implements AddDiliveryRiderService, Subject {
        
    private AddDiliveryRidersBO addDiliveryRidersBO;
    private static ArrayList<Observer> alObservers = new ArrayList<>();
    private static ReservationImpl<AddDiliveryRiderService> cusResBook = new ReservationImpl<>();
    
    public DeliveryRiderServiceImpl() throws RemoteException {
        addDiliveryRidersBO = (AddDiliveryRidersBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ADDDILIVERYRIDER);
    }

    
    @Override
    public boolean addDiliveryRider(DiliveryRiderDTO diliveryRiderDTO) throws Exception {
        boolean result = addDiliveryRidersBO.addDiliveryRider(diliveryRiderDTO);
        notifyObservers();
        return result;  
    }

    @Override
    public boolean deleteDiliveryRider(String Id) throws Exception {
           boolean result = false;
        if (cusResBook.reserve(Id, this, true)) {
            result = addDiliveryRidersBO.deleteDiliveryRider(Id);
            notifyObservers();
            if (cusResBook.isInternalReservation(Id)){
                release(Id);
            }
        }
        return result;
    }

    @Override
    public boolean updateDiliveryRider(DiliveryRiderDTO diliveryRiderDTO) throws Exception {
        boolean result = false;
        if (cusResBook.reserve(diliveryRiderDTO.getId(), this, true)) {
            result = addDiliveryRidersBO.updateDiliveryRider(diliveryRiderDTO);
            notifyObservers();
            if (cusResBook.isInternalReservation(diliveryRiderDTO.getId())){
                release(diliveryRiderDTO.getId());
            }            
        }
        return result;
    }

    @Override
    public List<DiliveryRiderDTO> getAllDiliveryRider() throws Exception {
              return addDiliveryRidersBO.getAllDiliveryRider();  
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
    public DiliveryRiderDTO SeachCustomerID(int id) throws Exception {
        return addDiliveryRidersBO.SerachId(id);
    }
}
