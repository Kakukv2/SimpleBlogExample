package com.simpleBlog.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.simpleBlog.model.Blogger;

public interface BloggerRepositories extends CrudRepository<Blogger, Long> {

	List<Blogger> findAll();
	Blogger findByName(String name);
}
