package com.fwd.ws.response;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fwd.model.passion.Member;

@XmlRootElement
public class MemberResponse  extends WebServiceResponse{
	
	private List<Member> memberList;
	
	public List<Member> getMemberList() {
		return memberList;
	}
	public void setMemberList(List<Member> memberList) {
		this.memberList = memberList;
	}
	
		
}
