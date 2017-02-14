package com.fwd.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.fwd.dao.HistoryDao;
import com.fwd.dao.MemberDao;
import com.fwd.model.passion.History;
import com.fwd.model.passion.Member;

@Repository
public class HistoryDaoImpl extends AbstractDao implements HistoryDao {


//	@SuppressWarnings("unchecked")
	@SuppressWarnings("unchecked")
	@Override
	public List<History> getAllHistory() {
		
		System.out.println("HistoryDao.getAllHistory start");

		Criteria historyCrit = session().createCriteria(History.class);
		
		List<History> list = historyCrit.list();

		System.out.println("HistoryDao.getAllHistory end");
		return list;
	}
	
	@Override
	public History save(History history) {
		try{
			return (History)session().merge(history);
		}catch (Exception e) {
			return new History();
		}
		
	}

}
