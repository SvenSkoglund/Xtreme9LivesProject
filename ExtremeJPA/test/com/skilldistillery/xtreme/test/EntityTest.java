package com.skilldistillery.xtreme.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skilldistillery.xtreme.entities.Category;
import com.skilldistillery.xtreme.entities.Comment;
import com.skilldistillery.xtreme.entities.Post;

public class EntityTest {

	private EntityManagerFactory emf;
	private EntityManager em;

	@BeforeEach
	public void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("Xtreme");
		em = emf.createEntityManager();
	}

	@AfterEach
	public void tearDown() throws Exception {
		em.close();
		emf.close();
	}

	@Test
	void test_category_mappings() {
		Category cat = em.find(Category.class, 1);
		assertNotNull(cat);
		System.out.println(cat);


	}
	
	@Test
	void test_comment_mappings() {
		Comment com = em.find(Comment.class, 1);
		assertNotNull(com);
		System.out.println(com);


	}
	@Test
	void test_post_mappings() {
		Post post = em.find(Post.class, 1);
		assertNotNull(post);
		System.out.println(post);
		
		String sql = "select p from Post p";
		assertNotNull(em.createQuery(sql, Post.class).getResultList());
		System.out.println(em.createQuery(sql, Post.class).getResultList());

	}
}