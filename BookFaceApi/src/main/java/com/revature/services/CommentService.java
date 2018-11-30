package com.revature.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Comment;
import com.revature.models.CommentLike;
import com.revature.models.Post;
import com.revature.models.PostLike;
import com.revature.repos.CommentLikeRepo;
import com.revature.repos.CommentRepo;
import com.revature.repos.PostLikeRepo;

@Service
public class CommentService {

	@Autowired
	private CommentRepo cr;
	
	@Autowired
	private CommentLikeRepo lr;

	public List<Comment> findByPostId(int id){
		return cr.findByPostId(id);
	}
	
	public List<Comment> findAll() {
		return cr.findAll();
	}
	
	public Comment findById(int id) {
		return cr.getOne(id);
	}
	
	public Comment save(Comment c) {
		return cr.save(c);
	}
	
	@Transactional
	public Comment like(CommentLike l) { 
		lr.save(l);
		// step 2: Get the post object pr.getOne(l.getPostID) (pseudocode)
		Comment c = cr.getOne(l.getCommentId());
		
		// change post likes value based by the value from the like
		if (l.getLikeValue())
		{
			c.setCommentLikes(c.getCommentLikes() + 1);
		}
		else
		{
			c.setCommentLikes(c.getCommentLikes() - 1);
		}
		
		//Clark: do we need to do pr.save(p)?
		
		return c;
		
	}
}
