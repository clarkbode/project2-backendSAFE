package com.revature.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.CommentLike;

public interface CommentLikeRepo extends JpaRepository<CommentLike, Integer>{

}
