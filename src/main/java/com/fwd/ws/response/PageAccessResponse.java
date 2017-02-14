package com.fwd.ws.response;

import javax.xml.bind.annotation.XmlRootElement;

import com.fwd.ws.response.WebServiceResponse;

@XmlRootElement
public class PageAccessResponse extends WebServiceResponse {

	private boolean accessRight;

	public boolean isAccessRight() {
		return accessRight;
	}

	public void setAccessRight(boolean accessRight) {
		this.accessRight = accessRight;
	}

	
}
