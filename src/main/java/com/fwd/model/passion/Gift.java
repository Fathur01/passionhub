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
@Table(name="ms_gift")
public class Gift {

	@Id
	@GenericGenerator(name="generator", strategy="increment")
	@GeneratedValue(generator="generator")
	@Column(name="gift_id", length=100 , nullable=true)
	private Long giftId;
	
	@Column(name="gift_name", columnDefinition="nvarchar(50)", nullable=true)
	private String giftName; 
	
	@Column(name="gift_desc", columnDefinition="nvarchar(255)", nullable=true)
	private String giftDesc; 
	
	@ManyToOne
    @JoinColumn(name="point", referencedColumnName="ms_point_id",  insertable=false, updatable=false)
	private TPoint point; 
	
	@Column(name="create_date", columnDefinition = "datetime", nullable=true)
	private Date createDate;
	
	@Column(name="create_user_id", columnDefinition = "nvarchar(50)", nullable=true)
	private String createUserId;
	
	@Column(name="update_date", columnDefinition="datetime", nullable=true)
	private Date updateDate; 
	
	@Column(name="update_user_id", columnDefinition = "nvarchar(50)", nullable=true)
	private String updateUserId;

	public Long getGiftId() {
		return giftId;
	}

	public void setGiftId(Long giftId) {
		this.giftId = giftId;
	}

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

	public TPoint getPoint() {
		return point;
	}

	public void setPoint(TPoint point) {
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

	public Gift() {
		this.giftName = null;
		this.giftDesc = null;
		this.point = null;
		this.createDate = null;
		this.createUserId = null;
		this.updateDate = null;
		this.updateUserId = null;
	}

	
}