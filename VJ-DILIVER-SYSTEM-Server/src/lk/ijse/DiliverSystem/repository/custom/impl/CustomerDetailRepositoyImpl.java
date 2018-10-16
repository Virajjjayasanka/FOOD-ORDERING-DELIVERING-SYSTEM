/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverSystem.repository.custom.impl;

import java.util.List;
import lk.ijse.DiliverSystem.entity.AddCustomerDetails;
import lk.ijse.DiliverSystem.repository.SuperRepositoryImpl;
import lk.ijse.DiliverSystem.repository.custom.CustomerDetailsRepository;
import lk.ijse.DiliverSystem.resource.HibernateUtil;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Viraj jayasanka
 */
public class CustomerDetailRepositoyImpl extends SuperRepositoryImpl<AddCustomerDetails, String> implements CustomerDetailsRepository{
    
    private CustomerDetailsRepository customerDetailsRepository;
    private Session session;
    
    public CustomerDetailRepositoyImpl() {
   
    }


    @Override
    public List<AddCustomerDetails> searchCustomerDitails(String name) throws Exception {
        
        System.out.println("mnjneowknejlwvnljewvnk;ev"+name);
        List<AddCustomerDetails> customerDitels=(List<AddCustomerDetails>) customerDetailsRepository.searchCustomerDitails(name);

           Query qure = session.getNamedQuery("CustomeReDelatAdd");
           List<AddCustomerDetails> user = customerDetailsRepository.searchCustomerDitails(name);
           for(AddCustomerDetails users : user) 
               
            return user;
           
        return null;
    }
//
//    @Override
//    public List<AddCustomerDetails> SeachCustomerID(int CustomerID) throws Exception {
//       
//        return session.createQuery(" FROM FROM addcustomerdetails WHERE CustomeID =" + CustomerID).list();
//    }
   
}
   //  System.out.print("Errrr"+CustomerID);
          //List<AddCustomerDetails> customerDitels=(List<AddCustomerDetails>) customerDetailsRepository.SeachCustomerID(CustomerID);
          
//           return  (AddCustomerDetails) session.createQuery("FROM addcustomerdetails WHERE CustomeID = "+CustomerID).list().get(0);
//           Query query = session.createSQLQuery("FROM addcustomerdetails WHERE CustomeID ="+CustomerID).addEntity(AddCustomerDetails.class).setParameter("CustomerID", CustomerID);
//           List result = query.list();
        //       System.out.print("CustomerRipostoryImpl"+result);
    //   String SQL = "FROM addcustomerdetails WHERE CustomeID = "+CustomerID;
    //   Query query = session.createQuery(SQL);
    //   int 
       
//           Query qure = (Query) session.createQuery("FROM addcustomerdetails WHERE CustomeID = "+CustomerID).list().get(0);
//           AddCustomerDetails user = customerDetailsRepository.SeachCustomerID(CustomerID);
//           System.out.print(user);
////               session.createSQLQuery("");
//            return user;