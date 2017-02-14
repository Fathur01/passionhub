package com.fwd.ws.response;


import javax.xml.bind.annotation.XmlRootElement;

import com.fwd.model.passion.Content;


@XmlRootElement
public class ContentCreateResponse extends WebServiceResponse {

	private Content content;

	public Content getContent() {
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
	}


}
