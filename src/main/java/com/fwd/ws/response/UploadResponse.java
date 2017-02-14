package com.fwd.ws.response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UploadResponse extends WebServiceResponse {
	private String fileId;
	
	private String fileName;

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
}
