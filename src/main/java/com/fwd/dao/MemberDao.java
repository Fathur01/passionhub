package com.fwd.dao;

import java.util.List;

import com.fwd.model.passion.Member;

public interface MemberDao {
	List<Member> getAllMember();
	Member save(Member member);
}
