package com.fwd.ws.response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BaseResponse {

	private String[] errMsgs;

	public String[] getErrMsgs() {
		return errMsgs;
	}

	public void setErrMsg(String errMsg) {
		this.errMsgs = new String[]{errMsg};
	}
	
	public void setErrMsgs(String[] errMsgs) {
		this.errMsgs = errMsgs;
	}
	
}
