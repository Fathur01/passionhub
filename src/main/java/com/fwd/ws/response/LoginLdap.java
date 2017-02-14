package com.fwd.ws.response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LoginLdap {
	private String sessionID;
	private int err_code;
	public String getSessionID() {
		return sessionID;
	}
	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}
	public int getErr_code() {
		return err_code;
	}
	public void setErr_code(int err_code) {
		this.err_code = err_code;
	}
	
	
}
