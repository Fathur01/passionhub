package com.fwd.ws.response;


import javax.xml.bind.annotation.XmlRootElement;

import com.fwd.model.passion.Activity;
import com.fwd.model.passion.TrPoint;


@XmlRootElement
public class TrPointCreateResponse extends WebServiceResponse {

	private TrPoint trPoint;

	public TrPoint getTrPoint() {
		return trPoint;
	}

	public void setTrPoint(TrPoint trPoint) {
		this.trPoint = trPoint;
	}


}
