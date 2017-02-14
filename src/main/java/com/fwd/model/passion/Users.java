package com.fwd.model.passion;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="ms_users")
public class Users {

	@Id
	@GenericGenerator(name="generator", strategy="increment")
	@GeneratedValue(generator="generator")
	@Column(name="id", length=100 , nullable=true)
	private Long id;
	
	@Column(name="user_id", columnDefinition="nvarchar(10)", nullable=true)
	private String userId; 
	
	@Column(name="role_code", columnDefinition="nvarchar(50)", nullable=true)
	private String roleCode; 
	
	@Column(name="status", columnDefinition="nvarchar(50)", nullable=true)
	private String status; 
	
	@Column(name="update_date", columnDefinition = "datetime", nullable=true)
	private Date updateDate;
	
	@Column(name="update_user_id", columnDefinition="nvarchar(50)", nullable=true)
	private String updateUserId; 
	
	@Column(name="create_date", columnDefinition = "datetime", nullable=true)
	private Date createDate;
	
	@Column(name="create_user_id", columnDefinition="nvarchar(50)", nullable=true)
	private String createUserId;

	public Users() {
		this.userId = null;
		this.roleCode = null;
		this.status = null;
		this.updateDate = null;
		this.updateUserId = null;
		this.createDate = null;
		this.createUserId = null;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
	
}