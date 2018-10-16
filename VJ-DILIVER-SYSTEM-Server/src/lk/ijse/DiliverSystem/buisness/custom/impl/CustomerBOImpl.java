/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverSystem.buisness.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.DiliverSystem.buisness.customs.CustomerBO;
import lk.ijse.DiliverSystem.dto.CustomerDTO;
import lk.ijse.DiliverSystem.entity.Customer;
import lk.ijse.DiliverSystem.repository.RepositoryFactory;
import lk.ijse.DiliverSystem.repository.custom.CustomerRepository;
import lk.ijse.DiliverSystem.resource.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Viraj jayasanka
 */
public class CustomerBOImpl implements CustomerBO{

    
     private CustomerRepository customerRepository;

    public CustomerBOImpl() {
        this.customerRepository = (CustomerRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.CUSTOMER);
    }
    
    
    @Override
    public boolean addCustomer(CustomerDTO customerDTO) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            customerRepository.setSession(session);
            
            session.beginTransaction();
            
                Customer T = new Customer(
                    customerDTO.getOrderID(),
                    customerDTO.getTeleponeOperterName(),
                    customerDTO.getCustomerName(),
                    customerDTO.getCustomerAddress(),
                    customerDTO.getCustomerTelePoneNO(),
                    customerDTO.getOtherTelePoneNO(),
                    customerDTO.getStringNote(),
                    customerDTO.getTime(),
                    customerDTO.getDate()
                
                );
                
            boolean result = customerRepository.save(T);
            
            session.getTransaction().commit();

            return result;
        } 
    
    }

    @Override
    public boolean updateCustomer(CustomerDTO customerDTO) throws Exception {
            
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            customerRepository.setSession(session);
            
            session.beginTransaction();
            
            Customer T = new Customer(
                    customerDTO.getCustomerID(),
                    customerDTO.getOrderID(),
                    customerDTO.getTeleponeOperterName(),
                    customerDTO.getCustomerName(),
                    customerDTO.getCustomerAddress(),
                    customerDTO.getCustomerTelePoneNO(),
                    customerDTO.getOtherTelePoneNO(),
                    customerDTO.getStringNote(),
                    customerDTO.getTime(),
                    customerDTO.getDate()
            );
            customerRepository.update(T);
              
            return true;
        }catch(Exception exp){
            exp.printStackTrace();
            return false;
        }
        
    }

    @Override
    public boolean deleteCustomer(int CustomerID) throws Exception {
        
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            customerRepository.setSession(session);
            
            session.beginTransaction();

            Customer customer = customerRepository.findById(CustomerID);
            boolean result = false;

            if (customer != null) {

                customerRepository.delete(customer);
            }
            session.getTransaction().commit();

            return result;
        }catch(Exception exp){
            exp.printStackTrace();
            return false;
        }
    
    }
   
    @Override
    public boolean searchCustomer(String CustomerName) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    @Override
    public List<CustomerDTO> getAllCustomers() throws Exception {
      
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            customerRepository.setSession(session);
            
            session.beginTransaction();

            List<Customer> customers = customerRepository.findAll();
            
            session.getTransaction().commit();

            if (customers != null) {

                List<CustomerDTO> alOrderDTOs = new ArrayList<>();

                for (Customer customer : customers) {
                    CustomerDTO dto = new CustomerDTO(
                            customer.getId(),
                            customer.getOrderID(),
                            customer.getTeleponeOperterName(),
                            customer.getCustomerName(),
                            customer.getCustomerAddress(),
                            customer.getCustomerTelePoneNO(),
                            customer.getOtherTelePoneNO(),
                            customer.getStringNote(),
                            customer.getTime(),
                            customer.getDate()
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
    public List<CustomerDTO> getCustomerName(String name) throws Exception {
       
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

           session.beginTransaction();
           
           Query qure = session.getNamedQuery("SlectCustomerName");
           qure.setParameter(0, name);
           
           List<Customer> user = qure.list();
           
             if (user != null) {
                List<CustomerDTO> alOrderDTOs = new ArrayList<>();
 
                for (Customer customer : user) {
                    CustomerDTO dto = new CustomerDTO(
                            customer.getId(),
                            customer.getOrderID(),
                            customer.getTeleponeOperterName(),
                            customer.getCustomerName(),
                            customer.getCustomerAddress(),
                            customer.getCustomerTelePoneNO(),
                            customer.getOtherTelePoneNO(),
                            customer.getStringNote(),
                            customer.getTime(),
                            customer.getDate()
                      );
                    alOrderDTOs.add(dto);
                     System.out.println(dto);
                }
                return  alOrderDTOs;
               
                        
            } else {
                return getCustomerName(name);
            }
 
        }
        
    }
    
}
