package com.fwd.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.fwd.dao.MemberDao;
import com.fwd.model.passion.Member;

@Repository
public class MemberDaoImpl extends AbstractDao implements MemberDao {


//	@SuppressWarnings("unchecked")
	@SuppressWarnings("unchecked")
	@Override
	public List<Member> getAllMember() {
		
		System.out.println("MemberDao.getAllMember start");

		Criteria memberCrit = session().createCriteria(Member.class);
		
		List<Member> list = memberCrit.list();

		System.out.println("MemberDao.getAllMember end");
		return list;
	}
	
	@Override
	public Member save(Member member) {
		try{
			return (Member)session().merge(member);
		}catch (Exception e) {
			return new Member();
		}
		
	}

}
