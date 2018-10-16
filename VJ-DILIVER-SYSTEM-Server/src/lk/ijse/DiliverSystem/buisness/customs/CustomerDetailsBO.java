/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverSystem.buisness.customs;

import java.util.List;
import lk.ijse.DiliverSystem.buisness.SuperBO;
import lk.ijse.DiliverSystem.dto.AddCustomerDetailsDTO;
import lk.ijse.DiliverSystem.entity.AddCustomerDetails;

/**
 *
 * @author Viraj jayasanka
 */
public interface CustomerDetailsBO extends SuperBO{
    
    
    public boolean addCustomer(AddCustomerDetailsDTO addCustomerDetailsDTO) throws Exception;
    
    public boolean updateCustomer(AddCustomerDetailsDTO addCustomerDetailsDTO) throws Exception;
    
    public boolean deleteCustomer(int Id) throws Exception;

    public List<AddCustomerDetailsDTO> getAllCustomers() throws Exception;
    
    public List<AddCustomerDetailsDTO>SearchCustomerDetails(String name)throws Exception;
    
   // public List<AddCustomerDetailsDTO> SeachCustomerID(int CustomerID) throws Exception;
}
