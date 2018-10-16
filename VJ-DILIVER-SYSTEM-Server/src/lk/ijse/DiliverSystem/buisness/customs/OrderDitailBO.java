/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverSystem.buisness.customs;

import java.util.List;
import lk.ijse.DiliverSystem.buisness.SuperBO;
import lk.ijse.DiliverSystem.dto.OrderDitailsDTO;
import lk.ijse.DiliverSystem.entity.OrderDitails;
import lk.ijse.DiliverSystem.repository.custom.OrderDitaillsRepostory;

/**
 *
 * @author Viraj jayasanka
 */
public interface OrderDitailBO extends SuperBO{
    
    public boolean addOrderDitail(OrderDitailsDTO orderDitailsDTO) throws Exception;
    
    public boolean updateOrderDitail(OrderDitailsDTO orderDitailsDTO) throws Exception;
    
    public boolean deleteOrderDitail(int Id) throws Exception;
    
    public boolean searchOrderDitail(String CustomerID)throws Exception;
    
    public List<OrderDitailsDTO> getAllOrderDitails() throws Exception;
    
    public List<OrderDitailsDTO> getOrderDitails(String name) throws Exception;
}
