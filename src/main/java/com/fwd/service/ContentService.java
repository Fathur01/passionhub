package com.fwd.service;

import java.util.List;

import com.fwd.model.passion.Content;

public interface ContentService {
	
	public List<Content> getAllContent();	
	public Content saveContent(Content content);	
}
