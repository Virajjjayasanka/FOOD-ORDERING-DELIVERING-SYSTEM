/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverSystem.buisness.custom.impl;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Action;
import lk.ijse.DiliverSystem.buisness.customs.TakeOrderBO;
import lk.ijse.DiliverSystem.dto.TakeOrderDTO;
import lk.ijse.DiliverSystem.entity.TakeOrder;
import lk.ijse.DiliverSystem.repository.RepositoryFactory;
import lk.ijse.DiliverSystem.repository.custom.TakeorderRepository;
import lk.ijse.DiliverSystem.resource.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.NamedNativeQuery;
import org.hibernate.query.Query;

/**
 *
 * @author Viraj jayasanka
 */
public class TakeOrderBOImpl implements TakeOrderBO{

    private TakeorderRepository takeorderRepository;
    
    public TakeOrderBOImpl() {
       this.takeorderRepository = (TakeorderRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.TAKEORDER);
    }
    
    @Override
    public boolean addTakeOrder(TakeOrderDTO takeOrderDTO) throws Exception {
     
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            takeorderRepository.setSession(session);
            
            session.beginTransaction();
            
                TakeOrder T = new TakeOrder(takeOrderDTO.getOrderID(),
                    takeOrderDTO.getTelepOneOperterName(),
                    takeOrderDTO.getDilveryCharges(),
                    takeOrderDTO.getSubTotal(),
                    takeOrderDTO.getTotal(),
                    takeOrderDTO.getItemTextAriya(),
                    takeOrderDTO.getPayment(),
                    takeOrderDTO.getDate(),
                    takeOrderDTO.getTime()
                
                );
                
            boolean result = takeorderRepository.save(T);
            
            session.getTransaction().commit();

            return result;
        } 
    }

    @Override
    public boolean updateTakeOrder(TakeOrderDTO takeOrderDTO) throws Exception {
      
         try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            takeorderRepository.setSession(session);
            
            session.beginTransaction();
           
                 TakeOrder T = new TakeOrder(takeOrderDTO.getOrderID(),
                    takeOrderDTO.getTelepOneOperterName(),
                    takeOrderDTO.getDilveryCharges(),
                    takeOrderDTO.getSubTotal(),
                    takeOrderDTO.getTotal(),
                    takeOrderDTO.getItemTextAriya(),
                    takeOrderDTO.getPayment(),
                    takeOrderDTO.getDate(),
                    takeOrderDTO.getTime()
                
                );

            takeorderRepository.update(T);
            
            session.getTransaction().commit();
            
            return true;
        }catch(Exception exp){
            exp.printStackTrace();
            return false;
        }
        
    }

    @Override
    public boolean deleteTakeOrder(int Id) throws Exception {
        
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            takeorderRepository.setSession(session);
            
            session.beginTransaction();

            TakeOrder takeOrder = takeorderRepository.findById(Id);
            boolean result = false;

            if (takeOrder != null) {

                takeorderRepository.delete(takeOrder);
            }
            
            session.getTransaction().commit();
             
            return result;
        }catch(Exception exp){
            exp.printStackTrace();
            return false;
        }
    
    }

    @Override
    public boolean searchTakeOrder(String Id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TakeOrderDTO> getAllTakeOrder() throws Exception {
       
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            takeorderRepository.setSession(session);
            
            session.beginTransaction();

            List<TakeOrder> takeOrders = takeorderRepository.findAll();
            
           
            
            if (takeOrders != null) {

                List<TakeOrderDTO> alOrderDTOs = new ArrayList<>();

                for (TakeOrder takeOrder : takeOrders) {
                    TakeOrderDTO dto = new TakeOrderDTO(
                            takeOrder.getOrderID(),
                            takeOrder.getTelepOneOperterName(),
                            takeOrder.getDilveryCharges(),
                            takeOrder.getSubTotal(),
                            takeOrder.getTotal(),
                            takeOrder.getItemTextAriya(),
                            takeOrder.getPayment(),
                            takeOrder.getDate(),
                            takeOrder.getTime()
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
    public List<TakeOrderDTO> Qure(String name) throws Exception {

    try (Session session = HibernateUtil.getSessionFactory().openSession()) {

           session.beginTransaction();
           Query qure = session.getNamedQuery("TeleponeOperterName");
           qure.setParameter(0, name);
         
           List<TakeOrder> user = qure.list();
//           for(TakeOrder users : user)
//               System.out.print(user);
//               }
             if (user != null) {
//
                List<TakeOrderDTO> alOrderDTOs = new ArrayList<>();

                for (TakeOrder takeOrder : user) {
                    TakeOrderDTO dto = new TakeOrderDTO(
                            takeOrder.getOrderID(),
                            takeOrder.getTelepOneOperterName(),
                            takeOrder.getDilveryCharges(),
                            takeOrder.getSubTotal(),
                            takeOrder.getTotal(),
                            takeOrder.getItemTextAriya(),
                            takeOrder.getPayment(),
                            takeOrder.getDate(),
                            takeOrder.getTime()
                      );
                    alOrderDTOs.add(dto);
                }
           //  Character.getName(2);
            // System.out.print("BOIMPL do : "+alOrderDTOs);
                return  alOrderDTOs;

            } else {
             //   System.out.print("BOIMPL do : "+name);
                return Qure(name);
            }
 

            }
        
    }

    }
