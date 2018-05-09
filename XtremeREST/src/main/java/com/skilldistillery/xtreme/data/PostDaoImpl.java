package com.skilldistillery.xtreme.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skilldistillery.xtreme.entities.Post;

@Service
@Transactional
public class PostDaoImpl implements PostDao {

	@PersistenceContext
	private EntityManager em;

	// Gets all posts
	@Override
	public List<Post> index() {
		String sql = "select p from Post p";
		List<Post> posts = em.createQuery(sql, Post.class).getResultList();
		System.out.println(posts);
		return posts;
	}

	@Override
	public Post getPostById(int id) {
		return em.find(Post.class, id);
	}

	@Override
	public Post createPost(Post post) {
		try {
			em.persist(post);
			em.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return post;
	}

	@Override
	public Post updatePost(String json, int id) {
		Post managed = em.find(Post.class, id);
		Post post = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			post = mapper.readValue(json, Post.class);
			if (post.getTitle() != null && !post.getTitle().equals("")) {
				managed.setTitle(post.getTitle());
			}
			if (post.getName() != null && !post.getName().equals("")) {
				managed.setName(post.getName());
			}
			if (post.getEmail() != null && !post.getEmail().equals("")) {
				managed.setEmail(post.getEmail());
			}
			if (post.getDescription() != null && !post.getDescription().equals("")) {
				managed.setDescription(post.getDescription());
			}
			if (post.getPrice() != 0) {
				managed.setPrice(post.getPrice());
			}
			if (post.getImage_url() != null && !post.getImage_url().equals("")) {
				managed.setImage_url(post.getImage_url());
			}
			if (post.getBrand() != null && !post.getBrand().equals("")) {
				managed.setBrand(post.getBrand());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return post;
	}

	@Override
	public Post replacePost(String json, int id) {
		Post managed = em.find(Post.class, id);
		Post post = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			post = mapper.readValue(json, Post.class);
			managed.setTitle(post.getTitle());
			managed.setName(post.getName());
			managed.setEmail(post.getEmail());
			managed.setDescription(post.getDescription());
			managed.setPrice(post.getPrice());
			managed.setImage_url(post.getImage_url());
			managed.setBrand(post.getBrand());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return post;
	}

	@Override
	public boolean deletePost(int id) {
		Post post = em.find(Post.class, id);
		if (post != null) {
			try {
				em.remove(post);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;

	}
}
