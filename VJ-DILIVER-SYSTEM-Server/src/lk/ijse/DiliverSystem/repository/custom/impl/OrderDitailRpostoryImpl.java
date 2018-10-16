/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverSystem.repository.custom.impl;

import java.util.List;
import lk.ijse.DiliverSystem.entity.OrderDitails;
import lk.ijse.DiliverSystem.repository.SuperRepositoryImpl;
import lk.ijse.DiliverSystem.repository.custom.OrderDitaillsRepostory;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Viraj jayasanka
 */
public class OrderDitailRpostoryImpl extends SuperRepositoryImpl<OrderDitails, String> implements OrderDitaillsRepostory{

    private OrderDitaillsRepostory orderDitaillsRepostory;
    private Session session;
   
    public OrderDitailRpostoryImpl() {
    }

    @Override
    public List<OrderDitails> getOrderDitailsID(String name) throws Exception {
        
        
           List<OrderDitails> orders=(List<OrderDitails>) orderDitaillsRepostory.getOrderDitailsID(name);

           Query qure = session.getNamedQuery("OrderDitilasSave");
           List<OrderDitails> user = orderDitaillsRepostory.getOrderDitailsID(name);
           for(OrderDitails users : user) 
           return user;
           return null;
                
    }
    
}
