/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverSystem.service.custom;

import java.util.List;
import lk.ijse.DiliverSystem.dto.OrderDitailsDTO;
import lk.ijse.DiliverSystem.services.SuperService;

/**
 *
 * @author Viraj jayasanka
 */
public interface OrderDitailSperService extends SuperService{
    
    public boolean addaOrderDitail(OrderDitailsDTO ditailsDTO)throws Exception;
    
    public boolean deleteOrderDitail(int Id) throws Exception;
    
    public boolean updateOrderDitail(OrderDitailsDTO orderDitailsDTO) throws Exception;
    
    public List<OrderDitailsDTO> getAllOrderDitails() throws Exception;
    
    public List<OrderDitailsDTO> getOrderDitailsId(String name) throws Exception;
}
