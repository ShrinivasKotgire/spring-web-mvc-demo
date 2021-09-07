package com.example.mvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.mvc.models.User;
import com.example.mvc.services.UserService;
import com.example.mvc.views.JsonView.AdminView;
import com.example.mvc.views.JsonView.UserView;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	@JsonView(AdminView.class)
	List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/getById")
	User getUserById(@RequestParam("id") Integer id){
		return userService.getUserByID(id);
	}
	
	@GetMapping("/getByName")
	User getUserByName(@RequestParam("name") String name){
		return userService.getUserByName(name);
	}
	
	@GetMapping("/getByNameAndName")
	User getUserByName(@RequestParam("name") String name, @RequestParam Integer id){
		return userService.getUserByNameAndId(name,id);
	}
	

}