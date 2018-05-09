package com.skilldistillery.xtreme.data;

import java.util.List;

import com.skilldistillery.xtreme.entities.Post;

public interface PostDao {

	List<Post> index();

	Post getPostById(int id);

	Post createPost(Post post);

	Post updatePost(String json, int id);

	Post replacePost(String json, int id);

	boolean deletePost(int id);

}
