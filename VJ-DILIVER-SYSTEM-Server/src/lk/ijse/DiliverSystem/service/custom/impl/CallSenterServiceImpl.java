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
import lk.ijse.DiliverSystem.buisness.customs.CallSenterBO;
import lk.ijse.DiliverSystem.dto.CallSenterDTO;
import lk.ijse.DiliverSystem.observer.Observer;
import lk.ijse.DiliverSystem.observer.Subject;
import lk.ijse.DiliverSystem.reservation.impl.ReservationImpl;
import lk.ijse.DiliverSystem.service.custom.CallSenterService;

/**
 *
 * @author Viraj jayasanka
 */
public class CallSenterServiceImpl extends UnicastRemoteObject implements CallSenterService, Subject {

    private CallSenterBO callSenterBO;
    
    private static ArrayList<Observer> alObservers = new ArrayList<>();
    private static ReservationImpl<CallSenterService> cusResBook = new ReservationImpl<>();
    
    
     public CallSenterServiceImpl() throws RemoteException {
        callSenterBO = (CallSenterBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.CALLSENTER);
    }
     
    @Override
    public boolean addDiliveryRider(CallSenterDTO callSenterDTO) throws Exception {
        boolean result = callSenterBO.addDiliveryRider(callSenterDTO);
        notifyObservers();
        return result;    
    }

    @Override
    public boolean deleteDiliveryRider(String callSenterID) throws Exception {
          boolean result = false;
        if (cusResBook.reserve(callSenterID, this, true)) {
            result = callSenterBO.deleteDiliveryRider(callSenterID);
            notifyObservers();
            if (cusResBook.isInternalReservation(callSenterID)){
                release(callSenterID);
                
            }
        }
        return result;
    }

    @Override
    public boolean updateDiliveryRider(CallSenterDTO callSenterDTO) throws Exception {
        boolean result = false;
        if (cusResBook.reserve(callSenterDTO.getCallSenterID(), this, true)) {
            result = callSenterBO.updateDiliveryRider(callSenterDTO);
            notifyObservers();
            if (cusResBook.isInternalReservation(callSenterDTO.getCallSenterID())){
                release(callSenterDTO.getCallSenterID());
            }            
        }
        return result;
    }

    @Override
    public List<CallSenterDTO> getAllDiliveryRider() throws Exception {
        return callSenterBO.getAllDiliveryRider(); 
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
    public boolean reserve(Object id) throws Exception {
          return cusResBook.reserve(id, this, false);  
    }

    @Override
    public boolean release(Object id) throws Exception {
          return cusResBook.release(id);
    }
    
}
