package com.fwd.ws.response;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fwd.model.passion.TrPoint;

@XmlRootElement
public class TrPointResponse  extends WebServiceResponse{
	
	private List<TrPoint> trPointList;
	private List<DropdownItem> trPointDropList;
	
	public List<TrPoint> getTrPointList() {
		return trPointList;
	}
	public void setTrPointList(List<TrPoint> trPointList) {
		this.trPointList = trPointList;
	}
	public List<DropdownItem> getTrPointDropList() {
		return trPointDropList;
	}
	public void setTrPointDropList(List<DropdownItem> trPointDropList) {
		this.trPointDropList = trPointDropList;
	}
	
		
}
