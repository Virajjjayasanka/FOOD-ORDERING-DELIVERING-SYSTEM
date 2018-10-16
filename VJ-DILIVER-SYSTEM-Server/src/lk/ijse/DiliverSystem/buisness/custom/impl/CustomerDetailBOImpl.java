/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverSystem.buisness.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.DiliverSystem.buisness.customs.CustomerDetailsBO;
import lk.ijse.DiliverSystem.dto.AddCustomerDetailsDTO;
import lk.ijse.DiliverSystem.entity.AddCustomerDetails;
import lk.ijse.DiliverSystem.repository.RepositoryFactory;
import lk.ijse.DiliverSystem.repository.custom.CustomerDetailsRepository;
import lk.ijse.DiliverSystem.resource.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Viraj jayasanka
 */
public class CustomerDetailBOImpl implements CustomerDetailsBO{

    private CustomerDetailsRepository customerDetailsRepository;

    public CustomerDetailBOImpl() {
        this.customerDetailsRepository = (CustomerDetailsRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.CUSTOMERDITILS);
    }
    
    
    @Override
    public boolean addCustomer(AddCustomerDetailsDTO addCustomerDetailsDTO) throws Exception {
        
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            customerDetailsRepository.setSession(session);
            
            session.beginTransaction();
            
                AddCustomerDetails T = new AddCustomerDetails(
                    addCustomerDetailsDTO.getCustomeID(),
                    addCustomerDetailsDTO.getOrderID(),
                    addCustomerDetailsDTO.getCustomerName(),
                    addCustomerDetailsDTO.getCustomerAddress(),
                    addCustomerDetailsDTO.getCustomertelponeNO(),
                    addCustomerDetailsDTO.getCustomerOtherNO(),
                    addCustomerDetailsDTO.getTime(),
                    addCustomerDetailsDTO.getDate()
                
                );
                
            boolean result = customerDetailsRepository.save(T);
            
            session.getTransaction().commit();

            return result;
        } 


    }

    @Override
    public boolean updateCustomer(AddCustomerDetailsDTO addCustomerDetailsDTO) throws Exception {
        
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            customerDetailsRepository.setSession(session);
            
            session.beginTransaction();
            
            AddCustomerDetails T = new AddCustomerDetails(
                    addCustomerDetailsDTO.getCustomeID(),
                    addCustomerDetailsDTO.getOrderID(),
                    addCustomerDetailsDTO.getCustomerName(),
                    addCustomerDetailsDTO.getCustomerAddress(),
                    addCustomerDetailsDTO.getCustomertelponeNO(),
                    addCustomerDetailsDTO.getCustomerOtherNO(),
                    addCustomerDetailsDTO.getTime(),
                    addCustomerDetailsDTO.getDate()
                
                );
            customerDetailsRepository.update(T);
        
            
            return true;
        }catch(Exception exp){
            exp.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean deleteCustomer(int Id) throws Exception {
        
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            customerDetailsRepository.setSession(session);
            
            session.beginTransaction();

            AddCustomerDetails details = customerDetailsRepository.findById(Id);
            boolean result = false;

            if (details != null) {

                customerDetailsRepository.delete(details);
            }
            
            session.getTransaction().commit();

            return result;
        }catch(Exception exp){
            exp.printStackTrace();
            return false;
        }


    }

   
    @Override
    public List<AddCustomerDetailsDTO> getAllCustomers() throws Exception {

     try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            customerDetailsRepository.setSession(session);
            
            session.beginTransaction();

            List<AddCustomerDetails> addCustomerDetailses = customerDetailsRepository.findAll();
            
            session.getTransaction().commit();

            if (addCustomerDetailses != null) {

                List<AddCustomerDetailsDTO> alOrderDTOs = new ArrayList<>();

                for (AddCustomerDetails takeOrder : addCustomerDetailses) {
                    
                    AddCustomerDetailsDTO dto = new AddCustomerDetailsDTO(
                            takeOrder.getSaveOrderID(),
                            takeOrder.getOrderID(),
                            takeOrder.getCustomeID(),
                            takeOrder.getCustomerName(),
                            takeOrder.getCustomerAddress(),
                            takeOrder.getCustomertelponeNO(),
                            takeOrder.getCustomerOtherNO(),
                            takeOrder.getTime(),
                            takeOrder.getDate()
                      );
                    alOrderDTOs.add(dto);
                }

                return alOrderDTOs;

            } else {

                return null;
            }

        }  
    }

    @Override
    public List<AddCustomerDetailsDTO> SearchCustomerDetails(String name) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

           session.beginTransaction();
           Query qure = session.getNamedQuery("CustomeReDelatAdd");
           qure.setParameter(0, name);
         
           List<AddCustomerDetails> user = qure.list();
//           for(TakeOrder users : user)
//               System.out.print(user);
//               }
             if (user != null) {
//
                List<AddCustomerDetailsDTO> alOrderDTOs = new ArrayList<>();

                for (AddCustomerDetails ditails : user) {
                     AddCustomerDetailsDTO dto = new AddCustomerDetailsDTO(
                       ditails.getSaveOrderID(),
                            ditails.getOrderID(),
                            ditails.getCustomeID(),
                            ditails.getCustomerName(),
                            ditails.getCustomerAddress(),
                            ditails.getCustomertelponeNO(),
                            ditails.getCustomerOtherNO(),
                            ditails.getTime(),
                            ditails.getDate()
              
                 );
                    
                alOrderDTOs.add(dto);
                }
           
                return  alOrderDTOs;

            } else {
            
               return SearchCustomerDetails(name);
            }

        }     
    }
 
   


}
