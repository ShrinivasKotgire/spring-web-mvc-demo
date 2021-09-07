package com.example.mvc.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mvc.models.User;

public interface UserReop extends JpaRepository<User, Integer>{
	
	User findByName(String name);
	
	User findByNameAndId(String name, Integer id);

}
