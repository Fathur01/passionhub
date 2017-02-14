package com.fwd.model.passion;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="ms_passion")
public class TPassion {

	@Id
	@GenericGenerator(name="generator", strategy="increment")
	@GeneratedValue(generator="generator")
	@Column(name="id", length=100 , nullable=false)
	private long id;
	
	@Column(name="passion_code", columnDefinition="nvarchar(50)" , nullable=true)
	private String passionCode;
	
	@Column(name="passion_desc", columnDefinition="nvarchar(50)", nullable=true)
	private String passionDesc; 
	
	@Column(name="passion_type", columnDefinition="nvarchar(50)", nullable=true)
	private String passionType; 
	
	@Column(name="create_date", columnDefinition="datetime", nullable=true)
	private Date createDate; 
	
	@Column(name="create_user_id", columnDefinition = "nvarchar(50)", nullable=true)
	private String createUserId;
	
	@Column(name="update_date", columnDefinition="datetime", nullable=true)
	private Date updateDate; 
	
	@Column(name="update_user_id", columnDefinition = "nvarchar(50)", nullable=true)
	private String updateUserId;
	
	public TPassion() {
		this.passionCode = null;
		this.passionDesc = null;
		this.passionType = null;
		this.createDate = null;
		this.createUserId = null;
		this.updateDate = null;
		this.updateUserId = null;
	}

	public String getPassionCode() {
		return passionCode;
	}

	public void setPassionCode(String passionCode) {
		this.passionCode = passionCode;
	}

	public String getPassionDesc() {
		return passionDesc;
	}

	public void setPassionDesc(String passionDesc) {
		this.passionDesc = passionDesc;
	}

	public String getPassionType() {
		return passionType;
	}

	public void setPassionType(String passionType) {
		this.passionType = passionType;
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