package example.hibernate.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import example.hibernate.model.PageDao;

public class HelloHibernate {
	
	static SessionFactory sessionFactory;
	
    public static void main(String[] args) {
    	
    	String helloMsg = "Hello Hibernate!";
		PageDao page = new PageDao(helloMsg);
		
		System.out.println(page.getUrl());		
		
		try {
			setUp();
	        Session session = sessionFactory.openSession();
	        System.out.println("Test connection with the database created successfuly.");

	        try {
	        	Transaction tx = session.beginTransaction();
	        	session.save(page);
			tx.commit();
	        } catch (Exception ex) {
	        	System.out.println(ex.getMessage());
	        	System.out.println(ex.getStackTrace());
	        } finally {
	        	session.close();
	    		sessionFactory.close();	        	
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}


	}
    
    protected static void setUp() throws Exception {
    	try {
    		sessionFactory = new Configuration().configure().buildSessionFactory();
    	}
    	catch (Exception e) {
    		// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
    		// so destroy it manually.
    		System.out.println(e.toString());
    		e.printStackTrace();
    		sessionFactory.close();
    	}
    }
}