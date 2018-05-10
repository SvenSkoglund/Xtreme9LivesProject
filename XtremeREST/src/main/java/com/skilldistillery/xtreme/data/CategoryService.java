package com.skilldistillery.xtreme.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.xtreme.entities.Category;
import com.skilldistillery.xtreme.entities.Comment;
import com.skilldistillery.xtreme.entities.Post;

public interface CategoryService {

	List<Category> index();

	List<Post> postsByCategory(int id);


}
