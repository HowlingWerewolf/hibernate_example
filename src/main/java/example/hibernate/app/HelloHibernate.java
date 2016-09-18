package example.hibernate.app;

import example.hibernate.model.SessionHelper;
import example.hibernate.model.dao.PageDao;

public class HelloHibernate {
	
	
    public static void main(String[] args) {
    	
    	String helloMsg = "Hello Hibernate!";
		PageDao page = new PageDao(helloMsg);
		
		System.out.println(page.getUrl());		
		
		try {			
	        SessionHelper.save(page);
	        SessionHelper.save(page);
	        System.out.println("Inserted 2 records successfully!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}  

}