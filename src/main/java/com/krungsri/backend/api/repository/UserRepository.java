package com.krungsri.backend.api.repository;

import com.krungsri.backend.api.model.UserModel;

public interface UserRepository {
	
	UserModel save(UserModel user);
	
	UserModel findByUserId(int userId);
	
}
