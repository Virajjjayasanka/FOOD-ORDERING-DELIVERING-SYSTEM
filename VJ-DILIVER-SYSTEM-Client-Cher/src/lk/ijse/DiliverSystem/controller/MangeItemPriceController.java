/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverSystem.controller;

import java.util.List;
import lk.ijse.DiliverSystem.dto.ItemPriceDTO;
import lk.ijse.DiliverSystem.observer.Subject;
import lk.ijse.DiliverSystem.proxy.ProxyHandler;
import lk.ijse.DiliverSystem.service.custom.ItemPriceService;
import lk.ijse.DiliverSystem.services.ServiceFactory;

/**
 *
 * @author Viraj jayasanka
 */
public class MangeItemPriceController {
    
    
    public static boolean addItemPrice(ItemPriceDTO itemPriceDTO) throws Exception{
        ItemPriceService itemPriceService = (ItemPriceService)ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ITEMPRICE);
        return itemPriceService.addaItemPrice(itemPriceDTO);
    }
    
    public static boolean updateItemPrice(ItemPriceDTO itemPriceDTO) throws Exception{
         ItemPriceService itemPriceService = (ItemPriceService)ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ITEMPRICE);
        return itemPriceService.updateItemPrice(itemPriceDTO);
    }

    public static boolean deleteItemPrice(int Id) throws Exception{
        ItemPriceService itemPriceService = (ItemPriceService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ITEMPRICE);
        return itemPriceService.deleteItemPrice(Id);
    }    
    
    public static List<ItemPriceDTO> getAllItemPrice() throws Exception{
         ItemPriceService itemPriceService = (ItemPriceService)ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ITEMPRICE);
        return itemPriceService.getAllItemPrices();
    }

    
   public static Subject getSubject() throws Exception{
        return (Subject) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ITEMPRICE);
    }
    
    
    public static boolean reserveItemPrice(String Id) throws Exception{
       ItemPriceService itemPriceService = (ItemPriceService)ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ITEMPRICE);
        return itemPriceService.reserve(Id);
    }
    
    public static boolean releaseItemPrice(String Id) throws Exception{
          ItemPriceService itemPriceService = (ItemPriceService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ITEMPRICE);
        return itemPriceService.release(Id);
    }    

}
