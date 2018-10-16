/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverSystem.buisness.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.DiliverSystem.buisness.customs.OrderDitailBO;
import lk.ijse.DiliverSystem.dto.OrderDitailsDTO;
import lk.ijse.DiliverSystem.entity.OrderDitails;
import lk.ijse.DiliverSystem.repository.RepositoryFactory;
import lk.ijse.DiliverSystem.repository.custom.OrderDitaillsRepostory;
import lk.ijse.DiliverSystem.resource.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Viraj jayasanka
 */
public class OrderDitailsBoImpl implements OrderDitailBO{

    private OrderDitaillsRepostory orderDitaillsRepostory;
    
    public OrderDitailsBoImpl() {
        this.orderDitaillsRepostory = (OrderDitaillsRepostory) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.ORDERDITAILS);
    }

    @Override
    public boolean addOrderDitail(OrderDitailsDTO orderDitailsDTO) throws Exception {
        
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            orderDitaillsRepostory.setSession(session);
            
            session.beginTransaction();
            
                OrderDitails T = new OrderDitails(
                    orderDitailsDTO.getOrderID(),
                    orderDitailsDTO.getCustomerID(),
                    orderDitailsDTO.getTeleponeOperterName(),
                    orderDitailsDTO.getDeleiveryChes(),
                    orderDitailsDTO.getTotal(),
                    orderDitailsDTO.getDate(),
                    orderDitailsDTO.getTime()

                );
                
            boolean result = orderDitaillsRepostory.save(T);
            
            session.getTransaction().commit();

            return result;
        } 
    }

    @Override
    public boolean updateOrderDitail(OrderDitailsDTO orderDitailsDTO) throws Exception {
       
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            orderDitaillsRepostory.setSession(session);
            
            session.beginTransaction();
           
                    OrderDitails T = new OrderDitails(
                    orderDitailsDTO.getOrderDetailID(),
                    orderDitailsDTO.getOrderID(),
                    orderDitailsDTO.getCustomerID(),
                    orderDitailsDTO.getTeleponeOperterName(),
                    orderDitailsDTO.getDeleiveryChes(),
                    orderDitailsDTO.getTotal(),
                    orderDitailsDTO.getDate(),
                    orderDitailsDTO.getTime()

                );
                  
            orderDitaillsRepostory.update(T);
            
            session.getTransaction().commit();
            
            return true;
        }catch(Exception exp){
            exp.printStackTrace();
            return false;
        }
     
    }

    @Override
    public boolean deleteOrderDitail(int Id) throws Exception {
        
         try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            orderDitaillsRepostory.setSession(session);
            
            session.beginTransaction();

            OrderDitails orderDitails = orderDitaillsRepostory.findById(Id);
            boolean result = false;

            if (orderDitails != null) {

                orderDitaillsRepostory.delete(orderDitails);
            }
            
            session.getTransaction().commit();
             
            return result;
        }catch(Exception exp){
            exp.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean searchOrderDitail(String CustomerID) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OrderDitailsDTO> getAllOrderDitails() throws Exception {
        
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            orderDitaillsRepostory.setSession(session);
            
            session.beginTransaction();

            List<OrderDitails> orderDitailses = orderDitaillsRepostory.findAll();
            
           
            
            if (orderDitailses != null) {

                List<OrderDitailsDTO> alOrderDTOs = new ArrayList<>();

                for (OrderDitails ditails : orderDitailses) {
                    OrderDitailsDTO dto = new OrderDitailsDTO(
                        ditails.getOrderDetailID(),
                        ditails.getOrderID(),
                        ditails.getCustomerID(),
                        ditails.getTeleponeOperterName(),
                        ditails.getDeleiveryChes(),
                        ditails.getTotal(),
                        ditails.getDate(),
                        ditails.getTime()

              
                 );
                    alOrderDTOs.add(dto);
                }
           //  Character.getName(2);
             
                return alOrderDTOs;

            } else {

                return null;
            }

        }  
    }

    @Override
    public List<OrderDitailsDTO> getOrderDitails(String name) throws Exception {

         try (Session session = HibernateUtil.getSessionFactory().openSession()) {

           session.beginTransaction();
           Query qure = session.getNamedQuery("OrderDitilasSave");
           qure.setParameter(0, name);
         
           List<OrderDitails> user = qure.list();
//           for(TakeOrder users : user)
//               System.out.print(user);
//               }
             if (user != null) {
//
                List<OrderDitailsDTO> alOrderDTOs = new ArrayList<>();

                for (OrderDitails ditails : user) {
                     OrderDitailsDTO dto = new OrderDitailsDTO(
                        ditails.getOrderDetailID(),
                        ditails.getOrderID(),
                        ditails.getCustomerID(),
                        ditails.getTeleponeOperterName(),
                        ditails.getDeleiveryChes(),
                        ditails.getTotal(),
                        ditails.getDate(),
                        ditails.getTime()
              
                 );
                    
                alOrderDTOs.add(dto);
                }
           
                return  alOrderDTOs;

            } else {
            
               return getOrderDitails(name);
            }

        }     
    }

}
