package com.example.service;

import com.example.entity.User;

public interface UserService {
	
	public User readByLoginName(String name);
}
