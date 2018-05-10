package com.skilldistillery.xtreme.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skilldistillery.xtreme.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

	@Query("Select c from Comment c join fetch c.post where c.post.id = :id")
	List<Comment> findByPostId(@Param("id") int id);

}
