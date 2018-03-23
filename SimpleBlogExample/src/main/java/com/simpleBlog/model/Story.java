package com.simpleBlog.model;

import java.util.Date;
import javax.persistence.*;

@Entity
public class Story {

	@Id
	@GeneratedValue()
	private Long id;
	private Date posted;
	private String content;
	private String title;
	private String description;
	
	@ManyToOne
	private Blogger blogger;
	
	public Story() {}
	
	public Story(String content, String title, Date posted, String description, Blogger blogger) {
		super();
		this.blogger = blogger;
		this.description = description;
		this.posted = posted;
		this.content = content;
		this.title = title;
	}
	public Story(Long id, String content, String title, Date posted, String description, Blogger blogger) {
		super();
		this.blogger = blogger;
		this.description = description;
		this.posted = posted;
		this.id = id;
		this.content = content;
		this.title = title;
	}
	public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}
	public String getContent() {return content;}
	public void setContent(String content) {this.content = content;}
	public String getTitle() {return title;}
	public void setTitle(String title) {this.title = title;}
	public Blogger getBlogger() {return blogger;}
	public void setBlogger(Blogger blogger) {this.blogger = blogger;}
	public Date getPosted() {return posted;}
	public void setPosted(Date posted) {this.posted = posted;}
	public String getDescription() {return description;}
	public void setDescription(String description) {this.description = description;}
	
}
