/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverSystem.buisness.customs;

import java.util.List;
import lk.ijse.DiliverSystem.buisness.SuperBO;
import lk.ijse.DiliverSystem.dto.LasetOrderSaveDTO;

/**
 *
 * @author Viraj jayasanka
 */
public interface LastOrderSaveBO extends SuperBO{
   
    public boolean addLastOrderSave(LasetOrderSaveDTO lasetOrderSaveDTO) throws Exception;
    
    public boolean updateLastOrderSave(LasetOrderSaveDTO lasetOrderSaveDTO) throws Exception;
    
    public boolean deleteLastOrderSave(int Id) throws Exception;
    
    public boolean searchLastOrderSave(String SaveOrderID)throws Exception;
    
    public List<LasetOrderSaveDTO> getAllLastOrderSaves() throws Exception;
    
     public List<LasetOrderSaveDTO> getDataQure(String name) throws Exception;
}
