package com.fwd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fwd.dao.ContentDao;
import com.fwd.model.passion.Content;
import com.fwd.service.ContentService;

@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private ContentDao contentDao;

	@Override
	@Transactional(value = "transactionManager", readOnly = true)
	public List<Content> getAllContent() {
		// TODO Auto-generated method stub
		return contentDao.getAllContent();
	}
	
	@Override
	@Transactional(value = "transactionManager", readOnly = false)
	public Content saveContent(Content content) {
		// TODO Auto-generated method stub
		return contentDao.save(content);
	}
}
