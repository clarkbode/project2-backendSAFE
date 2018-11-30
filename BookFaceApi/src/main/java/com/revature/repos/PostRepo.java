package com.revature.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.models.Post;

@Repository
public interface PostRepo extends JpaRepository<Post, Integer> {
	
	//Post merge(Post p); //Clark: Not sure if this works like this
	@Query("FROM Post p WHERE p.authorId = :uid")
	List<Post> findByUser(@Param("uid")int id);

}
