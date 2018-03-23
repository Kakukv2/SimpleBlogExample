package com.simpleBlog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.simpleBlog.service.StoryService;

@Controller
public class WebBlogController {
	private StoryService storyService;
	@Autowired
	public void setStoryService(StoryService storyService) {
		this.storyService = storyService;
	}
	
	
	@RequestMapping("/home")
	public String homeView(Model model) {
		model.addAttribute("stories", storyService.getAllStories());
		return "home";
	}
	@RequestMapping("/bloggerpage")
		public String bloggerPage(Model model) {
		model.addAttribute("stories",storyService.getAllStories());
		return "bloggerpage";
	}
	/*@RequestMapping("/{}")
	public String searchForUser(@PathVariable(value = "title") String name, Model model) throws Exception {
		if (name == null)
			throw new Exception("Nincs ilyen nevű felhasználó");
		model.addAttribute("story", storyService.findBlogger(name));
		return "story";
	}
	*/
}
