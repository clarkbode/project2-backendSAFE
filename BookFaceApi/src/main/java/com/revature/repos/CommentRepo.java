package com.revature.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.revature.models.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer>{

	@Query("FROM Comment c WHERE c.postId = :pId")
	List<Comment> findByPostId(@Param("pId") int id);

}
