/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverSystem.service.custom;

import java.util.List;
import lk.ijse.DiliverSystem.dto.TakeOrderDTO;
import lk.ijse.DiliverSystem.services.SuperService;

/**
 *
 * @author Viraj jayasanka
 */
public interface TakeOrderService extends SuperService{
    
    public boolean addaTakeOrder(TakeOrderDTO takeOrderDTO)throws Exception;
    
    public boolean deleteTakeOrder(int Id) throws Exception;
    
    public boolean updateTakeOrder(TakeOrderDTO takeOrderDTO) throws Exception;
    
    public List<TakeOrderDTO> getAllTakeOrder() throws Exception;
    
    public List<TakeOrderDTO> Qure(String name) throws Exception;
}
