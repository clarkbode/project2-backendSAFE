package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Comment;
import com.revature.models.CommentLike;
import com.revature.models.Post;
import com.revature.models.PostLike;
import com.revature.services.CommentService;

@RestController
@RequestMapping(path = "comment")
public class CommentController {

	@Autowired
	private CommentService cs;
	
	@GetMapping
	public List<Comment> findAll() {
		return cs.findAll();
	}
	
	@GetMapping("{id}")
	public Comment findById(@PathVariable int id) {
		return cs.findById(id);
	}
	
	@GetMapping("/findByPost/id/{id}")
	public List<Comment> findByPostId(@PathVariable int id){
		return cs.findByPostId(id);
	}
	
	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Comment save(Comment c) {
		return cs.save(c);
	}
	
	@PostMapping("/like")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Comment like(@RequestBody CommentLike l) { // Clark: I think this is right?
		return cs.like(l);
	}
	
}
