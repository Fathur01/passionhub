package com.fwd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fwd.dao.BalanceDao;
import com.fwd.model.passion.TrBalance;
import com.fwd.service.TrBalanceService;

@Service
public class TrBalanceServiceImpl implements TrBalanceService {

	@Autowired
	private BalanceDao balanceDao;

	@Override
	@Transactional(value = "transactionManager", readOnly = true)
	public List<TrBalance> getAllTrBalance() {
		// TODO Auto-generated method stub
		return balanceDao.getAllTrBalance();
	}
	
	@Override
	@Transactional(value = "transactionManager", readOnly = false)
	public TrBalance saveTrBalance(TrBalance trBalance) {
		// TODO Auto-generated method stub
		return balanceDao.save(trBalance);
	}
}
