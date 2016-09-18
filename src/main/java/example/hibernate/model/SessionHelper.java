package example.hibernate.model;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class SessionHelper {

	private static Session session = null;
	
	public SessionHelper() {
	}
	
	public static void createSession(){
        session = DBConnectionHelper.getSession();
	}
	
	public static void save(Object o){
		try {
			createSession();
			
        	Transaction tx = session.beginTransaction();
        	session.save(o);
        	tx.commit();
        } catch (Exception ex) {
        	System.out.println(ex.getMessage());
        	System.out.println(ex.getStackTrace());
        } finally {
        	session.close();
        	DBConnectionHelper.getInstance();
			DBConnectionHelper.getSessionFactory().close();
        }
	}
}
