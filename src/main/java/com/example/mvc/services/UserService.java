package com.example.mvc.services;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mvc.models.User;
import com.example.mvc.respository.UserReop;

@Service
public class UserService {

	@Autowired
	UserReop userReop;
	
	@PostConstruct
	private void saveData() {
		userReop.save(new User(1,"shrinivas","sk@gmail.com","Pass"));
		userReop.save(new User(2,"sagar","sp@gmail.com","Pass"));
		userReop.save(new User(3,"rohit","rc@gmail.com","Pass"));
	}
	
	public List<User> getAllUsers(){
		return userReop.findAll();
	}
	
	public User getUserByID(Integer id) {
		return userReop.findById(id).orElse(null);
	}
	
	public User getUserByName(String name) {
		return userReop.findByName(name);
	}
	
	public User getUserByNameAndId(String name, Integer id) {
		return userReop.findByNameAndId(name,id);
	}

}
