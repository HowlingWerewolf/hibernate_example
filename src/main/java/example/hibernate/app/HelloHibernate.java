package example.hibernate.app;

import java.util.Date;
import java.util.List;

import example.hibernate.model.SessionHelper;
import example.hibernate.model.dao.Page;

public class HelloHibernate {
	
	
    public static void main(String[] args) {
    	
    	String helloMsg = "Hello Hibernate!";
		Page page = new Page(helloMsg);
		page.setTime(new Date());
		page.setContent(helloMsg);
		
		System.out.println(page.getUrl());		
		
		try {	
			// insert 
	        SessionHelper.insert(page);
	        
	        // select
	        List<Page> list = (List<Page>) SessionHelper.query("FROM Page");
	        for(Page e : list) {
	        	System.out.println(e.getTime().toString() + " " + e.getUrl() + " " + e.getContent());
	        }
	        
	        // delete
	        SessionHelper.delete(list.get(0));
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
	}  

}