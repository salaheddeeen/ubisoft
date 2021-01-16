package com.ubisoft.webapp.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ubisoft.webapp.entites.UserEntity;
import com.ubisoft.webapp.model.Item;
import com.ubisoft.webapp.model.User;
import com.ubisoft.webapp.repositories.UserRepository;
import com.ubisoft.webapp.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	public final String USER_ITEMS_WS = "http://webservice:8080/TestDevWebService/services/user/";
	
	private RestTemplate restTemplate;
	
	@Autowired 
	private UserRepository userRepository;
	
	@Override
	public List<Item> getUserItems(String userName){
		UserDetails loggedInUser = getCurrentLoggedInUser();
		if(hasAdminRole(loggedInUser)||loggedInUser.getUsername().equals(userName)) {
	        User user =restTemplate.getForObject(USER_ITEMS_WS+userName+"/", User.class);
	        return user!=null ? user.getItems(): Collections.emptyList();
		}
        return Collections.emptyList();
	}


	
	@Override
	public List<UserEntity> getUsers(){
		UserDetails loggedInUser = getCurrentLoggedInUser();
		if(hasAdminRole(loggedInUser)) {
			return userRepository.findAll();
		}else {
			List<UserEntity> users =  new ArrayList<UserEntity>();
			users.add(userRepository.findByUsername(loggedInUser.getUsername()));
			return users;
		}
	
	}
	
	private UserDetails getCurrentLoggedInUser() {
		return (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}
	
	private boolean hasAdminRole(UserDetails user) {
		AtomicBoolean  isAdmin = new AtomicBoolean();
		user.getAuthorities().forEach(role->{
			if(role.getAuthority().equalsIgnoreCase("Admin")) isAdmin.set(true);
		});
		
		return isAdmin.get();
	}
	
	public UserServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }
	
}
