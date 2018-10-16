/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverSystem.buisness;

import lk.ijse.DiliverSystem.buisness.custom.impl.AddDiliveryRidersBOImpl;
import lk.ijse.DiliverSystem.buisness.custom.impl.CallSenterBOImpl;
import lk.ijse.DiliverSystem.buisness.custom.impl.CustomerBOImpl;
import lk.ijse.DiliverSystem.buisness.custom.impl.CustomerDetailBOImpl;
import lk.ijse.DiliverSystem.buisness.custom.impl.ItemBOImpl;
import lk.ijse.DiliverSystem.buisness.custom.impl.LastOrderSaveBOImpl;
import lk.ijse.DiliverSystem.buisness.custom.impl.LoginRiderBOImpl;
import lk.ijse.DiliverSystem.buisness.custom.impl.OrderDitailsBoImpl;
import lk.ijse.DiliverSystem.buisness.custom.impl.RiderGetorderBOImpl;
import lk.ijse.DiliverSystem.buisness.custom.impl.SubmiOrdertBOImpl;
import lk.ijse.DiliverSystem.buisness.custom.impl.TakeOrderBOImpl;
import lk.ijse.DiliverSystem.repository.custom.impl.RiderGetOrderRepostoryImpl;


/**
 *
 * @author Viraj jayasanka
 */
public class BOFactory {
    
    public enum BOTypes{
        ADDDILIVERYRIDER , CALLSENTER , TAKEORDER , CUSTOMER , CUSTOMERDITILS , SUBMITORDER , LOGINGRIDER,RIDERGETORDER ,SAVEORDER ,ITEMPRICE ,ORDERDITAILS
    }
    
    private static BOFactory boFactory;
    
    private BOFactory(){
        
    }
    
    public static BOFactory getInstance(){
        if (boFactory == null){
            boFactory = new BOFactory();
        }
        return boFactory;
    }
    
    public SuperBO getBO(BOTypes type){
        switch(type){
           case ADDDILIVERYRIDER:
                return new AddDiliveryRidersBOImpl();
           case CALLSENTER:
               return new CallSenterBOImpl();
           case TAKEORDER:
               return new TakeOrderBOImpl();
           case CUSTOMER:
               return new CustomerBOImpl();
           case CUSTOMERDITILS:
               return new CustomerDetailBOImpl();   
           case SUBMITORDER:
               return new SubmiOrdertBOImpl();
           case LOGINGRIDER:
               return new LoginRiderBOImpl();
           case RIDERGETORDER:
               return new RiderGetorderBOImpl();
          case SAVEORDER:
               return new LastOrderSaveBOImpl();
          case ITEMPRICE:
               return new ItemBOImpl();
         case ORDERDITAILS:
               return new OrderDitailsBoImpl();
            default:
                return null;
        }
    }
}
