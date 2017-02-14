package com.fwd.ws.response;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fwd.model.passion.History;

@XmlRootElement
public class HistoryResponse  extends WebServiceResponse{
	
	private List<History> historyList;
	private List<DropdownItem> historyDropList;
	
	public List<History> getHistoryList() {
		return historyList;
	}
	public void setHistoryList(List<History> historyList) {
		this.historyList = historyList;
	}
	public List<DropdownItem> getHistoryDropList() {
		return historyDropList;
	}
	public void setHistoryDropList(List<DropdownItem> historyDropList) {
		this.historyDropList = historyDropList;
	}
	
		
}
