package com.ubisoft.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ubisoft.task.entities.User;
import com.ubisoft.task.repositories.UserRepository;

@RestController
@RequestMapping("/TestDevWebService/services")
public class UserController {
	@Autowired
	private UserRepository userRepository;

	@GetMapping(value="/user/{username}",  produces=MediaType.APPLICATION_XML_VALUE )
	public ResponseEntity<User> getUserByUsername(@PathVariable String username){
		User user = userRepository.findByUsername(username);
        return new ResponseEntity<>(user, HttpStatus.OK);
	}
	

}
