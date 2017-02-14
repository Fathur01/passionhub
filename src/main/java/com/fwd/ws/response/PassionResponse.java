package com.fwd.ws.response;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fwd.model.passion.TPassion;

@XmlRootElement
public class PassionResponse  extends WebServiceResponse{
	
	private List<TPassion> passionList;
	private List<DropdownItem> passionDropList;
	
	public List<TPassion> getPassionList() {
		return passionList;
	}
	public void setPassionList(List<TPassion> passionList) {
		this.passionList = passionList;
	}
	public List<DropdownItem> getPassionDropList() {
		return passionDropList;
	}
	public void setPassionDropList(List<DropdownItem> passionDropList) {
		this.passionDropList = passionDropList;
	}
	
		
}
