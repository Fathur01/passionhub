package com.fwd.service;

import java.util.List;

import com.fwd.model.passion.Member;

public interface MemberService {
	
	public List<Member> getAllMember();	
	public Member saveMember(Member member);	
}
