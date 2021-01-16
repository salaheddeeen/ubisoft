package com.ubisoft.webapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ubisoft.webapp.entites.UserEntity;
import com.ubisoft.webapp.service.UserService;

@Controller("/user")
public class UsersController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/users/{username}/items")
	public String showUserItems (Model model,@PathVariable String username) {
	    model.addAttribute("items", userService.getUserItems(username));
		return "item";
	}
	
	@GetMapping("/users")
	public String showUsers (Model model) {
		List<UserEntity> users = userService.getUsers();
	    model.addAttribute("users",users );
		return "users";
	}
	
	
}
