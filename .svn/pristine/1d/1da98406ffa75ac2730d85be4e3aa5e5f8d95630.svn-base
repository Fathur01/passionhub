package com.fwd.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.fwd.dao.MemberDao;
import com.fwd.dao.PassionDao;
import com.fwd.model.passion.Member;
import com.fwd.model.passion.TPassion;

@Repository
public class PassionDaoImpl extends AbstractDao implements PassionDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<TPassion> getAllPassion() {
		
		System.out.println("PassionDao.getAllPassion start");

		Criteria passionCrit = session().createCriteria(TPassion.class);
		
		List<TPassion> list = passionCrit.list();

		System.out.println("PassionDao.getAllPassion end");
		return list;
	}
	
	@Override
	public TPassion save(TPassion passion) {
		try{
			return (TPassion)session().merge(passion);
		}catch (Exception e) {
			return new TPassion();
		}
		
	}

}
