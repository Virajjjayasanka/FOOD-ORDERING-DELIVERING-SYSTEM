/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverSystem.repository.custom.impl;

import java.util.List;
import lk.ijse.DiliverSystem.entity.Customer;
import lk.ijse.DiliverSystem.repository.SuperRepositoryImpl;
import lk.ijse.DiliverSystem.repository.custom.CustomerRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Viraj jayasanka
 */
public class CustomerRepositoryImpl  extends SuperRepositoryImpl<Customer, String> implements CustomerRepository{

    private CustomerRepository customerRepository;
    private Session session;
    
    public CustomerRepositoryImpl() {
    }

    @Override
    public List<Customer> getCustomerName(String name) throws Exception {
           
        List<Customer> customers=(List<Customer>) customerRepository.getCustomerName(name);
           Query qure = session.getNamedQuery("SlectCustomerName");
           List<Customer> user = customerRepository.getCustomerName(name);
           for(Customer users : user) 
           return user;
           
           
           return null;
    } 
}
