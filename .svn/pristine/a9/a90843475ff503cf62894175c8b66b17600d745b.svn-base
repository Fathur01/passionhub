package com.fwd.model.passion;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="tr_point")
public class TrPoint {

	@Id
	@GenericGenerator(name="generator", strategy="increment")
	@GeneratedValue(generator="generator")
	@Column(name="point_id", length=100 , nullable=true)
	private Long pointId;
	
	@ManyToOne
    @JoinColumn(name="activity_id", referencedColumnName="activity_id",  insertable=false, updatable=false)
	private Activity activityId; 
	
	@Column(name="point", columnDefinition="int", nullable=true)
	private int point; 
	
	@Column(name="activity_date", columnDefinition="datetime", nullable=true)
	private Date activityDate; 
	
	@Column(name="create_date", columnDefinition = "datetime", nullable=true)
	private Date createDate;
	
	@Column(name="create_user_id", columnDefinition="nvarchar(50)", nullable=true)
	private String createUserId; 
	
	@Column(name="update_date", columnDefinition = "datetime", nullable=true)
	private Date updateDate;
	
	@Column(name="update_user_id", columnDefinition="nvarchar(50)", nullable=true)
	private String updateUserId;

	public TrPoint() {
		this.activityId = null;
		this.point = 0;
		this.activityDate = null;
		this.createDate = null;
		this.createUserId = null;
		this.updateDate = null;
		this.updateUserId = null;
	}

	public Long getPointId() {
		return pointId;
	}

	public void setPointId(Long pointId) {
		this.pointId = pointId;
	}

	public Activity getActivityId() {
		return activityId;
	}

	public void setActivityId(Activity activityId) {
		this.activityId = activityId;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public Date getActivityDate() {
		return activityDate;
	}

	public void setActivityDate(Date activityDate) {
		this.activityDate = activityDate;
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