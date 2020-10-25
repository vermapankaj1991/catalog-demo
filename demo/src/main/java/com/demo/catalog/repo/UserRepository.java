package com.demo.catalog.repo;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.demo.catalog.domain.User;

@Repository
public class UserRepository {
	public static List<User> users = new ArrayList<>();
	
	@PostConstruct
	public void init(){
		users.add(new User(1, "Demo User 1"));
		users.add(new User(2, "Demo User 2"));
	}

	/**
	 * Get User information by user id
	 * @param userId
	 * @return
	 */
	public User getUserById(Integer userId){
		return users.stream().filter(user -> user.getUserId() == userId).findFirst().orElse(null);	
	}

	/**
	 * Persist user in database
	 * @param user
	 */
	public void saveUser(User user) {
		users.add(user);		
	}
}
