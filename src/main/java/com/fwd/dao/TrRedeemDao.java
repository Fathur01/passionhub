package com.fwd.dao;

import java.util.List;

import com.fwd.model.passion.TrRedeem;

public interface TrRedeemDao {
	List<TrRedeem> getAllTrRedeem();
	TrRedeem save(TrRedeem trRedeem);
}
