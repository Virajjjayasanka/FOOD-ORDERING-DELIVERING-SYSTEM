/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverSystem.repository.custom.impl;

import java.util.List;
import lk.ijse.DiliverSystem.entity.LastOrderSave;
import lk.ijse.DiliverSystem.repository.SuperRepositoryImpl;
import lk.ijse.DiliverSystem.repository.custom.LastOrderReostroy;
import org.hibernate.Session;
import org.hibernate.query.Query;


/**
 *
 * @author Viraj jayasanka
 */
public class LastSaveRepostoryImpl extends SuperRepositoryImpl<LastOrderSave, String> implements LastOrderReostroy{
    
    private LastOrderReostroy lastOrderReostroy;
    private Session session;
   
    public LastSaveRepostoryImpl() {
    }

    
    
    @Override
    public List<LastOrderSave> getAllDateQure(String name) throws Exception {
        
        List<LastOrderSave> orders=(List<LastOrderSave>) lastOrderReostroy.getAllDateQure(name);

           
        Query qure = session.getNamedQuery("lastOrderSave");
           List<LastOrderSave> user = lastOrderReostroy.getAllDateQure(name);
           for(LastOrderSave users : user) 
//               session.createSQLQuery("");
            return user;
           
        return null;


    }
    
}
