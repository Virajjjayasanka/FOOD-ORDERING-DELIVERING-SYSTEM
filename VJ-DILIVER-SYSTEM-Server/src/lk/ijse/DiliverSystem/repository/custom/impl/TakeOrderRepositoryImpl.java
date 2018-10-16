/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverSystem.repository.custom.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import lk.ijse.DiliverSystem.entity.TakeOrder;
import lk.ijse.DiliverSystem.repository.SuperRepositoryImpl;
import lk.ijse.DiliverSystem.repository.custom.TakeorderRepository;
import lk.ijse.DiliverSystem.resource.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Viraj jayasanka
 */
public class TakeOrderRepositoryImpl extends SuperRepositoryImpl<TakeOrder, String> implements TakeorderRepository{
// private Session session;
    private TakeorderRepository takeorderRepository;
    private Session session;
    public TakeOrderRepositoryImpl() {
    }


    @Override
    public List<TakeOrder> Qure(String name) throws Exception {
        
            List<TakeOrder> orders=(List<TakeOrder>) takeorderRepository.Qure(name);

           Query qure = session.getNamedQuery("TeleponeOperterName");
           List<TakeOrder> user = takeorderRepository.Qure(name);
           for(TakeOrder users : user) 
//               session.createSQLQuery("");
            return user;
           
        return null;
                
  
    }
               
    

}
