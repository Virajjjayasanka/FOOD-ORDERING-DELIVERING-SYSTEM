
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import lk.ijse.DiliverSystem.dto.TakeOrderDTO;
import lk.ijse.DiliverSystem.entity.AddCustomerDetails;

import lk.ijse.DiliverSystem.entity.TakeOrder;
import lk.ijse.DiliverSystem.repository.SuperRepositoryImpl;
import lk.ijse.DiliverSystem.repository.custom.CustomerDetailsRepository;
import lk.ijse.DiliverSystem.repository.custom.TakeorderRepository;
import lk.ijse.DiliverSystem.resource.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Viraj jayasanka
 */
public class NewMain extends SuperRepositoryImpl<TakeOrder, String>{

    
 private TakeorderRepository takeorderRepository;
 private Connection connection;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
       
     

            
      try (Session session = HibernateUtil.getSessionFactory().openSession()) {

           // takeorderRepository.setSession(session);
            
            session.beginTransaction();
            String name="";
            name="viraj";
      //    List<TakeOrder> orders=(List<TakeOrder>) takeorderRepository.Qure();
           Query qure = session.getNamedQuery("TeleponeOperterName");
           qure.setParameter(0, "charith");
           List<TakeOrder> user = qure.list();
           for(TakeOrder users : user)
               System.out.print(user);
               }
    }

//
//    @Override
//    public List<AddCustomerDetails> searchCustomerDitails(String name) throws Exception {
//     return null;
//
//    }
//    
//    @Override
//    public List<TakeOrder> Qure(String name) throws Exception {
//
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//
//         List<AddCustomerDetails> customerDitels=(List<AddCustomerDetails>) CustomerDetailsRepository.Qure(CustomerID);
//          
//           session.createSQLQuery("select  SaveOrderID ,CustomeID , OrderID ,CustomerName, CustomerAddress,CustomertelponeNO,CustomerOtherNO ,Time,Date\\n\" +\n" +
//           "\"	from AddCustomerDetails where  CustomerName  = ?"+CustomerID);
//           
//         //  Query qure = session.getNamedQuery("SeachCustomerDitaills");
//           List<AddCustomerDetails> user = customerDetailsRepository.Qure(CustomerID);
//          System.out.print(user);
//           for(AddCustomerDetails users : user) 
//               
//            return user;
//           
//        return null;
//
//        }
//    }
//}
//}
//
//    

}