package com.fwd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fwd.dao.PointDao;
import com.fwd.model.passion.TPoint;
import com.fwd.service.PointService;

@Service
public class PointServiceImpl implements PointService {

	@Autowired
	private PointDao pointDao;

	@Override
	@Transactional(value = "transactionManager", readOnly = true)
	public List<TPoint> getAllPoint() {
		// TODO Auto-generated method stub
		return pointDao.getAllPoint();
	}
	
	@Override
	@Transactional(value = "transactionManager", readOnly = false)
	public TPoint savePoint(TPoint point) {
		// TODO Auto-generated method stub
		return pointDao.save(point);
	}
}
