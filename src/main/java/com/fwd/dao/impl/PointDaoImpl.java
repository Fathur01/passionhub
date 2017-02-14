package com.fwd.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.fwd.dao.MemberDao;
import com.fwd.dao.PointDao;
import com.fwd.model.passion.Member;
import com.fwd.model.passion.TPoint;

@Repository
public class PointDaoImpl extends AbstractDao implements PointDao {


//	@SuppressWarnings("unchecked")
	@SuppressWarnings("unchecked")
	@Override
	public List<TPoint> getAllPoint() {
		
		System.out.println("PointDao.getAllPoint start");

		Criteria pointCrit = session().createCriteria(TPoint.class);
		
		List<TPoint> list = pointCrit.list();

		System.out.println("PointDao.getAllPoint end");
		return list;
	}
	
	@Override
	public TPoint save(TPoint point) {
		try{
			return (TPoint)session().merge(point);
		}catch (Exception e) {
			return new TPoint();
		}
		
	}

}
