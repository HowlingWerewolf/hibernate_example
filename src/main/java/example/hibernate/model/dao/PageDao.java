package example.hibernate.model.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PAGE")
public class PageDao {

	@Id
	@GeneratedValue(generator = "PAGE_SEQ", strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name = "PAGE_SEQ", sequenceName = "PAGE_SEQ")
	@Column(name = "ID")
	private int id;	

	@Column(name = "URL")
	private String url;

	@Column(name = "TIME")
	private Date time;

	@Column(name = "CONTENT")
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
