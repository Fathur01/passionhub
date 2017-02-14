package com.fwd.service;

import java.util.List;

import com.fwd.model.passion.TrRedeem;

public interface TrRedeemService {
	
	public List<TrRedeem> getAllTrRedeem();	
	public TrRedeem saveTrRedeem(TrRedeem trRedeem);	
}
