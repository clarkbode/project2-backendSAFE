package com.revature.repos;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.models.Friend;

@Repository
public interface FriendRepo extends JpaRepository<Friend, Integer>{

	@Query("FROM Friend f WHERE f.friendId.userId = :uId")
	ArrayList<Friend> getByUserId(@Param("uId") int id);
	
	
}
