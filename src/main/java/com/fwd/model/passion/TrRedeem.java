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
@Table(name="tr_redeem")
public class TrRedeem {

	@Id
	@GenericGenerator(name="generator", strategy="increment")
	@GeneratedValue(generator="generator")
	@Column(name="redeem_id", length=100 , nullable=true)
	private Long redeemId;
	
	@Column(name="redeem_date", columnDefinition="datetime", nullable=true)
	private Date redeemDate; 
	
	@ManyToOne
    @JoinColumn(name="gift_id", referencedColumnName="gift_id",  insertable=false, updatable=false)
	private Gift giftId; 
	
	@Column(name="redeem_point", columnDefinition="int", nullable=true)
	private int redeemPoint; 
	
	@ManyToOne
    @JoinColumn(name="balance_id", referencedColumnName="balance_id",  insertable=false, updatable=false)
	private TrBalance balanceId;
	
	@ManyToOne
    @JoinColumn(name="history_id", referencedColumnName="hist_id",  insertable=false, updatable=false)
	private History historyId; 
	
	@Column(name="create_date", columnDefinition = "datetime", nullable=true)
	private Date createDate;
	
	@Column(name="create_user_id", columnDefinition = "nvarchar(50)", nullable=true)
	private String createUserId;
	
	@Column(name="update_user_id", columnDefinition="nvarchar(50)", nullable=true)
	private String updateUserId; 
	
	@Column(name="update_date", columnDefinition = "datetime", nullable=true)
	private Date updateDate;

	public TrRedeem() {
		this.redeemDate = null;
		this.giftId = null;
		this.redeemPoint = 0;
		this.balanceId = null;
		this.historyId = null;
		this.createDate = null;
		this.createUserId = null;
		this.updateUserId = null;
		this.updateDate = null;
	}

	public Long getRedeemId() {
		return redeemId;
	}

	public void setRedeemId(Long redeemId) {
		this.redeemId = redeemId;
	}

	public Date getRedeemDate() {
		return redeemDate;
	}

	public void setRedeemDate(Date redeemDate) {
		this.redeemDate = redeemDate;
	}

	public Gift getGiftId() {
		return giftId;
	}

	public void setGiftId(Gift giftId) {
		this.giftId = giftId;
	}

	public int getRedeemPoint() {
		return redeemPoint;
	}

	public void setRedeemPoint(int redeemPoint) {
		this.redeemPoint = redeemPoint;
	}

	public TrBalance getBalanceId() {
		return balanceId;
	}

	public void setBalanceId(TrBalance balanceId) {
		this.balanceId = balanceId;
	}

	public History getHistoryId() {
		return historyId;
	}

	public void setHistoryId(History historyId) {
		this.historyId = historyId;
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