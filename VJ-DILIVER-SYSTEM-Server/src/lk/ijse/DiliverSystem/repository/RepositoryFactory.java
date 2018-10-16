/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverSystem.repository;

import lk.ijse.DiliverSystem.repository.custom.impl.AddDiliveryRiderRepositoryImpl;
import lk.ijse.DiliverSystem.repository.custom.impl.CallSenterRepositoryImpl;
import lk.ijse.DiliverSystem.repository.custom.impl.CustomerDetailRepositoyImpl;
import lk.ijse.DiliverSystem.repository.custom.impl.CustomerRepositoryImpl;
import lk.ijse.DiliverSystem.repository.custom.impl.ItemPriceRepostoryImpl;
import lk.ijse.DiliverSystem.repository.custom.impl.LastSaveRepostoryImpl;
import lk.ijse.DiliverSystem.repository.custom.impl.LoginRiderRepositoryImpl;
import lk.ijse.DiliverSystem.repository.custom.impl.OrderDitailRpostoryImpl;
import lk.ijse.DiliverSystem.repository.custom.impl.RiderGetOrderRepostoryImpl;
import lk.ijse.DiliverSystem.repository.custom.impl.SubmitOrderRepositoryImpl;
import lk.ijse.DiliverSystem.repository.custom.impl.TakeOrderRepositoryImpl;



/**
 *
 * @author viraj jaysanka
 */
public class RepositoryFactory {
    
    public enum RepositoryTypes{
         ADDDILIVERYRIDER , CALLSENTER ,TAKEORDER , CUSTOMER ,CUSTOMERDITILS,SUBMITORDER , LOGINGRIDER ,RIDERGETORDER ,SAVEORDER , ITEMPRICE ,ORDERDITAILS
       // STOCITEM , ADDDILIVERYRIDER ,ADDCUSTOMER ,ADDPLACEORDER , ADDCEFF ,ADDCALLSENTERWORKES

    }
    
    public static RepositoryFactory repositoryFactory;
    
    private RepositoryFactory(){
        
    }
    
    public static RepositoryFactory getInstance(){
        if (repositoryFactory == null){
            repositoryFactory = new RepositoryFactory();
        }
        return repositoryFactory;
    }
    
    public SuperRepository getRepository(RepositoryTypes type){
        switch (type){
            case ADDDILIVERYRIDER:
                return new AddDiliveryRiderRepositoryImpl();
            case CALLSENTER:
                return new CallSenterRepositoryImpl();
             case TAKEORDER:
                return new TakeOrderRepositoryImpl();
             case CUSTOMER:
                return new CustomerRepositoryImpl();
             case CUSTOMERDITILS:
                return new CustomerDetailRepositoyImpl();
             case SUBMITORDER:
                return new SubmitOrderRepositoryImpl();
             case LOGINGRIDER:
                return new LoginRiderRepositoryImpl();
             case RIDERGETORDER:
                return new RiderGetOrderRepostoryImpl();
             case SAVEORDER:
                return new LastSaveRepostoryImpl();
             case ITEMPRICE:
                 return  new ItemPriceRepostoryImpl();
              case ORDERDITAILS:
                 return  new OrderDitailRpostoryImpl();
            default: 
                return null;
        }
    }
}
