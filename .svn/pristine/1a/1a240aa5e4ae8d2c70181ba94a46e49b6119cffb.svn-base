package com.fwd.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.fwd.dao.BalanceDao;
import com.fwd.dao.MemberDao;
import com.fwd.model.passion.Member;
import com.fwd.model.passion.TrBalance;

@Repository
public class BalanceDaoImpl extends AbstractDao implements BalanceDao {


	@SuppressWarnings("unchecked")
	@Override
	public List<TrBalance> getAllTrBalance() {
		
		System.out.println("TrBalanceDao.getAllTrBalance start");

		Criteria trBalanceCrit = session().createCriteria(TrBalance.class);
		
		List<TrBalance> list = trBalanceCrit.list();

		System.out.println("TrBalanceDao.getAllTrBalance end");
		return list;
	}
	
	@Override
	public TrBalance save(TrBalance trBalance) {
		try{
			return (TrBalance)session().merge(trBalance);
		}catch (Exception e) {
			return new TrBalance();
		}
		
	}

}
