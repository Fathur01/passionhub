package com.fwd.service;

import java.util.List;

import com.fwd.model.passion.Users;

public interface UsersService {
	
	public List<Users> getAllUsers();	
	public Users saveUsers(Users Users);	
}
