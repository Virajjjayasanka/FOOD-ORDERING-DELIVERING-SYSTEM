/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverSystem.buisness.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.DiliverSystem.buisness.customs.RiderGetOrderBO;
import lk.ijse.DiliverSystem.dto.RiderGetOrderDTO;
import lk.ijse.DiliverSystem.entity.RiderGetOrder;
import lk.ijse.DiliverSystem.repository.RepositoryFactory;
import lk.ijse.DiliverSystem.repository.custom.RiderGetOrderRepository;
import lk.ijse.DiliverSystem.resource.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Viraj jayasanka
 */
public class RiderGetorderBOImpl implements RiderGetOrderBO{
  
    private RiderGetOrderRepository getOrderRepository;
    
    public RiderGetorderBOImpl() {
        this.getOrderRepository = (RiderGetOrderRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.RIDERGETORDER);
    }

    @Override
    public boolean addRiderGetOrder(RiderGetOrderDTO getOrderDTO) throws Exception {
          
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            getOrderRepository.setSession(session);
            
            session.beginTransaction();
            
                RiderGetOrder T = new RiderGetOrder(
                    getOrderDTO.getSubmitOrderID(),
                    getOrderDTO.getOrderid(),
                    getOrderDTO.getTeleponeOperterName(),
                    getOrderDTO.getCustomerID(),
                    getOrderDTO.getTotal(),
                    getOrderDTO.getRiderName(),
                    getOrderDTO.getTime()
                    
                );
                
            boolean result = getOrderRepository.save(T);
            
            session.getTransaction().commit();

            return result;
        } 


    }

    @Override
    public boolean updateRiderGetOrder(RiderGetOrderDTO getOrderDTO) throws Exception {
       
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            getOrderRepository.setSession(session);
            
            session.beginTransaction();
           
                   RiderGetOrder T = new RiderGetOrder(
                    getOrderDTO.getSubmitOrderID(),
                    getOrderDTO.getOrderid(),
                    getOrderDTO.getTeleponeOperterName(),
                    getOrderDTO.getCustomerID(),
                    getOrderDTO.getTotal(),
                    getOrderDTO.getRiderName(),
                    getOrderDTO.getTime()
                    
                );
                   
            getOrderRepository.update(T);
            
            session.getTransaction().commit();
            
            return true;
        }catch(Exception exp){
            exp.printStackTrace();
            return false;
        }
        
    }

    @Override
    public boolean deleteRiderGetOrder(int Id) throws Exception {
        
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            getOrderRepository.setSession(session);
            
            session.beginTransaction();

            RiderGetOrder getOrder = getOrderRepository.findById(Id);
            boolean result = false;

            if (getOrder != null) {

                getOrderRepository.delete(getOrder);
            }
            
            session.getTransaction().commit();
             
            return result;
        }catch(Exception exp){
            exp.printStackTrace();
            return false;
        } 
    }

    @Override
    public boolean searchRiderGetOrder(String SubmitorderID) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<RiderGetOrderDTO> getAllRiderGetOrders() throws Exception {
         
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            getOrderRepository.setSession(session);
            
            session.beginTransaction();

            List<RiderGetOrder> getOrders1 = getOrderRepository.findAll();
            
            if (getOrders1 != null) {

                List<RiderGetOrderDTO> alOrderDTOs = new ArrayList<>();

                for (RiderGetOrder getOrder : getOrders1) {
                  
                    RiderGetOrderDTO dto = new RiderGetOrderDTO(
                            
                            getOrder.getSubmitOrderID(),
                            getOrder.getOrderid(),
                            getOrder.getTeleponeOperterName(),
                            getOrder.getCustomerID(),
                            getOrder.getTotal(),
                            getOrder.getRiderName(),
                            getOrder.getTime()
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
