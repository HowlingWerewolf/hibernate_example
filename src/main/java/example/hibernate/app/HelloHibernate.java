package example.hibernate.app;

import java.util.Date;

import example.hibernate.model.SessionHelper;
import example.hibernate.model.dao.PageDao;

public class HelloHibernate {
	
	
    public static void main(String[] args) {
    	
    	String helloMsg = "Hello Hibernate!";
		PageDao page = new PageDao(helloMsg);
		page.setTime(new Date());
		page.setContent(helloMsg);
		
		System.out.println(page.getUrl());		
		
		try {			
	        SessionHelper.save(page);
	        SessionHelper.save(page);
	        System.out.println("Inserted 2 records successfully!");
//	        List<PageDao> list = SessionHelper.query("select p from page p");
//	        list.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}  

}