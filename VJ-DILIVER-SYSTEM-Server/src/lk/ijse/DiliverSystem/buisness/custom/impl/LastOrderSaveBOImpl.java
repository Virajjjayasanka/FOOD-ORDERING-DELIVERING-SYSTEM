/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverSystem.buisness.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.DiliverSystem.buisness.customs.LastOrderSaveBO;
import lk.ijse.DiliverSystem.dto.LasetOrderSaveDTO;
import lk.ijse.DiliverSystem.entity.LastOrderSave;

import lk.ijse.DiliverSystem.repository.RepositoryFactory;
import lk.ijse.DiliverSystem.repository.custom.LastOrderReostroy;

import lk.ijse.DiliverSystem.resource.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Viraj jayasanka
 */
public class LastOrderSaveBOImpl implements LastOrderSaveBO{
    
    private LastOrderReostroy lastOrderRepository;
    
    public LastOrderSaveBOImpl() {
         this.lastOrderRepository = (LastOrderReostroy) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.SAVEORDER);
    }

    @Override
    public boolean addLastOrderSave(LasetOrderSaveDTO lasetOrderSaveDTO) throws Exception {

        
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            lastOrderRepository.setSession(session);
            
            session.beginTransaction();
            
                LastOrderSave T = new LastOrderSave(
                   // lasetOrderSaveDTO.getSaveOrderId(),
                    lasetOrderSaveDTO.getSumbitOrderID(),
                    lasetOrderSaveDTO.getOrderID(),
                    lasetOrderSaveDTO.getCustomerID(),
                    lasetOrderSaveDTO.getTeleponrOPerterName(),
                    lasetOrderSaveDTO.getRiderName(),
                    lasetOrderSaveDTO.getGetOrderTime(),
                    lasetOrderSaveDTO.getOutOrderTime(),
                    lasetOrderSaveDTO.getPayament(),
                    lasetOrderSaveDTO.getTotal(),
                    lasetOrderSaveDTO.getDate()
                );
                
            boolean result = lastOrderRepository.save(T);
            
            session.getTransaction().commit();

            return result;
        } 

    }

    @Override
    public boolean updateLastOrderSave(LasetOrderSaveDTO lasetOrderSaveDTO) throws Exception {
        
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            lastOrderRepository.setSession(session);
            
            session.beginTransaction();
           
            LastOrderSave T = new LastOrderSave(
                    lasetOrderSaveDTO.getSaveOrderId(),
                    lasetOrderSaveDTO.getSumbitOrderID(),
                    lasetOrderSaveDTO.getOrderID(),
                    lasetOrderSaveDTO.getCustomerID(),
                    lasetOrderSaveDTO.getTeleponrOPerterName(),
                    lasetOrderSaveDTO.getRiderName(),
                    lasetOrderSaveDTO.getGetOrderTime(),
                    lasetOrderSaveDTO.getOutOrderTime(),
                    lasetOrderSaveDTO.getPayament(),
                    lasetOrderSaveDTO.getTotal(),
                    lasetOrderSaveDTO.getDate()
                );
                
            lastOrderRepository.update(T);
            
            session.getTransaction().commit();
            
            return true;
        }catch(Exception exp){
            exp.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteLastOrderSave(int Id) throws Exception {
        
         
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            lastOrderRepository.setSession(session);
            
            session.beginTransaction();

             LastOrderSave lastOrderSave = lastOrderRepository.findById(Id);
            boolean result = false;

            if (lastOrderSave != null) {

                lastOrderRepository.delete(lastOrderSave);
            }
            
            session.getTransaction().commit();
             
            return result;
        }catch(Exception exp){
            exp.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean searchLastOrderSave(String SaveOrderID) throws Exception {
        return false;
    }

    @Override
    public List<LasetOrderSaveDTO> getAllLastOrderSaves() throws Exception {

          try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            lastOrderRepository.setSession(session);
            
            session.beginTransaction();

            List<LastOrderSave> lastOrderSaves = lastOrderRepository.findAll();
            
            if (lastOrderSaves != null) {

                List<LasetOrderSaveDTO> alOrderDTOs = new ArrayList<>();

                for (LastOrderSave orderSave : lastOrderSaves) {
                   
                    LasetOrderSaveDTO dto = new LasetOrderSaveDTO(
                            
                    orderSave.getSaveOrderId(),
                    orderSave.getSumbitOrderID(),
                    orderSave.getOrderID(),
                    orderSave.getCustomerID(),
                    orderSave.getTeleponrOPerterName(),
                    orderSave.getRiderName(),
                    orderSave.getGetOrderTime(),
                    orderSave.getOutOrderTime(),
                    orderSave.getPayament(),
                    orderSave.getTotal(),
                    orderSave.getDate()
                
                    );
                       System.out.print(dto);
                    alOrderDTOs.add(dto);
                }
               
                return alOrderDTOs;

            } else {

                return null;
            }

        }  

    }

    @Override
    public List<LasetOrderSaveDTO> getDataQure(String name) throws Exception {

         try (Session session = HibernateUtil.getSessionFactory().openSession()) {

           session.beginTransaction();
          
           Query qure = session.getNamedQuery("lastOrderSave");
           
           qure.setParameter(0, name);
         
           List<LastOrderSave> user = qure.list();
//           for(TakeOrder users : user)
//               System.out.print(user);
//               }
             if (user != null) {
//
                List<LasetOrderSaveDTO> alOrderDTOs = new ArrayList<>();

                for (LastOrderSave lastOrderSave : user) {
                    
                    LasetOrderSaveDTO dto = new LasetOrderSaveDTO(
                                   
                    lastOrderSave.getSaveOrderId(),
                    lastOrderSave.getSumbitOrderID(),
                    lastOrderSave.getOrderID(),
                    lastOrderSave.getCustomerID(),
                    lastOrderSave.getTeleponrOPerterName(),
                    lastOrderSave.getRiderName(),
                    lastOrderSave.getGetOrderTime(),
                    lastOrderSave.getOutOrderTime(),
                    lastOrderSave.getPayament(),
                    lastOrderSave.getTotal(),
                    lastOrderSave.getDate()
                      );
                    alOrderDTOs.add(dto);
                     System.out.print("Booooooooooooooooop"+dto);
                }
           //  Character.getName(2);
            // System.out.print("BOIMPL do : "+alOrderDTOs);
                return  alOrderDTOs;

            } else {
             //   System.out.print("BOIMPL do : "+name);
                return getDataQure(name);
            }
 

            }
        
    }
    
}
