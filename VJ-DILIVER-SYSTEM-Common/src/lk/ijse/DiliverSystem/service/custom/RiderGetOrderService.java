/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverSystem.service.custom;

import java.util.List;
import lk.ijse.DiliverSystem.dto.RiderGetOrderDTO;
import lk.ijse.DiliverSystem.services.SuperService;

/**
 *
 * @author Viraj jayasanka
 */
public interface RiderGetOrderService extends SuperService{
    
    public boolean addaRiderGetOrder(RiderGetOrderDTO getOrderDTO)throws Exception;
    
    public boolean deleteRiderGetOrderr(int Id) throws Exception;
    
    public boolean updateRiderGetOrder(RiderGetOrderDTO getOrderDTO) throws Exception;
    
    public List<RiderGetOrderDTO> getAllRiderGetOrders() throws Exception;
    
  //  public List<RiderGetOrderDTO> Qure(String name) throws Exception;
}
