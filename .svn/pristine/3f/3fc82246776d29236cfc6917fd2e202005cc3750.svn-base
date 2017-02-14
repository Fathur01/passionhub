package com.fwd.model.passion;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ms_point")
public class TPoint {

	@Id
	@GeneratedValue
	private long id;
	
	@ManyToOne
    @JoinColumn(name="ms_point_id", referencedColumnName="point",  insertable=false, updatable=false)
	private TrPoint msPointId;
	
	@ManyToOne
    @JoinColumn(name="activity_id", referencedColumnName="activity_id",  insertable=false, updatable=false)
	private Activity activityId; 
	
	@Column(name="point", columnDefinition="int", nullable=true)
	private int point; 
	
	@Column(name="create_date", columnDefinition="datetime", nullable=true)
	private Date createDate; 
	
	@Column(name="create_user_id", columnDefinition = "nvarchar(50)", nullable=true)
	private String createUserId;
	
	@Column(name="update_date", columnDefinition="datetime", nullable=true)
	private Date updateDate; 
	
	@Column(name="update_user_id", columnDefinition = "nvarchar(50)", nullable=true)
	private String updateUserId;

	public TPoint() {
		this.msPointId = null;
		this.activityId = null;
		this.point = 0;
		this.createDate = null;
		this.createUserId = null;
		this.updateDate = null;
		this.updateUserId = null;
	}

	public TrPoint getMsPointId() {
		return msPointId;
	}

	public void setMsPointId(TrPoint msPointId) {
		this.msPointId = msPointId;
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