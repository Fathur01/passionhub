package com.fwd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fwd.dao.PassionDao;
import com.fwd.model.passion.TPassion;
import com.fwd.service.PassionService;

@Service
public class PassionServiceImpl implements PassionService {

	@Autowired
	private PassionDao passionDao;

	@Override
	@Transactional(value = "transactionManager", readOnly = true)
	public List<TPassion> getAllPassion() {
		// TODO Auto-generated method stub
		return passionDao.getAllPassion();
	}
	
	@Override
	@Transactional(value = "transactionManager", readOnly = false)
	public TPassion savePassion(TPassion passion) {
		// TODO Auto-generated method stub
		return passionDao.save(passion);
	}
}
