package com.skilldistillery.xtreme.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.xtreme.data.PostDao;
import com.skilldistillery.xtreme.entities.Post;

@RestController
@RequestMapping("api")
public class PostController {

	@Autowired
	private PostDao postDAO;

	@RequestMapping(path = "ping", method = RequestMethod.GET)
	public String ping() {
		return "pong";
	}

	// Gets all posts
	@RequestMapping(path = "posts", method = RequestMethod.GET)
	public List<Post> index() {
		return postDAO.index();
	}

	// GET api/posts/{id}
	@RequestMapping(path = "posts/{id}", method = RequestMethod.GET)
	public Post getPostById(@PathVariable int id) {
		return postDAO.getPostById(id);
	}

	// POST api/posts
	@RequestMapping(path = "posts", method = RequestMethod.POST)
	public Post createPost(@RequestBody Post post, HttpServletResponse response) {
		Post p = postDAO.createPost(post);
		if (post != null) {
			response.setStatus(202);
			return p;
		}else {
			response.setStatus(500);
			return null;
		}
	}

	// PUT api/posts/{id}
	@RequestMapping(path = "posts/{id}", method = RequestMethod.PUT)
	public Post replacePost(@RequestBody String json, @PathVariable int id) {
		return postDAO.replacePost(json, id);
	}
	
	// Patch api/posts/{id}
	@RequestMapping(path = "posts/{id}", method = RequestMethod.PATCH)
	public Post updatePost(@RequestBody String json, @PathVariable int id) {
		return postDAO.updatePost(json, id);
	}

	// Patch api/posts/{id}
	@RequestMapping(path = "posts/{id}", method = RequestMethod.DELETE)
	public boolean deletePost(@PathVariable int id) {
		return postDAO.deletePost(id);
	}

	
}
