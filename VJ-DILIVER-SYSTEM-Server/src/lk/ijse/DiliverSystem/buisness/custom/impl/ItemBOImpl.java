/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverSystem.buisness.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.DiliverSystem.buisness.customs.ItemBO;
import lk.ijse.DiliverSystem.dto.ItemPriceDTO;
import lk.ijse.DiliverSystem.entity.itemPrice;
import lk.ijse.DiliverSystem.repository.RepositoryFactory;
import lk.ijse.DiliverSystem.repository.custom.ItemPriceRepostory;
import lk.ijse.DiliverSystem.resource.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Viraj jayasanka
 */
public class ItemBOImpl implements ItemBO{

    private ItemPriceRepostory itemPriceRepostory;
    public ItemBOImpl() {
        this.itemPriceRepostory = (ItemPriceRepostory) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.ITEMPRICE);
    }

    @Override
    public boolean addItem(ItemPriceDTO itemPriceDTO) throws Exception {
         
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            itemPriceRepostory.setSession(session);
            
            session.beginTransaction();
            
                itemPrice T = new itemPrice(
                    itemPriceDTO.getID(),
                    itemPriceDTO.getItemName(),
                    itemPriceDTO.getUnitPrice()
                );
                
            boolean result = itemPriceRepostory.save(T);
            
            session.getTransaction().commit();

            return result;
        } 
    }

    @Override
    public boolean updateItem(ItemPriceDTO itemPriceDTO) throws Exception {
        
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            itemPriceRepostory.setSession(session);
            
            session.beginTransaction();
           
                itemPrice T = new itemPrice(
                    itemPriceDTO.getID(),
                    itemPriceDTO.getItemName(),
                    itemPriceDTO.getUnitPrice()
                );

            itemPriceRepostory.update(T);
            
            session.getTransaction().commit();
            
            return true;
        }catch(Exception exp){
            exp.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteItem(int Id) throws Exception {
         
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            itemPriceRepostory.setSession(session);
            
            session.beginTransaction();

            itemPrice price = itemPriceRepostory.findById(Id);
            boolean result = false;

            if (price != null) {

                itemPriceRepostory.delete(price);
            }
            
            session.getTransaction().commit();
             
            return result;
        }catch(Exception exp){
            exp.printStackTrace();
            return false;
        }
    
    }

    @Override
    public boolean searchItem(String ItemID) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ItemPriceDTO> getAllItems() throws Exception {
        
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            itemPriceRepostory.setSession(session);
            
            session.beginTransaction();

            List<itemPrice> prices = itemPriceRepostory.findAll();
            
           
            
            if (prices != null) {

                List<ItemPriceDTO> alOrderDTOs = new ArrayList<>();

                for (itemPrice price1 : prices) {
                    ItemPriceDTO dto = new ItemPriceDTO(
                            price1.getID(),
                            price1.getItemName(),
                            price1.getUnitPrice()  
                      );
                    alOrderDTOs.add(dto);
                }
         
             
                return alOrderDTOs;

            } else {

                return null;
            }

        }  

        
    }
    
}
