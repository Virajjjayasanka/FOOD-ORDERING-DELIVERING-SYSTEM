/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverSystem.resource;

import java.io.File;
import lk.ijse.DiliverSystem.entity.AddCustomerDetails;
import lk.ijse.DiliverSystem.entity.AddDiliveryRider;
import lk.ijse.DiliverSystem.entity.CallSenter;
import lk.ijse.DiliverSystem.entity.Customer;
import lk.ijse.DiliverSystem.entity.LastOrderSave;
import lk.ijse.DiliverSystem.entity.LoginRider;
import lk.ijse.DiliverSystem.entity.OrderDitails;
import lk.ijse.DiliverSystem.entity.RiderGetOrder;
import lk.ijse.DiliverSystem.entity.SubmitOrder;
import lk.ijse.DiliverSystem.entity.TakeOrder;
import lk.ijse.DiliverSystem.entity.itemPrice;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 *
 * @author Viraj jayasanka
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    
    private static StandardServiceRegistry registry;
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            
            // (1) 
            File hibernateProperties = new File("settings/hibernate.properties");
            registry = new StandardServiceRegistryBuilder().loadProperties(hibernateProperties).build();
            
            // (2)
            sessionFactory = new MetadataSources(registry)
                    .addAnnotatedClass(AddDiliveryRider.class)
                    .addAnnotatedClass(CallSenter.class)
                    .addAnnotatedClass(TakeOrder.class)
                    .addAnnotatedClass(Customer.class)
                    .addAnnotatedClass(AddCustomerDetails.class)
                    .addAnnotatedClass(SubmitOrder.class)
                    .addAnnotatedClass(LoginRider.class)
                    .addAnnotatedClass(RiderGetOrder.class)
                    .addAnnotatedClass(LastOrderSave.class)
                    .addAnnotatedClass(itemPrice.class)
                    .addAnnotatedClass(OrderDitails.class)
                    .buildMetadata().buildSessionFactory();
            
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            
            StandardServiceRegistryBuilder.destroy(registry);
            
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
}
