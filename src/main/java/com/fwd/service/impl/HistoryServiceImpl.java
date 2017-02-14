package com.fwd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fwd.dao.HistoryDao;
import com.fwd.model.passion.History;
import com.fwd.service.HistoryService;

@Service
public class HistoryServiceImpl implements HistoryService {

	@Autowired
	private HistoryDao historyDao;

	@Override
	@Transactional(value = "transactionManager", readOnly = true)
	public List<History> getAllHistory() {
		// TODO Auto-generated method stub
		return historyDao.getAllHistory();
	}
	
	@Override
	@Transactional(value = "transactionManager", readOnly = false)
	public History saveHistory(History history) {
		// TODO Auto-generated method stub
		return historyDao.save(history);
	}
}
