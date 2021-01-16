package com.ubisoft.webapp.service;

import java.util.List;

import com.ubisoft.webapp.entites.UserEntity;
import com.ubisoft.webapp.model.Item;

public interface UserService {

	List<Item> getUserItems(String userName);

	List<UserEntity> getUsers();

}
