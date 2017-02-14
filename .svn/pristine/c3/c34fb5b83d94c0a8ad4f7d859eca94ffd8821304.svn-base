package com.fwd.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.fwd.dao.MemberDao;
import com.fwd.dao.NewsDao;
import com.fwd.model.passion.Member;
import com.fwd.model.passion.News;

@Repository
public class NewsDaoImpl extends AbstractDao implements NewsDao {


//	@SuppressWarnings("unchecked")
	@SuppressWarnings("unchecked")
	@Override
	public List<News> getAllNews() {
		
		System.out.println("NewsDao.getAllNews start");

		Criteria newsCrit = session().createCriteria(News.class);
		
		List<News> list = newsCrit.list();

		return list;
	}
	
	@Override
	public News save(News news) {
		try{
			return (News)session().merge(news);
		}catch (Exception e) {
			return new News();
		}
		
	}

}
