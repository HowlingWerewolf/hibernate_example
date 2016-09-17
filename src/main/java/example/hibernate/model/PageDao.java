package example.hibernate.model;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class PageDao {

	private int id;	
	private String url;
	private Date time;
	private String content;
	
	
	public PageDao() {};
	
	public PageDao(String url) {
		this.url = url;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	public Date getTime() {
		return time;
	}
	
	public void setTime(Date time) {
		this.time = time;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
}
