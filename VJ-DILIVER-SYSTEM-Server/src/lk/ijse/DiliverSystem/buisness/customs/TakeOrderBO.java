/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverSystem.buisness.customs;

import java.util.List;
import lk.ijse.DiliverSystem.buisness.SuperBO;
import lk.ijse.DiliverSystem.dto.TakeOrderDTO;
import lk.ijse.DiliverSystem.entity.TakeOrder;

/**
 *
 * @author Viraj jayasanka
 */
public interface TakeOrderBO extends SuperBO {
    
    public boolean addTakeOrder(TakeOrderDTO takeOrderDTO) throws Exception;
    
    public boolean updateTakeOrder(TakeOrderDTO takeOrderDTO) throws Exception;
    
    public boolean deleteTakeOrder(int Id) throws Exception;
    
    public boolean searchTakeOrder(String CustomerID)throws Exception;
    
    public List<TakeOrderDTO> getAllTakeOrder() throws Exception;
    
    public List<TakeOrderDTO> Qure(String name) throws Exception;
    
   
}
