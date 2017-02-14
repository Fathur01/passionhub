package com.fwd.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.fwd.dao.MemberDao;
import com.fwd.dao.TrRedeemDao;
import com.fwd.model.passion.Member;
import com.fwd.model.passion.TrRedeem;

@Repository
public class TrRedeemDaoImpl extends AbstractDao implements TrRedeemDao {


//	@SuppressWarnings("unchecked")
	@SuppressWarnings("unchecked")
	@Override
	public List<TrRedeem> getAllTrRedeem() {
		
		System.out.println("TrRedeemDao.getAllTrRedeem start");

		Criteria trRedeemCrit = session().createCriteria(TrRedeem.class);
		
		List<TrRedeem> list = trRedeemCrit.list();

		System.out.println("TrRedeemDao.getAllTrRedeem end");
		return list;
	}
	
	@Override
	public TrRedeem save(TrRedeem trRedeem) {
		try{
			return (TrRedeem)session().merge(trRedeem);
		}catch (Exception e) {
			return new TrRedeem();
		}
		
	}

}
