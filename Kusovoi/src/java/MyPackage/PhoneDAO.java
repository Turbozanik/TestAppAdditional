package MyPackage;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import static org.eclipse.jdt.internal.compiler.parser.Parser.name;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
 

 
public class PhoneDAO {
 
    
    // 1. configuring hibernate
            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
 
            // 2. create sessionfactory
            SessionFactory sessionFactory = configuration.buildSessionFactory();
    
    
    public List<PhoneBaseItem> getSortedByDescriptionEnttities(String sortDescription)
    {
        
 
            // 3. Get Session object
            Session session = sessionFactory.openSession();
 
            // 4. Starting Transaction
            Transaction transaction = session.beginTransaction();
            PhoneBaseItem phone = new PhoneBaseItem();
            List list = session.createQuery("FROM MyPackage.PhoneBaseItem WHERE description =" + sortDescription).list();  
            transaction.commit();
            session.close();
            transaction = null;
            session = null;
        return list;  
        
    }
    
    public List<PhoneBaseItem> getSortedByNumberEnttities(String sortNumber)
    {
         
 
            // 3. Get Session object
            Session session = sessionFactory.openSession();
 
            // 4. Starting Transaction
            Transaction transaction = session.beginTransaction();
            PhoneBaseItem phone = new PhoneBaseItem();
            List list = session.createQuery("FROM MyPackage.PhoneBaseItem WHERE phoneNumber =" + sortNumber).list();  
            transaction.commit();
            session.close();
            transaction = null;
            session = null;
        return list;  
        
    }
    
    public List<PhoneBaseItem> getAllEnttities()
    {
         
 
            // 3. Get Session object
            Session session = sessionFactory.openSession();
 
            // 4. Starting Transaction
            Transaction transaction = session.beginTransaction();
            PhoneBaseItem phone = new PhoneBaseItem();
            List list = session.createQuery("FROM MyPackage.PhoneBaseItem").list();  
            transaction.commit();
            session.close();
            transaction = null;
            session = null;
        return list;  
        
    }
    
    public void addPhoneDetails(String description, String number,String mobNumber) {
        try {
            
 
            // 3. Get Session object
            Session session = sessionFactory.openSession();
 
            // 4. Starting Transaction
            Transaction transaction = session.beginTransaction();
            PhoneBaseItem phone = new PhoneBaseItem();
//            user.setUserName(userName);
//            user.setPassword1(password);
            phone.setDescription(description);
            phone.setPhoneNumber(number);
            phone.setMobNumber(mobNumber);
            session.save(phone);
            transaction.commit();
            session.close();
            transaction = null;
            session = null;
            System.out.println("\n\n Details Added \n");
 
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            System.out.println("error");
        }
 
    }
    public boolean deleteById(int id) {
        
 
            // 3. Get Session object
            Session session = sessionFactory.openSession();
 
            // 4. Starting Transaction
            Transaction transaction = session.beginTransaction();
            PhoneBaseItem phone = new PhoneBaseItem();
            phone.setId(id);
            session.delete(phone);
            transaction.commit();
            session.close();
            transaction = null;
            session = null;
        return false;
}
 
    public List<PhoneBaseItem> sortOnBaseOfDescription()
    {
         
 
            // 3. Get Session object
            Session session = sessionFactory.openSession();
 
            // 4. Starting Transaction
            Transaction transaction = session.beginTransaction();
            PhoneBaseItem phone = new PhoneBaseItem();
            List list = session.createQuery("FROM MyPackage.PhoneBaseItem ORDER BY description").list();  
            transaction.commit();
            session.close();
            transaction = null;
            session = null;
        return list;  
        
    }
    public void editPhoneDetails(String description, String number,int id) {
        try {
           
            // 3. Get Session object
            Session session = sessionFactory.openSession();
            // 4. Starting Transaction
            Transaction transaction = session.beginTransaction();
            PhoneBaseItem phone = new PhoneBaseItem();
//          user.setUserName(userName);
//          user.setPassword1(password);
            phone.setId(id);
            phone.setDescription(description);
            phone.setPhoneNumber(number);
            session.update(phone);
            transaction.commit();
            session.close();
            transaction = null;
            session = null;
            System.out.println("\n\n Details Added \n");
 
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            System.out.println("error");
        }
 
    }
 
}
