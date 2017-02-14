package com.fwd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fwd.dao.MemberDao;
import com.fwd.model.passion.Member;
import com.fwd.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao memberDao;

	@Override
	@Transactional(value = "transactionManager", readOnly = true)
	public List<Member> getAllMember() {
		// TODO Auto-generated method stub
		return memberDao.getAllMember();
	}
	
	@Override
	@Transactional(value = "transactionManager", readOnly = false)
	public Member saveMember(Member member) {
		// TODO Auto-generated method stub
		return memberDao.save(member);
	}
}
