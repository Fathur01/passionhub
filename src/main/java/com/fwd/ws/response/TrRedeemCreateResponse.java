package com.fwd.ws.response;


import javax.xml.bind.annotation.XmlRootElement;

import com.fwd.model.passion.TrRedeem;


@XmlRootElement
public class TrRedeemCreateResponse extends WebServiceResponse {

	private TrRedeem trRedeem;

	public TrRedeem getTrRedeem() {
		return trRedeem;
	}

	public void setTrRedeem(TrRedeem trRedeem) {
		this.trRedeem = trRedeem;
	}


}
