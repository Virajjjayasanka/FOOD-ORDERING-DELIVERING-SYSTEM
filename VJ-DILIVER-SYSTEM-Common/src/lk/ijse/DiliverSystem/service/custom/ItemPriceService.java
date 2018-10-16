/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverSystem.service.custom;

import java.util.List;
import lk.ijse.DiliverSystem.dto.ItemPriceDTO;
import lk.ijse.DiliverSystem.services.SuperService;

/**
 *
 * @author Viraj jayasanka
 */
public interface ItemPriceService extends SuperService{
    
    public boolean addaItemPrice(ItemPriceDTO itemPriceDTO)throws Exception;
    
    public boolean deleteItemPrice(int Id) throws Exception;
    
    public boolean updateItemPrice(ItemPriceDTO itemPriceDTO) throws Exception;
    
    public List<ItemPriceDTO> getAllItemPrices() throws Exception;
    
    public List<ItemPriceDTO> Qure(String name) throws Exception;
}
