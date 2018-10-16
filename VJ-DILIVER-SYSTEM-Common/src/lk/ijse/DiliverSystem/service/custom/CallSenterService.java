/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverSystem.service.custom;

import java.util.List;
import lk.ijse.DiliverSystem.dto.CallSenterDTO;
import lk.ijse.DiliverSystem.services.SuperService;

/**
 *
 * @author Viraj jayasanka
 */
public interface CallSenterService extends SuperService{
    
    public boolean addDiliveryRider(CallSenterDTO callSenterDTO)throws Exception;
    
    public boolean deleteDiliveryRider(String callSenterID) throws Exception;
    
    public boolean updateDiliveryRider(CallSenterDTO callSenterDTO) throws Exception;
    
    public List<CallSenterDTO> getAllDiliveryRider() throws Exception;
    
}
