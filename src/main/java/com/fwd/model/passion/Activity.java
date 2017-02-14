package com.fwd.model.passion;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="ms_activity")
public class Activity {

	@Id
	@GenericGenerator(name="generator", strategy="increment")
	@GeneratedValue(generator="generator")
	@Column(name="activity_id", length=100 , nullable=false)
	private Long activityId;
	
	@Column(name="activity_desc", columnDefinition="nvarchar(255)", nullable=true)
	private String activityDesc; 
	
	@Column(name="create_user_id", columnDefinition="nvarchar(255)", nullable=true)
	private String createUserId; 
	
	@Column(name="create_date", columnDefinition="datetime", nullable=true)
	private Date createDate; 
	
	@Column(name="update_user_id", columnDefinition = "nvarchar(255)", nullable=true)
	private String updateUserId;
	
	@Column(name="update_date", columnDefinition="datetime", nullable=true)
	private Date updateDate;

	
	public Activity() {
		this.activityDesc = null;
		this.createUserId = null;
		this.createDate = null;
		this.updateUserId = null;
		this.updateDate = null;
	}

	public Long getActivityId() {
		return activityId;
	}

	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}

	public String getActivityDesc() {
		return activityDesc;
	}

	public void setActivityDesc(String activityDesc) {
		this.activityDesc = activityDesc;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	} 
	
	
	
}