package com.fwd.service;

import java.util.List;

import com.fwd.model.passion.TPoint;

public interface PointService {
	
	public List<TPoint> getAllPoint();	
	public TPoint savePoint(TPoint point);	
}
