package com.revature.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.PostLike;

public interface PostLikeRepo extends JpaRepository<PostLike, Integer> {

}
