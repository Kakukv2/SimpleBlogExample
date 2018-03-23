package com.simpleBlog.model;

import java.util.List;
import javax.persistence.*;

@Entity
public class Blogger {

	@Id
	@GeneratedValue()
	private Long id;
	private String name;
	
	@OneToMany(mappedBy="blogger")
	private List<Story> stories;

	public Blogger() {};
	
	public Blogger(String name, List<Story> stories) {
		super();
		this.name = name;
		this.stories = stories;
	}
	public Blogger(Long id, String name, List<Story> stories) {
		super();
		this.id = id;
		this.name = name;
		this.stories = stories;
	}
	public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public List<Story> getStories() {return stories;}
	public void setStories(List<Story> stories) {this.stories = stories;}
	
	
}