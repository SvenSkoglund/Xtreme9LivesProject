package com.skilldistillery.xtreme.data;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.xtreme.entities.Comment;
import com.skilldistillery.xtreme.entities.Post;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentRepository repo;

	@Autowired
	PostDao postDao;

	@Override
	public List<Comment> index() {
		return repo.findAll();
	}

	@Override
	public List<Comment> findByPostId(int id) {

		return repo.findByPostId(id);
	}

	@Override
	public Comment create(int id, Comment comment) {
		Post post = postDao.getPostById(id);
		comment.setPost(post);
		return repo.saveAndFlush(comment);
	}

	@Override
	public Boolean delete(int cid) {
		repo.deleteById(cid);
		try {
			Comment c = repo.findById(cid).get();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return true;
		}

	}
}
