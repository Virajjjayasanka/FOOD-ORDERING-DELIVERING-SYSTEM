/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverSystem.buisness.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.DiliverSystem.buisness.customs.AddDiliveryRidersBO;
import lk.ijse.DiliverSystem.dto.DiliveryRiderDTO;
import lk.ijse.DiliverSystem.entity.AddDiliveryRider;
import lk.ijse.DiliverSystem.repository.RepositoryFactory;
import lk.ijse.DiliverSystem.repository.custom.AddDiliveryRidersRepository;
import lk.ijse.DiliverSystem.resource.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Viraj jayasanka
 */
public class AddDiliveryRidersBOImpl implements AddDiliveryRidersBO{
    
    private AddDiliveryRidersRepository diliveryRidersRepository;

    public AddDiliveryRidersBOImpl() {
        this.diliveryRidersRepository = (AddDiliveryRidersRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.ADDDILIVERYRIDER);
    }
    
    @Override
    public boolean addDiliveryRider(DiliveryRiderDTO diliveryRiderDTO) throws Exception {
          
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            diliveryRidersRepository.setSession(session);
            
            session.beginTransaction();
            
                AddDiliveryRider R = new AddDiliveryRider(
                    //diliveryRiderDTO.getId(),
                    diliveryRiderDTO.getRiderNAme(),
                    diliveryRiderDTO.getRiderAddress(),
                    diliveryRiderDTO.getRiderTelePoneNO(),
                    diliveryRiderDTO.getNIC(),
                    diliveryRiderDTO.getSalary(),
                    diliveryRiderDTO.getDate(),
                    diliveryRiderDTO.getTime()
                
                );
                
            boolean result = diliveryRidersRepository.save(R);
            
            session.getTransaction().commit();

            return result;
        } 
    }

    @Override
    public boolean updateDiliveryRider(DiliveryRiderDTO diliveryRiderDTO) throws Exception {

      try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            diliveryRidersRepository.setSession(session);
            
            session.beginTransaction();
            
            AddDiliveryRider R = new AddDiliveryRider(diliveryRiderDTO.getId(),
                   diliveryRiderDTO.getRiderNAme(),
                    diliveryRiderDTO.getRiderAddress(),
                    diliveryRiderDTO.getRiderTelePoneNO(),
                    diliveryRiderDTO.getNIC(),
                    diliveryRiderDTO.getSalary(),
                    diliveryRiderDTO.getDate(),
                    diliveryRiderDTO.getTime()
            );
            diliveryRidersRepository.update(R);
            
            session.getTransaction().commit();
            
            return true;
        }catch(Exception exp){
            exp.printStackTrace();
            return false;
        }
        
    }

    @Override
    public boolean deleteDiliveryRider(String Id) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            diliveryRidersRepository.setSession(session);
            
            session.beginTransaction();

            AddDiliveryRider addDiliveryRider = diliveryRidersRepository.findById(Id);
            boolean result = false;

            if (addDiliveryRider != null) {

                diliveryRidersRepository.delete(addDiliveryRider);
            }
            
            session.getTransaction().commit();

            return result;
        }catch(Exception exp){
            exp.printStackTrace();
            return false;
        }
    
    }

    @Override
    public List<DiliveryRiderDTO> getAllDiliveryRider() throws Exception {
   
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            diliveryRidersRepository.setSession(session);
            
            session.beginTransaction();

            List<AddDiliveryRider> DiliveryRider = diliveryRidersRepository.findAll();
            
            session.getTransaction().commit();

            if (DiliveryRider != null) {

                List<DiliveryRiderDTO> aladdDiliveryRider = new ArrayList<>();

                for (AddDiliveryRider addDiliveryRider : DiliveryRider) {
                    DiliveryRiderDTO dto = new DiliveryRiderDTO(addDiliveryRider.getId(),
                            addDiliveryRider.getRiderNAme(),
                            addDiliveryRider.getRiderAddress(),
                            addDiliveryRider.getRiderTelePoneNO(),
                            addDiliveryRider.getNIC(),
                            addDiliveryRider.getSalary(),
                            addDiliveryRider.getDate(),
                            addDiliveryRider.getTime()
                      );
                    aladdDiliveryRider.add(dto);
                }

                return aladdDiliveryRider;

            } else {

                return null;
            }

        }  
    }

    @Override
    public DiliveryRiderDTO SerachId(int qid) throws Exception {

        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            diliveryRidersRepository.setSession(session);
            session.beginTransaction();
            session.getTransaction().commit();
           
            AddDiliveryRider loginRider = diliveryRidersRepository.findById(qid);
            
            DiliveryRiderDTO loginRiderDTO=new  DiliveryRiderDTO();
                    loginRiderDTO.setId(loginRider.getId());
                    loginRiderDTO.setRiderNAme(loginRider.getRiderNAme());
                    loginRiderDTO.setRiderAddress(loginRider.getRiderAddress());
                    loginRiderDTO.setNIC(loginRider.getNIC());

           return loginRiderDTO;
 
        }

    }
    
    
    
    
}
