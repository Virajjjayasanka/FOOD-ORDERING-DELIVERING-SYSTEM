/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverSystem.buisness.customs;

import java.util.List;
import lk.ijse.DiliverSystem.buisness.SuperBO;
import lk.ijse.DiliverSystem.dto.ItemPriceDTO;

/**
 *
 * @author Viraj jayasanka
 */
public interface ItemBO extends SuperBO{
    
     public boolean addItem(ItemPriceDTO itemPriceDTO) throws Exception;
    
    public boolean updateItem(ItemPriceDTO itemPriceDTO) throws Exception;
    
    public boolean deleteItem(int Id) throws Exception;
    
    public boolean searchItem(String ItemID)throws Exception;
    
    public List<ItemPriceDTO> getAllItems() throws Exception;
    
}
