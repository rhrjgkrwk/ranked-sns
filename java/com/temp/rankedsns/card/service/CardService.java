package com.navercorp.rankedsns.card.service;

import java.util.List;
import com.navercorp.rankedsns.card.vo.CardVO;

public interface CardService {
	public List<CardVO> getAllCard(int sessionUserId);

	public List<CardVO> getAllFriendsCard(int sessionUserId);
}
