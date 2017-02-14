package com.fwd.model.passion;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="hs_history")
public class History {

	@Id
	@GenericGenerator(name="generator", strategy="increment")
	@GeneratedValue(generator="generator")
	@Column(name="hist_id", length=100 , nullable=true)
	private Long histId;
	
	@Column(name="descriptiion", columnDefinition="nvarchar(255)", nullable=true)
	private String descriptiion; 
	
	@Column(name="start_point", columnDefinition="int", nullable=true)
	private int startPoint; 
	
	@Column(name="collect_point", columnDefinition="int", nullable=true)
	private int collectPoint; 
	
	@Column(name="point_use", columnDefinition = "int", nullable=true)
	private int pointUse;
	
	@Column(name="last_point", columnDefinition="int", nullable=true)
	private int lastPoint; 
	
	@Column(name="create_date", columnDefinition = "datetime", nullable=true)
	private Date createDate;
	
	@Column(name="create_user_id", columnDefinition="nvarchar(255)", nullable=true)
	private String createUserId; 
	
	@Column(name="update_date", columnDefinition = "datetime", nullable=true)
	private Date updateDate;
	
	@Column(name="update_user_id", columnDefinition="nvarchar(255)", nullable=true)
	private String updateUserId;

	public History() {
		this.descriptiion = null;
		this.startPoint = 0;
		this.collectPoint = 0;
		this.pointUse = 0;
		this.lastPoint = 0;
		this.createDate = null;
		this.createUserId = null;
		this.updateDate = null;
		this.updateUserId = null;
	}

	public Long getHistId() {
		return histId;
	}

	public void setHistId(Long histId) {
		this.histId = histId;
	}

	public String getDescriptiion() {
		return descriptiion;
	}

	public void setDescriptiion(String descriptiion) {
		this.descriptiion = descriptiion;
	}

	public int getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(int startPoint) {
		this.startPoint = startPoint;
	}

	public int getCollectPoint() {
		return collectPoint;
	}

	public void setCollectPoint(int collectPoint) {
		this.collectPoint = collectPoint;
	}

	public int getPointUse() {
		return pointUse;
	}

	public void setPointUse(int pointUse) {
		this.pointUse = pointUse;
	}

	public int getLastPoint() {
		return lastPoint;
	}

	public void setLastPoint(int lastPoint) {
		this.lastPoint = lastPoint;
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