/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverSystem.buisness.customs;

import java.util.List;
import lk.ijse.DiliverSystem.buisness.SuperBO;
import lk.ijse.DiliverSystem.dto.LoginRiderDTO;

/**
 *
 * @author Viraj jayasanka
 */
public interface LoginRiderBO extends SuperBO{
    
    public boolean addLoginRider(LoginRiderDTO loginRiderDTO) throws Exception;
    
    public boolean deleteLoginRider(int Id) throws Exception;
     
    public List<LoginRiderDTO> getAllLoginRiders() throws Exception;
    
    public LoginRiderDTO SerachId(int qid) throws Exception;
}
