/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverSystem.buisness.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.DiliverSystem.buisness.customs.SubitOrderBO;
import lk.ijse.DiliverSystem.dto.SubmitOrderDTO;
import lk.ijse.DiliverSystem.entity.SubmitOrder;
import lk.ijse.DiliverSystem.repository.RepositoryFactory;
import lk.ijse.DiliverSystem.repository.custom.SubmitOrderRepository;
import lk.ijse.DiliverSystem.resource.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Viraj jayasanka
 */
public class SubmiOrdertBOImpl implements SubitOrderBO{
    
    private SubmitOrderRepository submitOrderRepository;
    
    public SubmiOrdertBOImpl() {
       this.submitOrderRepository = (SubmitOrderRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.SUBMITORDER);
    }

    @Override
    public boolean addSubitOrder(SubmitOrderDTO submitOrderDTO) throws Exception {
      
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            submitOrderRepository.setSession(session);
            
            session.beginTransaction();
            
                SubmitOrder T = new SubmitOrder(
                    submitOrderDTO.getOrderID(),
                    submitOrderDTO.getTeleponeOperterName(),
                    submitOrderDTO.getCustomerId(),
                    submitOrderDTO.getTotal(),
                    submitOrderDTO.getPayment(),
                    submitOrderDTO.getTime(),
                    submitOrderDTO.getDate()

                );
                
            boolean result = submitOrderRepository.save(T);
            
            session.getTransaction().commit();

            return result;
        } 
 
    }

    @Override
    public boolean updateSubitOrder(SubmitOrderDTO submitOrderDTO) throws Exception {
         
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            submitOrderRepository.setSession(session);
            
            session.beginTransaction();
            
            SubmitOrder T = new SubmitOrder(
                    submitOrderDTO.getSubmitOrderID(),
                    submitOrderDTO.getOrderID(),
                    submitOrderDTO.getTeleponeOperterName(),
                    submitOrderDTO.getCustomerId(),
                    submitOrderDTO.getTotal(),
                    submitOrderDTO.getPayment(),
                    submitOrderDTO.getTime(),
                    submitOrderDTO.getDate()

                );

            submitOrderRepository.update(T);
            
            session.getTransaction().commit();
            
            return true;
        }catch(Exception exp){
            exp.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean deleteSubitOrder(int Id) throws Exception {
        
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            submitOrderRepository.setSession(session);
            
            session.beginTransaction();

            SubmitOrder submitOrder = submitOrderRepository.findById(Id);
            boolean result = false;

            if (submitOrder != null) {

                submitOrderRepository.delete(submitOrder);
            }
            
            session.getTransaction().commit();
             
            return result;
        }catch(Exception exp){
            exp.printStackTrace();
            return false;
        }
    

    }

    @Override
    public boolean searchSubitOrder(String SublmitOrderID) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SubmitOrderDTO> getAllSubitOrders() throws Exception {
       
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            submitOrderRepository.setSession(session);
            
            session.beginTransaction();

            List<SubmitOrder> submitOrders = submitOrderRepository.findAll();

            if (submitOrders != null) {

                List<SubmitOrderDTO> alOrderDTOs = new ArrayList<>();

                for (SubmitOrder submitOrder : submitOrders) {
                    SubmitOrderDTO dto = new SubmitOrderDTO(
                            submitOrder.getSubmitOrderID(),
                            submitOrder.getOrderID(),
                            submitOrder.getTeleponeOperterName(),
                            submitOrder.getCustomerId(),
                            submitOrder.getTotal(),
                            submitOrder.getPayment(),
                            submitOrder.getTime(),
                            submitOrder.getDate()
                         
                      );
                    alOrderDTOs.add(dto);
                }

                return alOrderDTOs;

            } else {

                return null;
            }
        }  
        
    }
    

}
