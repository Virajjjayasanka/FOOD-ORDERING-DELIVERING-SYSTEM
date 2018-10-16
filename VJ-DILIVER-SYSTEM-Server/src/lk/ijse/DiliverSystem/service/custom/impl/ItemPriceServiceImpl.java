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
import lk.ijse.DiliverSystem.buisness.customs.ItemBO;
import lk.ijse.DiliverSystem.dto.ItemPriceDTO;
import lk.ijse.DiliverSystem.observer.Observer;
import lk.ijse.DiliverSystem.observer.Subject;
import lk.ijse.DiliverSystem.reservation.impl.ReservationImpl;
import lk.ijse.DiliverSystem.service.custom.ItemPriceService;

/**
 *
 * @author Viraj jayasanka
 */
public class ItemPriceServiceImpl extends UnicastRemoteObject implements ItemPriceService, Subject{
    
    private ItemBO itemBO;
    private static ArrayList<Observer> alObservers = new ArrayList<>();
    private static ReservationImpl<ItemPriceService> cusResBook = new ReservationImpl<>();
 
     public ItemPriceServiceImpl() throws RemoteException {
        itemBO = (ItemBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ITEMPRICE);
    }

    @Override
    public boolean addaItemPrice(ItemPriceDTO itemPriceDTO) throws Exception {

         boolean result = itemBO.addItem(itemPriceDTO);
         notifyObservers();
         return result;
    }

    @Override
    public boolean deleteItemPrice(int Id) throws Exception {
        
         boolean result = false;
        if (cusResBook.reserve(Id, this, true)) {
            result = itemBO.deleteItem(Id);
            notifyObservers();
            if (cusResBook.isInternalReservation(Id)){
                release(Id);
            }
        }
        return result;
    }

    @Override
    public boolean updateItemPrice(ItemPriceDTO itemPriceDTO) throws Exception {

        boolean result = false;
        if (cusResBook.reserve(itemPriceDTO.getID(), this, true)) {
            result = itemBO.updateItem(itemPriceDTO);
            notifyObservers();
            if (cusResBook.isInternalReservation(itemPriceDTO.getID())){
                release(itemPriceDTO.getID());
            }            
        }
        return result;
    }

    @Override
    public List<ItemPriceDTO> getAllItemPrices() throws Exception {
         return itemBO.getAllItems(); 
    }

    @Override
    public List<ItemPriceDTO> Qure(String name) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
                    Logger.getLogger(ItemPriceServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
        
    }
    
}
