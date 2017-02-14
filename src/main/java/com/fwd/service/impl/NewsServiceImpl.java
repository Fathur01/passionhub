package com.fwd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fwd.dao.NewsDao;
import com.fwd.model.passion.News;
import com.fwd.service.NewsService;

@Service
public class NewsServiceImpl implements NewsService {

	@Autowired
	private NewsDao newsDao;

	@Override
	@Transactional(value = "transactionManager", readOnly = true)
	public List<News> getAllNews() {
		// TODO Auto-generated method stub
		return newsDao.getAllNews();
	}
	
	@Override
	@Transactional(value = "transactionManager", readOnly = false)
	public News saveNews(News news) {
		// TODO Auto-generated method stub
		return newsDao.save(news);
	}
}
