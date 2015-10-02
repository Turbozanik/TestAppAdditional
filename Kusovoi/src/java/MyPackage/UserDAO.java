package MyPackage;



import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
 

 
public class UserDAO {
    
     // 1. configuring hibernate
            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
 
            // 2. create sessionfactory
           SessionFactory sessionFactory = configuration.buildSessionFactory();
 
    public void addUserDetails(String userName, String password) {
        try {
           
 
            // 3. Get Session object
            Session session = sessionFactory.openSession();
 
            // 4. Starting Transaction
            Transaction transaction = session.beginTransaction();
            User user = new User();
            user.setUserName(userName);
            user.setPassword1(password);
            session.save(user);
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
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
 
            // 3. Get Session object
            Session session = sessionFactory.openSession();
 
            // 4. Starting Transaction
            Transaction transaction = session.beginTransaction();
            User user = new User();
            user.setId(id);
            session.delete(user);
            transaction.commit();
            session.close();
            transaction = null;
            session = null;
        return false;
}
 
    public List<User> getAllEnttities()
    {
         
 
            // 3. Get Session object
            Session session = sessionFactory.openSession();
 
            // 4. Starting Transaction
            Transaction transaction = session.beginTransaction();
            User user = new User();
            List list = session.createQuery("FROM MyPackage.User").list();  
            transaction.commit();
            session.close();
            transaction = null;
            session = null;
        return list;  
        
    }
    public void editUserDetails(String userName,String userPassword,int ID)
    {
     try {
           
 
            // 3. Get Session object
            Session session = sessionFactory.openSession();
 
            // 4. Starting Transaction
            Transaction transaction = session.beginTransaction();
           // int id = Integer.parseInt(ID);
            User user = new User();
            user.setUserName(userName);
            user.setPassword1(userPassword);
            user.setId(ID);
            session.update(user);
            transaction.commit();
            transaction = null;
            session.close();
            session = null;
            System.out.println("\n\n Details Added \n");
 
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            System.out.println("error");
        }
    
}
}