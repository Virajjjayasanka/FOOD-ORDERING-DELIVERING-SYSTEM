/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverSystem.buisness.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.DiliverSystem.buisness.customs.CallSenterBO;
import lk.ijse.DiliverSystem.dto.CallSenterDTO;
import lk.ijse.DiliverSystem.dto.DiliveryRiderDTO;
import lk.ijse.DiliverSystem.entity.CallSenter;
import lk.ijse.DiliverSystem.repository.RepositoryFactory;
import lk.ijse.DiliverSystem.repository.custom.CallSenterRepository;
import lk.ijse.DiliverSystem.resource.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Viraj jayasanka
 */
public class CallSenterBOImpl implements CallSenterBO{

    private CallSenterRepository callSenterRepository;
    
     public CallSenterBOImpl() {
        this.callSenterRepository = (CallSenterRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.CALLSENTER);
    }

    @Override
    public boolean addDiliveryRider(CallSenterDTO callSenterDTO) throws Exception {
           
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            callSenterRepository.setSession(session);
            
            session.beginTransaction();
            
                CallSenter C = new CallSenter(callSenterDTO.getCallSenterID(),
                    callSenterDTO.getName(),
                    callSenterDTO.getAddress(),
                    callSenterDTO.getTeloponeNo(),
                    callSenterDTO.getAge(),
                    callSenterDTO.getNIC(),
                    callSenterDTO.getSalary(),
                    callSenterDTO.getTime(),
                    callSenterDTO.getDate()
                
                );
    
            boolean result = callSenterRepository.save(C);
            
            session.getTransaction().commit();

            return result;
        } 
        
    }

    @Override
    public boolean updateDiliveryRider(CallSenterDTO callSenterDTO) throws Exception {
        
      try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            callSenterRepository.setSession(session);
            
            session.beginTransaction();
           
                CallSenter C = new CallSenter(callSenterDTO.getCallSenterID(),
                    callSenterDTO.getName(),
                    callSenterDTO.getAddress(),
                    callSenterDTO.getTeloponeNo(),
                    callSenterDTO.getAge(),
                    callSenterDTO.getNIC(),
                    callSenterDTO.getSalary(),
                    callSenterDTO.getTime(),
                    callSenterDTO.getDate()
                
                );

            callSenterRepository.update(C);
            
            session.getTransaction().commit();
            
            return true;
        }catch(Exception exp){
            exp.printStackTrace();
            return false;
        }
        
    }

    @Override
    public boolean deleteDiliveryRider(String callSenterID) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            callSenterRepository.setSession(session);
            
            session.beginTransaction();

            CallSenter callSenter = callSenterRepository.findById(callSenterID);
            boolean result = false;

            if (callSenter != null) {

                callSenterRepository.delete(callSenter);
            }
            
            session.getTransaction().commit();

            return result;
        }catch(Exception exp){
            exp.printStackTrace();
            return false;
        }
    }

    @Override
    public List<CallSenterDTO> getAllDiliveryRider() throws Exception {
        
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            callSenterRepository.setSession(session);
            
            session.beginTransaction();

            List<CallSenter> Senters = callSenterRepository.findAll();
            
            session.getTransaction().commit();

            if (Senters != null) {

                List<CallSenterDTO> aladdCallsenter = new ArrayList<>();

                for (CallSenter callSenter : Senters) {
                    CallSenterDTO dto = new CallSenterDTO(callSenter.getCallSenterID(),
                            callSenter.getName(),
                            callSenter.getAddress(),
                            callSenter.getTeloponeNo(),
                            callSenter.getAge(),
                            callSenter.getNIC(),
                            callSenter.getSalary(),
                            callSenter.getTime(),
                            callSenter.getDate()
                      );
                    aladdCallsenter.add(dto);
                }
                return aladdCallsenter;

            } else {

                return null;
            }

        }  
    }
 
}
