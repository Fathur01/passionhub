package com.fwd.ws.response;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fwd.model.passion.Content;

@XmlRootElement
public class ContentResponse  extends WebServiceResponse{
	
	private List<Content> contentList;
	private List<DropdownItem> contentDropList;
	
	public List<Content> getContentList() {
		return contentList;
	}
	public void setContentList(List<Content> contentList) {
		this.contentList = contentList;
	}
	public List<DropdownItem> getContentDropList() {
		return contentDropList;
	}
	public void setContentDropList(List<DropdownItem> contentDropList) {
		this.contentDropList = contentDropList;
	}
	
		
}
