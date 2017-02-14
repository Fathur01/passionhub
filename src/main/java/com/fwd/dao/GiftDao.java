package com.fwd.dao;

import java.util.List;

import com.fwd.model.passion.Gift;

public interface GiftDao {
	List<Gift> getAllGift();
	Gift save(Gift gift);
}
