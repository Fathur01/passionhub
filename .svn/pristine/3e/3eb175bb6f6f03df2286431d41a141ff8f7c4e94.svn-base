package com.fwd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fwd.dao.UserDao;
import com.fwd.model.passion.Users;
import com.fwd.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UserDao usersDao;

	@Override
	@Transactional(value = "transactionManager", readOnly = true)
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return usersDao.getAllUser();
	}
	
	@Override
	@Transactional(value = "transactionManager", readOnly = false)
	public Users saveUsers(Users users) {
		// TODO Auto-generated method stub
		return usersDao.save(users);
	}
}
