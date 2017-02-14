package com.fwd.model.passion;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="ms_member")
public class Member {

	@Id
	@GenericGenerator(name="generator", strategy="increment")
	@GeneratedValue(generator="generator")
	@Column(name="card_num", length=100 , nullable=false)
	private Long cardNum;
	
	@Column(name="firstname", columnDefinition="nvarchar(50)", nullable=true)
	private String firstName; 
	
	@Column(name="middlename", columnDefinition="nvarchar(50)", nullable=true)
	private String middleName; 
	
	@Column(name="lastname", columnDefinition="nvarchar(50)", nullable=true)
	private String lastName; 
	
	@Column(name="survey_date", columnDefinition = "datetime", nullable=true)
	private Date surveyDate;
	
	@Column(name="email", columnDefinition="nvarchar(100)", nullable=true)
	private String email; 
	
	@Column(name="address", columnDefinition = "nvarchar(100)", nullable=true)
	private String address;
	
	@Column(name="mobile_no", columnDefinition="int", nullable=true)
	private int mobileNo; 
	
	@Column(name="entry_date", columnDefinition="datetime", nullable=true)
	private Date entryDate; 
	
	@Column(name="DOB", columnDefinition="datetime", nullable=true)
	private Date dOB; 
	
	@Column(name="is_policy_holder", columnDefinition = "nvarchar(1)", nullable=true)
	private String isPolicyHolder;
	
	@Column(name="is_employee", columnDefinition="nvarchar(1)", nullable=true)
	private String isEmployee; 
	
	@Column(name="is_agent", columnDefinition = "nvarchar(1)", nullable=true)
	private String isAgent;
	
	@Column(name="group_code", columnDefinition="nvarchar(100)", nullable=true)
	private String groupCode; 
	
	@Column(name="is_corp_care", columnDefinition="nvarchar(1)", nullable=true)
	private String isCorpCare; 
	
	@Column(name="client_code", columnDefinition="nvarchar(50)", nullable=true)
	private String clientCode; 
	
	@Column(name="agent_code", columnDefinition = "nvarchar(50)", nullable=true)
	private String agentCode;
	
	@Column(name="member_status", columnDefinition="nvarchar(50)", nullable=true)
	private String memberStatus;
	
	@Column(name="userid_fk",nullable=true)
	private int useridFk;
	
/*	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="userid_fk", referencedColumnName="user_id")
	private Users useridFk;*/
	
	@Column(name="password", columnDefinition="nvarchar(50)", nullable=true)
	private String password;

	public Member() {
		this.firstName = null;
		this.middleName = null;
		this.lastName = null;
		this.surveyDate = null;
		this.email = null;
		this.address = null;
		this.mobileNo = 0;
		this.entryDate = null;
		this.dOB = null;
		this.isPolicyHolder = null;
		this.isEmployee = null;
		this.isAgent = null;
		this.groupCode = null;
		this.isCorpCare = null;
		this.clientCode = null;
		this.agentCode = null;
		this.memberStatus = null;
		this.useridFk = 0;
		this.password = null;
	}

	public Long getCardNum() {
		return cardNum;
	}

	public void setCardNum(Long cardNum) {
		this.cardNum = cardNum;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getSurveyDate() {
		return surveyDate;
	}

	public void setSurveyDate(Date surveyDate) {
		this.surveyDate = surveyDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(int mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public Date getDOB() {
		return dOB;
	}

	public void setDOB(Date dOB) {
		this.dOB = dOB;
	}

	public String getIsPolicyHolder() {
		return isPolicyHolder;
	}

	public void setIsPolicyHolder(String isPolicyHolder) {
		this.isPolicyHolder = isPolicyHolder;
	}

	public String getIsEmployee() {
		return isEmployee;
	}

	public void setIsEmployee(String isEmployee) {
		this.isEmployee = isEmployee;
	}

	public String getIsAgent() {
		return isAgent;
	}

	public void setIsAgent(String isAgent) {
		this.isAgent = isAgent;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public String getIsCorpCare() {
		return isCorpCare;
	}

	public void setIsCorpCare(String isCorpCare) {
		this.isCorpCare = isCorpCare;
	}

	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	public String getAgentCode() {
		return agentCode;
	}

	public void setAgentCode(String agentCode) {
		this.agentCode = agentCode;
	}

	public String getMemberStatus() {
		return memberStatus;
	}

	public void setMemberStatus(String memberStatus) {
		this.memberStatus = memberStatus;
	}

	public int getUseridFk() {
		return useridFk;
	}

	public void setUseridFk(int useridFk) {
		this.useridFk = useridFk;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	} 
		
}