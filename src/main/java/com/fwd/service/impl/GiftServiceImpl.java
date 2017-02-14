package com.fwd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fwd.dao.GiftDao;
import com.fwd.model.passion.Gift;
import com.fwd.service.GiftService;

@Service
public class GiftServiceImpl implements GiftService {

	@Autowired
	private GiftDao giftDao;

	@Override
	@Transactional(value = "transactionManager", readOnly = true)
	public List<Gift> getAllGift() {
		// TODO Auto-generated method stub
		return giftDao.getAllGift();
	}
	
	@Override
	@Transactional(value = "transactionManager", readOnly = false)
	public Gift saveGift(Gift gift) {
		// TODO Auto-generated method stub
		return giftDao.save(gift);
	}
}
