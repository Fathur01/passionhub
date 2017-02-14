package com.fwd.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.fwd.dao.MemberDao;
import com.fwd.dao.TrPointDao;
import com.fwd.model.passion.Member;
import com.fwd.model.passion.TrPoint;

@Repository
public class TrPointDaoImpl extends AbstractDao implements TrPointDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<TrPoint> getAllTrPoint() {
		
		System.out.println("TrPointDao.getAllTrPoint start");

		Criteria trPointCrit = session().createCriteria(TrPoint.class);
		
		List<TrPoint> list = trPointCrit.list();

		System.out.println("TrPointDao.getAllTrPoint end");
		return list;
	}
	
	@Override
	public TrPoint save(TrPoint trPoint) {
		try{
			return (TrPoint)session().merge(trPoint);
		}catch (Exception e) {
			return new TrPoint();
		}
		
	}

}
