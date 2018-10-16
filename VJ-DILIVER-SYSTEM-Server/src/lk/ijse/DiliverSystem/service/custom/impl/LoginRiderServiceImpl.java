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
import lk.ijse.DiliverSystem.buisness.customs.LoginRiderBO;
import lk.ijse.DiliverSystem.dto.LoginRiderDTO;
import lk.ijse.DiliverSystem.observer.Observer;
import lk.ijse.DiliverSystem.observer.Subject;
import lk.ijse.DiliverSystem.reservation.impl.ReservationImpl;
import lk.ijse.DiliverSystem.service.custom.LoginRiderService;

/**
 *
 * @author Viraj jayasanka
 */
public class LoginRiderServiceImpl extends UnicastRemoteObject implements LoginRiderService, Subject {

    
    private LoginRiderBO loginRiderBO;
    private static ArrayList<Observer> alObservers = new ArrayList<>();
    private static ReservationImpl<LoginRiderService> cusResBook = new ReservationImpl<>();
    
    
     public LoginRiderServiceImpl() throws RemoteException {
        loginRiderBO = (LoginRiderBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.LOGINGRIDER);
    }
 
    @Override
    public boolean addaLoginRider(LoginRiderDTO loginRiderDTO) throws Exception {
        boolean result = loginRiderBO.addLoginRider(loginRiderDTO);
        notifyObservers();
        return result; 
    }

    @Override
    public boolean deleteLoginRider(int Id) throws Exception {
         boolean result = false;
        if (cusResBook.reserve(Id, this, true)) {
            result = loginRiderBO.deleteLoginRider(Id);
            notifyObservers();
            if (cusResBook.isInternalReservation(Id)){
                release(Id);
            }
        }
        return result;
    }

    @Override
    public boolean updateTakeOrder(LoginRiderDTO loginRiderDTO) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<LoginRiderDTO> getAllLoginRiders() throws Exception {
         return loginRiderBO.getAllLoginRiders();
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
                    Logger.getLogger(LoginRiderServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
        

    }

    @Override
    public LoginRiderDTO SeachCustomerID(int id) throws Exception {
        return loginRiderBO.SerachId(id);

    }
    
}
