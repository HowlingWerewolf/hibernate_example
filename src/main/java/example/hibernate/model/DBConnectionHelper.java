package example.hibernate.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBConnectionHelper {

	private static DBConnectionHelper instance = null;
	private static SessionFactory sessionFactory;
	
	public DBConnectionHelper() {
		try {
			setUp();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static DBConnectionHelper getInstance() {
		instance = new DBConnectionHelper();
		return instance;
	}
	
	public static Session getSession() {
		getInstance();
		return DBConnectionHelper.getSessionFactory().openSession();
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
	
	public void closeSession() {
		sessionFactory.close();	 
	}
	
    static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	static void setSessionFactory(SessionFactory sessionFactory) {
		DBConnectionHelper.sessionFactory = sessionFactory;
	}
	
}
