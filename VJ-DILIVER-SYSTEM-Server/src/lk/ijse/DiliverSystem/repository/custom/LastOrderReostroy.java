/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverSystem.repository.custom;

import java.util.List;
import lk.ijse.DiliverSystem.entity.LastOrderSave;
import lk.ijse.DiliverSystem.repository.SuperRepository;

/**
 *
 * @author Viraj jayasanka
 */
public interface LastOrderReostroy extends SuperRepository<LastOrderSave, String> {
    
     public List<LastOrderSave> getAllDateQure(String name) throws Exception;  
}
