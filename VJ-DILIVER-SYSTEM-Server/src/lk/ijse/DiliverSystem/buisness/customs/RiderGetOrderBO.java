/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverSystem.buisness.customs;

import java.util.List;
import lk.ijse.DiliverSystem.buisness.SuperBO;
import lk.ijse.DiliverSystem.dto.RiderGetOrderDTO;

/**
 *
 * @author Viraj jayasanka
 */
public interface RiderGetOrderBO extends SuperBO{
   
    public boolean addRiderGetOrder(RiderGetOrderDTO getOrderDTO) throws Exception;
    
    public boolean updateRiderGetOrder(RiderGetOrderDTO getOrderDTO) throws Exception;
    
    public boolean deleteRiderGetOrder(int Id) throws Exception;
    
    public boolean searchRiderGetOrder(String SubmitorderID)throws Exception;
    
    public List<RiderGetOrderDTO> getAllRiderGetOrders() throws Exception;
}
