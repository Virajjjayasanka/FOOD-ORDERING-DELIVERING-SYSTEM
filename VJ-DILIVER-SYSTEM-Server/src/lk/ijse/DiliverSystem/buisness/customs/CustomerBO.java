/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverSystem.buisness.customs;

import java.util.List;
import lk.ijse.DiliverSystem.buisness.SuperBO;
import lk.ijse.DiliverSystem.dto.CustomerDTO;

/**
 *
 * @author Viraj jayasanka
 */
public interface CustomerBO extends SuperBO{
    
     public boolean addCustomer(CustomerDTO customerDTO) throws Exception;
    
    public boolean updateCustomer(CustomerDTO customerDTO) throws Exception;
    
    public boolean deleteCustomer(int Id) throws Exception;
    
    public boolean searchCustomer(String CustomerName)throws Exception;
    
    public List<CustomerDTO> getAllCustomers() throws Exception;
    
     public List<CustomerDTO>getCustomerName(String name) throws Exception;
    
}
