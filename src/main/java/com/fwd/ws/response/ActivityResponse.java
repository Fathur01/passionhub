package com.fwd.ws.response;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fwd.model.passion.Activity;

@XmlRootElement
public class ActivityResponse  extends WebServiceResponse{
	
	private List<Activity> activityList;
	
	public List<Activity> getActivityList() {
		return activityList;
	}
	public void setActivityList(List<Activity> activityList) {
		this.activityList = activityList;
	}
	
		
}
