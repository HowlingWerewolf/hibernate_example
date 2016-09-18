package example.hibernate.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBConnectionHelper {

	private static DBConnectionHelper instance = null;
	private static SessionFactory sessionFactory;
	
	private DBConnectionHelper() {
		try {
			setUp();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static DBConnectionHelper getInstance() {
		instance = new DBConnectionHelper();
		return instance;
	}
	
	protected static Session getSession() {
		getInstance();
		return DBConnectionHelper.getSessionFactory().openSession();
	}
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		closeSessionFactory();
	}
	
	protected static void closeSessionFactory() {
		sessionFactory.close();
	}
	
	private static void setUp() throws Exception {
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
	
	private static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
}
