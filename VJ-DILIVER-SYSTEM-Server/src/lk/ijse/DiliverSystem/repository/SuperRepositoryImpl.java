/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverSystem.repository;

import com.mysql.jdbc.ParameterBindings;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.NamedNativeQuery;
import lk.ijse.DiliverSystem.entity.TakeOrder;
import org.hibernate.Session;
import org.hibernate.annotations.Parameter;
import org.hibernate.boot.model.source.spi.CascadeStyleSource;
import static org.hibernate.criterion.Projections.id;
import org.hibernate.engine.query.spi.HQLQueryPlan;
import org.hibernate.jdbc.ReturningWork;
import org.hibernate.query.Query;

/**
 *
 * @author Viraj jayasanka
 */
public abstract class SuperRepositoryImpl<T, ID extends Serializable> implements SuperRepository<T, ID>{
    
    private Session session;
    private Class<T> entityClass;
    
    public SuperRepositoryImpl(){
        entityClass = (Class<T>)(((ParameterizedType)(this.getClass().getGenericSuperclass())).getActualTypeArguments()[0]);
        System.out.println(entityClass);
    }

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public boolean save(T t) throws Exception {
        return (session.save(t) !=null);
    }

    @Override
    public void delete(T t) throws Exception {
        session.delete(t);
    }
    
    @Override
    public void update(T t) throws Exception {
        session.update(t);
    }

   @Override
    public T findById(ID id) throws Exception {
        return (T) session.get(entityClass, id);
    }
@Override
    public T findById(int id) throws Exception {
        return (T) session.get(entityClass, id);
    }
    
    @Override
    public List<T> findAll() throws Exception {
        return session.createQuery(" FROM " + entityClass.getSimpleName()).list();
    }
    
//    @Override
//    public List<TakeOrder> Qure(String name) throws Exception {
//      
      //  return  (List<TakeOrder>)session.createQuery("from takeorder where  TelepOneOperterName='"+name+"'").list();
// 
               
    
 
}
    // Query qure = session.getNamedQuery("TeleponeOperterName"+getClass());

//return (T) session.doReturningWork((ReturningWork<T>) t);
//         String name="";

//            name="viraj";
   // return (List<T>) = session.getNamedQuery("TeleponeOperterName").setString(0, "charith");
  
     //return  (List<T>) session.createQuery("TeleponeOperterName"+);
             // qure.setParameter(0,id);
         //  List<T> user = qure.list();
//           for(TakeOrder users : user)
//               System.out.print(user);
      //  return null;
        