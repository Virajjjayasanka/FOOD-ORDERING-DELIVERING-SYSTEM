/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverSystem.buisness.customs;

import java.util.List;
import lk.ijse.DiliverSystem.buisness.SuperBO;
import lk.ijse.DiliverSystem.dto.SubmitOrderDTO;

/**
 *
 * @author Viraj jayasanka
 */
public interface SubitOrderBO extends SuperBO{
    
    public boolean addSubitOrder(SubmitOrderDTO submitOrderDTO) throws Exception;
    
    public boolean updateSubitOrder(SubmitOrderDTO submitOrderDTO) throws Exception;
    
    public boolean deleteSubitOrder(int Id) throws Exception;
    
    public boolean searchSubitOrder(String SublmitOrderID)throws Exception;
    
    public List<SubmitOrderDTO> getAllSubitOrders() throws Exception;
    
}
