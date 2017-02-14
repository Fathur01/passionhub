package com.fwd.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.fwd.dao.GiftDao;
import com.fwd.dao.MemberDao;
import com.fwd.model.passion.Gift;
import com.fwd.model.passion.Member;

@Repository
public class GiftDaoImpl extends AbstractDao implements GiftDao {


//	@SuppressWarnings("unchecked")
	@SuppressWarnings("unchecked")
	@Override
	public List<Gift> getAllGift() {
		
		System.out.println("GiftDao.getAllGift start");

		Criteria giftCrit = session().createCriteria(Gift.class);
		
		List<Gift> list = giftCrit.list();

		System.out.println("GiftDao.getAllGift end");
		return list;
	}
	
	@Override
	public Gift save(Gift gift) {
		try{
			return (Gift)session().merge(gift);
		}catch (Exception e) {
			return new Gift();
		}
		
	}

}
