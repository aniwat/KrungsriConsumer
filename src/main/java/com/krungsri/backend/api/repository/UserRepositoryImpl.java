package com.krungsri.backend.api.repository;

import java.util.Date;
import java.util.HashMap;

import com.krungsri.backend.api.model.UserModel;

public class UserRepositoryImpl implements UserRepository {
	
	// Simulate insert data in SQL database
	private int id;
	private HashMap<Integer, UserModel> map;
	
	public UserRepositoryImpl() {
		this.id = 1;
		this.map = new HashMap<Integer, UserModel>();
	}
	
	@Override
	public UserModel save(UserModel user) {
		user.setUserId(id++);
		map.put(user.getUserId(), user);
		return map.get(user.getUserId());
	}
	
	@Override
	public UserModel findByUserId(int userId) {
		return map.get(userId);
	}
	
}
