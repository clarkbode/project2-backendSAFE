package com.revature.repos;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//import com.revature.dto.Credential;
//import com.revature.models.Post;

import com.revature.models.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

	@Query("FROM User u WHERE u.userUsername = :un AND u.userPassword = :up") //This is probably wrong
	User findByCredentials(@Param("un") String username, @Param("up") String password);
}
