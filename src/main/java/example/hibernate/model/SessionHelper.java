package example.hibernate.model;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class SessionHelper {

	private static Session session = null;
	
	public SessionHelper() {
	}
	
	private static void createSession() {
        session = DBConnectionHelper.getSession();
	}
	
	private static void closeSession() {
    	session.close();
    	DBConnectionHelper.closeSessionFactory();
	}
	
	public static void save(Object o) {
		try {
			createSession();
			createTransaction(o);
        } catch (Exception ex) {
        	System.out.println(ex.getMessage());
        	System.out.println(ex.getStackTrace());
        } finally {
        	closeSession();
        }
	}
	
	private static void createTransaction(Object o) {	
    	Transaction tx = session.beginTransaction();
    	session.save(o);
    	tx.commit();		
	}
}
