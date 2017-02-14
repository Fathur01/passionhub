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
@Table(name="ms_news")
public class News {

	@Id
	@GenericGenerator(name="generator", strategy="increment")
	@GeneratedValue(generator="generator")
	@Column(name="news_id", length=100 , nullable=true)
	private Long newsId;
	
	@Column(name="news_title", columnDefinition="nvarchar(50)", nullable=true)
	private String newsTitle; 
	
	@Column(name="news_content", columnDefinition="text", nullable=true)
	private String newsContent; 
	
	@Column(name="create_date", columnDefinition="datetime", nullable=true)
	private Date createDate; 
	
	@Column(name="create_user_id", columnDefinition = "nvarchar(50)", nullable=true)
	private String createUserId;
	
	@Column(name="update_date", columnDefinition="datetime", nullable=true)
	private Date updateDate; 
	
	@Column(name="update_user_id", columnDefinition = "nvarchar(50)", nullable=true)
	private String updateUserId;

	@ManyToOne
    @JoinColumn(name="content_fk", referencedColumnName="content_id",  insertable=false, updatable=false)
	private Content contentFk;

	public News() {
		this.newsTitle = null;
		this.newsContent = null;
		this.createDate = null;
		this.createUserId = null;
		this.updateDate = null;
		this.updateUserId = null;
		this.contentFk = null;
	}

	public Long getNewsId() {
		return newsId;
	}

	public void setNewsId(Long newsId) {
		this.newsId = newsId;
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public String getNewsContent() {
		return newsContent;
	}

	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
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

	public Content getContentFk() {
		return contentFk;
	}

	public void setContentFk(Content contentFk) {
		this.contentFk = contentFk;
	}
	
}