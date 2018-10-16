
import java.util.List;
import lk.ijse.DiliverSystem.entity.AddCustomerDetails;
import lk.ijse.DiliverSystem.repository.SuperRepositoryImpl;
import lk.ijse.DiliverSystem.repository.custom.CustomerDetailsRepository;
import lk.ijse.DiliverSystem.resource.HibernateUtil;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
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
public class Qure extends SuperRepositoryImpl<AddCustomerDetails, String> implements CustomerDetailsRepository{
     private CustomerDetailsRepository customerDetailsRepository;
    private Session session;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
//
//    @Override
//    public List<AddCustomerDetails> searchCustomerDitails(int name) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public List<AddCustomerDetails>  SeachCustomerID(int CustomerID) throws Exception {  
//         return null;
//      try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//
//            CustomerID = 67;
//            session.beginTransaction(); 
////         //  return  (AddCustomerDetails) session.createQuery("FROM addcustomerdetails WHERE CustomeID = "+CustomerID).list().get(0);
////       Query query = session.createSQLQuery("FROM addcustomerdetails WHERE CustomeID ="+CustomerID).addEntity(AddCustomerDetails.class).setParameter("CustomerID", CustomerID);
////       List result = query.list();
////       System.out.print("CustomerRipostoryImpl"+result);
////         return null;
////        
//          String qure ="FROM addcustomerdetails WHERE CustomeID ="+CustomerID;
//          SQLQuery lQuery = (SQLQuery) session.createQuery(qure);
//          int A = lQuery.executeUpdate();
//          System.out.print(A);
//          session.getTransaction().commit();
//
//
// 
//    }
//         return null;

   // }

    @Override
    public List<AddCustomerDetails> searchCustomerDitails(String name) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
