package com.simpleBlog.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.simpleBlog.model.Story;

public interface StoryRepositories extends CrudRepository<Story, Long> {

	List<Story> findAll();
	Story findByTitle(String title);
	
}
