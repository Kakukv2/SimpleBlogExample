package com.simpleBlog.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import com.simpleBlog.model.Blogger;
import com.simpleBlog.model.Story;
import com.simpleBlog.repositories.BloggerRepositories;
import com.simpleBlog.repositories.StoryRepositories;

@Service
public class StoryService {
	
	private String text;
	
	public String getText() {return text;}
	public void setText(String text) {this.text = text;}
	
	private StoryRepositories storyRepositories;
	private BloggerRepositories bloggerRepositories;
	
	@Autowired
	public void setBloggerRepositories(BloggerRepositories bloggerRepositories) {
		this.bloggerRepositories = bloggerRepositories;
	}
	@Autowired
	public void setStoryRepo(StoryRepositories storyRepositories) {
		this.storyRepositories = storyRepositories;
	}
	public List<Story> getAllStories(){
		return storyRepositories.findAll();
	}
	public List<Blogger> getAllBloggers(){
		return bloggerRepositories.findAll();
	}
	public Story findStory(String text) {
		return storyRepositories.findByTitle(text);
	}
	public Blogger findBlogger(String name) {
		return bloggerRepositories.findByName(name);
	}
	
	@PostConstruct
	public void init() throws FileNotFoundException {
		StoryService story = new StoryService();
		System.out.println(story.getText());
		Blogger anonymous = new Blogger();
		anonymous.setName("anonymous");
		bloggerRepositories.save(anonymous);
		Story firstStory = new Story();
		firstStory.setBlogger(anonymous);
		firstStory.setContent("A text tartalma:" +story.getText());
		firstStory.setDescription("Traveling Tips");
		firstStory.setTitle("Travelling");
		firstStory.setPosted(new Date());
		storyRepositories.save(firstStory);
	}
	/*public void contentIn() throws IOException {
		Resource resource = new ClassPathResource("D:\\STS\\works\\SimpleBlogExample\\src\\main\\resources\\static\\Anonymous.txt");
		
	}
	public static Document readTxt(InputStream is) {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
		DocumentBuilder doc = null;
		doc = 
		
	}*/
	
}

