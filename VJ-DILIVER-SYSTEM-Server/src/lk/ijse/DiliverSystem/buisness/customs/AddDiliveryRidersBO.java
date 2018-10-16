/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverSystem.buisness.customs;

import java.util.List;
import lk.ijse.DiliverSystem.buisness.SuperBO;
import lk.ijse.DiliverSystem.dto.DiliveryRiderDTO;

/**
 *
 * @author Viraj jayasanka
 */
public interface AddDiliveryRidersBO extends SuperBO{
    
    public boolean addDiliveryRider(DiliveryRiderDTO diliveryRiderDTO) throws Exception;
    
    public boolean updateDiliveryRider(DiliveryRiderDTO diliveryRiderDTO) throws Exception;
    
    public boolean deleteDiliveryRider(String Id) throws Exception;
    
    public DiliveryRiderDTO SerachId(int qid) throws Exception;
    
    public List<DiliveryRiderDTO> getAllDiliveryRider() throws Exception;
}
