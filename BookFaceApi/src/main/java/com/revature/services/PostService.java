package com.revature.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.PostLike;
import com.revature.models.Post;
import com.revature.repos.PostLikeRepo;
import com.revature.repos.PostRepo;

@Service
public class PostService {
	
	@Autowired
	private PostRepo pr;
	
	@Autowired
	private PostLikeRepo lr; //CREATE LIKEREPO
	
	public List<Post> findAll() {
		return pr.findAll();
	}
	
	public List<Post> findByAuthor(int id) {
		return pr.findByUser(id);
	}
	
	public Post findById(int id){
		return pr.getOne(id);
	}
	
	public Post save(Post p) {
		return pr.save(p);
	}
	
	
	@Transactional
	public Post like(PostLike l) { 
		lr.save(l);
		// step 2: Get the post object pr.getOne(l.getPostID) (pseudocode)
		Post p = pr.getOne(l.getPostId());
		
		// change post likes value based by the value from the like
		if (l.getLikeValue())
		{
			p.setPost_likes(p.getPost_likes() + 1);
		}
		else
		{
			p.setPost_likes(p.getPost_likes() - 1);
		}
		
		//Clark: do we need to do pr.save(p)?
		
		return p;
		
	}

}
