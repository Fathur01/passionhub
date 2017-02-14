package com.fwd.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.fwd.dao.ContentDao;
import com.fwd.dao.MemberDao;
import com.fwd.model.passion.Content;
import com.fwd.model.passion.Member;

@Repository
public class ContentDaoImpl extends AbstractDao implements ContentDao {


	@SuppressWarnings("unchecked")
	@Override
	public List<Content> getAllContent() {
		
		System.out.println("ContentDao.getAllContent start");

		Criteria contentCrit = session().createCriteria(Content.class);
		
		List<Content> list = contentCrit.list();

		System.out.println("ContentDao.getAllContent end");
		return list;
	}
	
	@Override
	public Content save(Content content) {
		try{
			return (Content)session().merge(content);
		}catch (Exception e) {
			return new Content();
		}
		
	}

}
