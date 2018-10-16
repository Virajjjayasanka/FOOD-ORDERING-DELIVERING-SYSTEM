/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverSystem.buisness.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.DiliverSystem.buisness.customs.LoginRiderBO;
import lk.ijse.DiliverSystem.dto.LoginRiderDTO;
import lk.ijse.DiliverSystem.entity.LoginRider;
import lk.ijse.DiliverSystem.repository.RepositoryFactory;
import lk.ijse.DiliverSystem.repository.custom.LoginRiderRepository;
import lk.ijse.DiliverSystem.resource.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Viraj jayasanka
 */
public class LoginRiderBOImpl implements LoginRiderBO {

     private LoginRiderRepository loginRiderRepository;
    
    public LoginRiderBOImpl() {
       this.loginRiderRepository = (LoginRiderRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.LOGINGRIDER);
    }

    @Override
    public boolean addLoginRider(LoginRiderDTO loginRiderDTO) throws Exception {
       
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            loginRiderRepository.setSession(session);
            
            session.beginTransaction();
            
                LoginRider T = new LoginRider(
                        
                    loginRiderDTO.getRiderID(),
                    loginRiderDTO.getRiderNAme(),
                    loginRiderDTO.getPassword(),
                    loginRiderDTO.getTime()
                
                );
                
            boolean result = loginRiderRepository.save(T);
            
            session.getTransaction().commit();

            return result;
        } 

    }

    @Override
    public boolean deleteLoginRider(int Id) throws Exception {
        
         try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            loginRiderRepository.setSession(session);
            
            session.beginTransaction();

            LoginRider loginRider = loginRiderRepository.findById(Id);
            boolean result = false;

            if (loginRider != null) {

                loginRiderRepository.delete(loginRider);
            }
            
            session.getTransaction().commit();
             
            return result;
        }catch(Exception exp){
            exp.printStackTrace();
            return false;
        }
    

    }

    @Override
    public List<LoginRiderDTO> getAllLoginRiders() throws Exception {
        
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            loginRiderRepository.setSession(session);
            
            session.beginTransaction();

            List<LoginRider> loginRiders = loginRiderRepository.findAll();
            
           
            
            if (loginRiders != null) {

                List<LoginRiderDTO> alOrderDTOs = new ArrayList<>();

                for (LoginRider loginRider1 : loginRiders) {
                   
                    LoginRiderDTO dto = new LoginRiderDTO(
                            loginRider1.getRiderID(),
                            loginRider1.getRiderNAme(),
                            loginRider1.getPassword(),
                            loginRider1.getTime()
                          
                      );
                    alOrderDTOs.add(dto);
                }
         
             
                return alOrderDTOs;

            } else {

                return null;
            }

        }  


    }

    @Override
    public LoginRiderDTO SerachId(int qid) throws Exception {
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            loginRiderRepository.setSession(session);
            session.beginTransaction();
            session.getTransaction().commit();
            LoginRider loginRider=loginRiderRepository.findById(qid);
            
            LoginRiderDTO loginRiderDTO=new  LoginRiderDTO();
                    loginRiderDTO.setRiderID(loginRider.getRiderID());
                    loginRiderDTO.setRiderNAme(loginRider.getRiderNAme());
                    loginRiderDTO.setTime(loginRider.getTime());
                    loginRiderDTO.setPassword(loginRider.getPassword());

           return loginRiderDTO;
 
        }

    }
    
}
