package com.skilldistillery.xtreme.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.xtreme.entities.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

	List<Post> findByTitleLike(String string);

	List<Post> findByNameLike(String string);

	List<Post> findByPriceBetween(double low, double high);

	
}
