/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverSystem.service.custom;

import java.util.List;
import lk.ijse.DiliverSystem.dto.LasetOrderSaveDTO;
import lk.ijse.DiliverSystem.services.SuperService;

/**
 *
 * @author Viraj jayasanka
 */
public interface LastSaveOrderService  extends SuperService{
   
    public boolean addaLastSaveOrder(LasetOrderSaveDTO lasetOrderSaveDTO)throws Exception;
    
    public boolean deleteLastSaveOrder(int Id) throws Exception;
    
    public boolean updateLastSaveOrder(LasetOrderSaveDTO lasetOrderSaveDTO) throws Exception;
    
    public List<LasetOrderSaveDTO> getAllLastSaveOrder() throws Exception;
    
     public List<LasetOrderSaveDTO> getAllDateSaveData(String name) throws Exception;
}
