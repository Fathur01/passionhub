package com.fwd.dao;

import java.util.List;

import com.fwd.model.passion.News;

public interface NewsDao {
	List<News> getAllNews();
	News save(News news);
}
