package com.skilldistillery.xtreme.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.xtreme.data.CommentService;
import com.skilldistillery.xtreme.entities.Comment;
import com.skilldistillery.xtreme.entities.Post;

@RestController
@RequestMapping("api")
public class CommentController {

	@Autowired
	private CommentService service;

	// List<Comment> GET api/posts/{id}/comments Gets all comments for a post
	// Comment POST api/posts/{id}/comments Creates a new comment on a post
	// Boolean	DELETE api/posts/{id}/comments/{cid}	Deletes a comment by id
	
	@RequestMapping(path="/posts/{id}/comments", method = RequestMethod.GET)
	private List<Comment> commentsByPost(@PathVariable int id){
		return service.findByPostId(id);
	}

	@RequestMapping(path="/posts/{id}/comments", method = RequestMethod.POST)
	private Comment createCommentOnPost(@PathVariable int id, @RequestBody Comment comment){
		return service.create(id, comment);
	}
	@RequestMapping(path="/posts/{id}/comments/{cid}", method = RequestMethod.DELETE)
	private Boolean delete(@PathVariable int cid){
		return service.delete(cid);
	}
	
}
