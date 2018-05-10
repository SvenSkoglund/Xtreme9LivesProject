package com.skilldistillery.xtreme.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.xtreme.entities.Category;
import com.skilldistillery.xtreme.entities.Post;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	PostRepository repo;

	@Autowired
	PostDao postDao;
	
	@Override
	public List<Post> index() {
		return repo.findAll();
	}

	@Override
	public List<Post> searchPostByKeyword(String keyword) {
		List<Post> returned = repo.findByTitleLike("%" + keyword +"%");
		returned.addAll(repo.findByNameLike("%" + keyword +"%"));
		return returned;
	}

	@Override
	public List<Post> findByPriceBetween(double low, double high) {
		// TODO Auto-generated method stub
		return repo.findByPriceBetween(low,high);
	}

}
