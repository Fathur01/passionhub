package com.fwd.ws.response;


import javax.xml.bind.annotation.XmlRootElement;

import com.fwd.model.passion.Activity;
import com.fwd.model.passion.Gift;


@XmlRootElement
public class GiftCreateResponse extends WebServiceResponse {

	private Gift gift;

	public Gift getGift() {
		return gift;
	}

	public void setGift(Gift gift) {
		this.gift = gift;
	}


}
