package com.fwd.ws.request;

import java.util.Date;

public class ContentRequest {
	
	private String contentName; 
	
	private String imageUrl; 
	
	private int newsId; 
	
	private String passionCode;
	
	private Date createDate; 
	
	private String createUserId;
	
	private Date updateDate;
	
	private String updateUserId;

	public String getContentName() {
		return contentName;
	}

	public void setContentName(String contentName) {
		this.contentName = contentName;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getNewsId() {
		return newsId;
	}

	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}

	public String getPassionCode() {
		return passionCode;
	}

	public void setPassionCode(String passionCode) {
		this.passionCode = passionCode;
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
