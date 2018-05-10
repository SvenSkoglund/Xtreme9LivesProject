package com.skilldistillery.xtreme.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.xtreme.entities.Category;
import com.skilldistillery.xtreme.entities.Post;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository repo;

	@Autowired
	PostDao postDao;
	
	@Override
	public List<Category> index() {
		return repo.findAll();
	}

	@Override
	public List<Post> postsByCategory(int id) {
		
		return repo.getPostsByCategoryId(id);
	}
}
