package com.fwd.ws.response;


import javax.xml.bind.annotation.XmlRootElement;

import com.fwd.model.passion.TrBalance;


@XmlRootElement
public class TrBalanceCreateResponse extends WebServiceResponse {

	private TrBalance trBalance;

	public TrBalance getTrBalance() {
		return trBalance;
	}

	public void setTrBalance(TrBalance trBalance) {
		this.trBalance = trBalance;
	}


}
