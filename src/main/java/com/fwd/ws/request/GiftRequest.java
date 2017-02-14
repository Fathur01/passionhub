package com.fwd.ws.request;

import java.util.Date;

public class GiftRequest {
	private String giftName; 
	
	private String giftDesc; 
	
	private int point; 
	
	private Date createDate;
	
	private String createUserId;
	
	private Date updateDate; 
	
	private String updateUserId;

	public String getGiftName() {
		return giftName;
	}

	public void setGiftName(String giftName) {
		this.giftName = giftName;
	}

	public String getGiftDesc() {
		return giftDesc;
	}

	public void setGiftDesc(String giftDesc) {
		this.giftDesc = giftDesc;
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
