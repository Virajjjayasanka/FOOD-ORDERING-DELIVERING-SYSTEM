/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverSystem.service.custom;

import java.util.List;
import lk.ijse.DiliverSystem.dto.LoginRiderDTO;
import lk.ijse.DiliverSystem.services.SuperService;

/**
 *
 * @author Viraj jayasanka
 */
public interface LoginRiderService extends SuperService{
    
     
    public boolean addaLoginRider(LoginRiderDTO loginRiderDTO)throws Exception;
    
    public boolean deleteLoginRider(int Id) throws Exception;
    
    public boolean updateTakeOrder(LoginRiderDTO loginRiderDTO) throws Exception;

   public LoginRiderDTO SeachCustomerID(int id)throws Exception;
    
    public List<LoginRiderDTO> getAllLoginRiders() throws Exception;
    
  
    
}
