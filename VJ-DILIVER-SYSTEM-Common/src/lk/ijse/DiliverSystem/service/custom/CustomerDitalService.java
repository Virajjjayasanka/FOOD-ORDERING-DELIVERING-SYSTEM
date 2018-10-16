/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverSystem.service.custom;

import java.util.List;
import lk.ijse.DiliverSystem.dto.AddCustomerDetailsDTO;
import lk.ijse.DiliverSystem.services.SuperService;

/**
 *
 * @author Viraj jayasanka
 */
public interface CustomerDitalService  extends SuperService{
     
    public boolean addaCustomerDitils(AddCustomerDetailsDTO addCustomerDetailsDTO)throws Exception;
    
    public boolean deleteCustomerDitils(int Id) throws Exception;
    
    public boolean searchCustomerDitils(String CustomerName)throws Exception;
    
    public boolean updateCustomerDitils(AddCustomerDetailsDTO addCustomerDetailsDTO) throws Exception;
    
    public List<AddCustomerDetailsDTO> getAllCustomerDitils() throws Exception;
    
    public List<AddCustomerDetailsDTO> SearchCustomerDitails(String name) throws Exception;
    
 //   public  List<AddCustomerDetailsDTO> SeachCustomerID(int CustomerID) throws Exception;
}
