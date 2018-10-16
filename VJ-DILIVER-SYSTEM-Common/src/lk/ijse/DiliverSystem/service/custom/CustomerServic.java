/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverSystem.service.custom;

import java.util.List;
import lk.ijse.DiliverSystem.dto.CustomerDTO;
import lk.ijse.DiliverSystem.services.SuperService;

/**
 *
 * @author Viraj jayasanka
 */
public interface CustomerServic extends SuperService {
    
    public boolean addaCustomer(CustomerDTO customerDTO)throws Exception;
    
    public boolean deleteCustomer(int Id) throws Exception;
    
    public boolean searchCustomer(String CustomerName)throws Exception;
    
    public boolean updateCustomer(CustomerDTO customerDTO) throws Exception;
    
    public List<CustomerDTO> getAllCustomer() throws Exception;
    
    public List<CustomerDTO> getCustomerName(String name) throws Exception;
    
}
