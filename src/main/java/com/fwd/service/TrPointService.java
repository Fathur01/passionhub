package com.fwd.service;

import java.util.List;

import com.fwd.model.passion.TrPoint;

public interface TrPointService {
	
	public List<TrPoint> getAllTrPoint();	
	public TrPoint saveTrPoint(TrPoint trPoint);	
}
