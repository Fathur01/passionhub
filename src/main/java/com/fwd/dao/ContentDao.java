package com.fwd.dao;

import java.util.List;

import com.fwd.model.passion.Content;

public interface ContentDao {
	List<Content> getAllContent();
	Content save(Content content);
}
