package com.fwd.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.fwd.dao.MemberDao;
import com.fwd.dao.UserDao;
import com.fwd.model.passion.Users;

@Repository
public class UserDaoImpl extends AbstractDao implements UserDao {


	@SuppressWarnings("unchecked")
	@Override
	public List<Users> getAllUser() {
		
		System.out.println("UserDao.getAllUser start");

		Criteria userCrit = session().createCriteria(Users.class);
		
		List<Users> list = userCrit.list();

		System.out.println("UserDao.getAllUser end");
		return list;
	}
	
	@Override
	public Users save(Users user) {
		try{
			return (Users)session().merge(user);
		}catch (Exception e) {
			return new Users();
		}
		
	}

}
