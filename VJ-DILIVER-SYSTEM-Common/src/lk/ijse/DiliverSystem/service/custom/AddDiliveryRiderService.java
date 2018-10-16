/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverSystem.service.custom;

import java.util.List;
import lk.ijse.DiliverSystem.dto.DiliveryRiderDTO;
import lk.ijse.DiliverSystem.services.SuperService;

/**
 *
 * @author Viraj jayasanka
 */
public interface AddDiliveryRiderService extends SuperService{
    
    public boolean addDiliveryRider(DiliveryRiderDTO diliveryRiderDTO)throws Exception;
    
    public boolean deleteDiliveryRider(String Id) throws Exception;
    
    public boolean updateDiliveryRider(DiliveryRiderDTO diliveryRiderDTO) throws Exception;
    
     public DiliveryRiderDTO SeachCustomerID(int id)throws Exception;
    
    public List<DiliveryRiderDTO> getAllDiliveryRider() throws Exception;
        
}
