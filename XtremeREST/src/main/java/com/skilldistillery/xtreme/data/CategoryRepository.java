package com.skilldistillery.xtreme.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skilldistillery.xtreme.entities.Category;
import com.skilldistillery.xtreme.entities.Post;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

	@Query("Select c.posts from Category c where c.id = :id")
	List<Post> getPostsByCategoryId(@Param("id")int id);

}
