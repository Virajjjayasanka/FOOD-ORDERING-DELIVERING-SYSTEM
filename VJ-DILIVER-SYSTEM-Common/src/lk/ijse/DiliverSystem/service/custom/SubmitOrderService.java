/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverSystem.service.custom;

import java.util.List;
import lk.ijse.DiliverSystem.dto.SubmitOrderDTO;
import lk.ijse.DiliverSystem.services.SuperService;

/**
 *
 * @author Viraj jayasanka
 */
public interface SubmitOrderService  extends SuperService{
  
    public boolean addaSubmitOrder(SubmitOrderDTO submitOrderDTO)throws Exception;
    
    public boolean deleteSubmitOrder(int Id) throws Exception;
    
    public boolean updateSubmitOrder(SubmitOrderDTO submitOrderDTO) throws Exception;
    
    public List<SubmitOrderDTO> getAllSubmitOrders() throws Exception;
    
   
}
