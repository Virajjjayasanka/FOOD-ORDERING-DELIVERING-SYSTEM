/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverSystem.repository.custom;

import java.util.List;
import lk.ijse.DiliverSystem.entity.TakeOrder;
import lk.ijse.DiliverSystem.repository.SuperRepository;

/**
 *
 * @author Viraj jayasanka
 */
public interface TakeorderRepository  extends SuperRepository<TakeOrder, String> {
  
//    public TakeorderRepository(){
//    
//    }
//    
    public List<TakeOrder> Qure(String name) throws Exception;  
}
