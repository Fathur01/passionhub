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
@Table(name="ms_content")
public class Content {

	@Id
	@GenericGenerator(name="generator", strategy="increment")
	@GeneratedValue(generator="generator")
	@Column(name="content_id", length=100 , nullable=true)
	private Long contentId;
	
	@Column(name="content_name", columnDefinition="nvarchar(255)", nullable=true)
	private String contentName; 
	
	@Column(name="image_url", columnDefinition="nvarchar(255)", nullable=true)
	private String imageUrl; 
	
	@ManyToOne
    @JoinColumn(name="news_id", referencedColumnName="news_id",  insertable=false, updatable=false)
	private News newsId;
	
	@ManyToOne
    @JoinColumn(name="passion_code", referencedColumnName="passion_code",  insertable=false, updatable=false)
	private TPassion passionCode;
	
	@Column(name="create_date", columnDefinition="datetime", nullable=true)
	private Date createDate; 
	
	@Column(name="create_user_id", columnDefinition = "nvarchar(50)", nullable=true)
	private String createUserId;
	
	@Column(name="update_date", columnDefinition = "datetime", nullable=true)
	private Date updateDate;
	
	@Column(name="update_user_id", columnDefinition = "nvarchar(50)", nullable=true)
	private String updateUserId;	
	
	public Content() {
		this.contentName = null;
		this.imageUrl = null;
		this.newsId = null;
		this.passionCode = null;
		this.createDate = null;
		this.createUserId = null;
		this.updateDate = null;
		this.updateUserId = null;
	}

	public Long getContentId() {
		return contentId;
	}

	public void setContentId(Long contentId) {
		this.contentId = contentId;
	}

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

	public News getNewsId() {
		return newsId;
	}

	public void setNewsId(News newsId) {
		this.newsId = newsId;
	}

	public TPassion getPassionCode() {
		return passionCode;
	}

	public void setPassionCode(TPassion passionCode) {
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