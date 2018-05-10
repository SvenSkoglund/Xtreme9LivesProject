package com.skilldistillery.xtreme.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.xtreme.data.CategoryServiceImpl;
import com.skilldistillery.xtreme.entities.Category;
import com.skilldistillery.xtreme.entities.Post;

@RestController
@RequestMapping("api")
public class CategoryController {

	@Autowired
	private CategoryServiceImpl service;

	@RequestMapping(path = "/categories", method = RequestMethod.GET)
	private List<Category> index() {
		return service.index();
	}
	
	@RequestMapping(path = "/categories/{id}/posts", method = RequestMethod.GET)
	private List<Post> postsByCategory(@PathVariable("id") int id){
		return service.postsByCategory(id);		
	}
	
}
