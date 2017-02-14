package com.fwd.service;

import java.util.List;

import com.fwd.model.passion.TPassion;

public interface PassionService {
	
	public List<TPassion> getAllPassion();	
	public TPassion savePassion(TPassion passion);	
}
