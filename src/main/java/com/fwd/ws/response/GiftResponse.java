package com.fwd.ws.response;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fwd.model.passion.Gift;

@XmlRootElement
public class GiftResponse  extends WebServiceResponse{
	
	private List<Gift> giftList;
	private List<DropdownItem> giftDropList;
	
	public List<Gift> getGiftList() {
		return giftList;
	}
	public void setGiftList(List<Gift> giftList) {
		this.giftList = giftList;
	}
	public List<DropdownItem> getGiftDropList() {
		return giftDropList;
	}
	public void setGiftDropList(List<DropdownItem> giftDropList) {
		this.giftDropList = giftDropList;
	}
	
		
}
