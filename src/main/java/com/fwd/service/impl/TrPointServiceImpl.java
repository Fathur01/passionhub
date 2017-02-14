package com.fwd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fwd.dao.TrPointDao;
import com.fwd.model.passion.TrPoint;
import com.fwd.service.TrPointService;

@Service
public class TrPointServiceImpl implements TrPointService {

	@Autowired
	private TrPointDao trPointDao;

	@Override
	@Transactional(value = "transactionManager", readOnly = true)
	public List<TrPoint> getAllTrPoint() {
		// TODO Auto-generated method stub
		return trPointDao.getAllTrPoint();
	}
	
	@Override
	@Transactional(value = "transactionManager", readOnly = false)
	public TrPoint saveTrPoint(TrPoint trPoint) {
		// TODO Auto-generated method stub
		return trPointDao.save(trPoint);
	}
}
