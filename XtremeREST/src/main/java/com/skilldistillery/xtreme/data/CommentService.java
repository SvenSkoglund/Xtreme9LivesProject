package com.skilldistillery.xtreme.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.xtreme.entities.Comment;

public interface CommentService {

	List<Comment> index();

	List<Comment> findByPostId(int id);

	Comment create(int id, Comment comment);

	Boolean delete(int cid);

}
