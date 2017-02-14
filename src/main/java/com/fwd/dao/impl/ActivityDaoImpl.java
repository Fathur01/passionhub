package com.fwd.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.fwd.dao.ActivityDao;
import com.fwd.model.passion.Activity;

@Repository
public class ActivityDaoImpl extends AbstractDao implements ActivityDao {


	@SuppressWarnings("unchecked")
	@Override
	public List<Activity> getAllActivity() {
		
		System.out.println("ActivityDao.getAllActivity start");

		Criteria activityCrit = session().createCriteria(Activity.class);
		
		List<Activity> list = activityCrit.list();

		System.out.println("ActivityDao.getAllActivity end");
		return list;
	}
	
	@Override
	public Activity save(Activity activity) {
		try{
			return (Activity)session().merge(activity);
		}catch (Exception e) {
			return new Activity();
		}
		
	}

}
