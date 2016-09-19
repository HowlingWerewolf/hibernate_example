package example.hibernate.model;

import java.util.List;

import javax.persistence.Query;

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
	
	public static void insert(Object o) {
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
	
	public static void delete(Object o) {
		try {
			createSession();
			deleteTransaction(o);
        } catch (Exception ex) {
        	System.out.println(ex.getMessage());
        	System.out.println(ex.getStackTrace());
        } finally {
        	closeSession();
        }
	}
	
	public static List<?> query(String queryString) {		
		List<?> list = null;
		
		try {
			createSession();
			list = createQuery(queryString);
        } catch (Exception ex) {
        	System.out.println(ex.getMessage());
        	System.out.println(ex.getStackTrace());
        } finally {
        	closeSession();
        }
		
		return list;
	}
	
	private static void createTransaction(Object o) {	
    	Transaction tx = session.beginTransaction();
    	session.save(o);
    	tx.commit();		
	}
	
	private static void deleteTransaction(Object o) {	
    	Transaction tx = session.beginTransaction();
    	session.delete(o);
    	tx.commit();		
	}
	
	private static List<?> createQuery(String queryString) {	
    	Query query = session.createQuery(queryString);
    	List<?> list = query.getResultList();	
    	return list;
	}
}
