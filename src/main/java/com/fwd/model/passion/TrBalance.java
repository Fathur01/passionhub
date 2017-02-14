package com.fwd.model.passion;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="tr_balance")
public class TrBalance {

	@Id
	@GenericGenerator(name="generator", strategy="increment")
	@GeneratedValue(generator="generator")
	@Column(name="balance_id", length=100 , nullable=true)
	private Long balanceId;
	
	@Column(name="balance", columnDefinition="int", nullable=true)
	private int balance; 
	
	@Column(name="create_date", columnDefinition="datetime", nullable=true)
	private Date createDate; 
	
	@Column(name="create_user_id", columnDefinition="nvarchar(50)", nullable=true)
	private String createUserId; 
	
	@Column(name="update_date", columnDefinition = "datetime", nullable=true)
	private Date updateDate;
	
	@Column(name="update_user_id", columnDefinition="nvarchar(50)", nullable=true)
	private String updateUserId;	
	
	public TrBalance() {
		this.balance = 0;
		this.createDate = null;
		this.createUserId = null;
		this.updateDate = null;
		this.updateUserId = null;
	}

	public Long getBalanceId() {
		return balanceId;
	}

	public void setBalanceId(Long balanceId) {
		this.balanceId = balanceId;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	} 
		
}