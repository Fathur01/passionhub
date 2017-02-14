package com.fwd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fwd.dao.TrRedeemDao;
import com.fwd.model.passion.TrRedeem;
import com.fwd.service.TrRedeemService;

@Service
public class TrRedeemServiceImpl implements TrRedeemService {

	@Autowired
	private TrRedeemDao trRedeemDao;

	@Override
	@Transactional(value = "transactionManager", readOnly = true)
	public List<TrRedeem> getAllTrRedeem() {
		// TODO Auto-generated method stub
		return trRedeemDao.getAllTrRedeem();
	}
	
	@Override
	@Transactional(value = "transactionManager", readOnly = false)
	public TrRedeem saveTrRedeem(TrRedeem trRedeem) {
		// TODO Auto-generated method stub
		return trRedeemDao.save(trRedeem);
	}
}
