package com.fwd.ws.request;

import java.util.Date;

public class HistoryRequest {
	private String descriptiion; 
	
	private int startPoint; 
	
	private int collectPoint; 
	
	private int pointUse;
	
	private int lastPoint; 
	
	private Date createDate;
	
	private String createUserId; 
	
	private Date updateDate;
	
	private String updateUserId;

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
