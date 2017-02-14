package com.fwd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fwd.dao.ActivityDao;
import com.fwd.model.passion.Activity;
import com.fwd.service.ActivityService;

@Service
public class ActivityServiceImpl implements ActivityService {

	@Autowired
	private ActivityDao activityDao;

	@Override
	@Transactional(value = "transactionManager", readOnly = true)
	public List<Activity> getAllActivity() {
		// TODO Auto-generated method stub
		return activityDao.getAllActivity();
	}
	
	@Override
	@Transactional(value = "transactionManager", readOnly = false)
	public Activity saveActivity(Activity activity) {
		// TODO Auto-generated method stub
		return activityDao.save(activity);
	}
}
