package com.navercorp.rankedsns.card.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.navercorp.rankedsns.card.vo.CardVO;

@Repository
public interface CardDAO {
	public List<CardVO> getAllCard(int sessionUserId);

	public List<CardVO> getAllFriendsCard(int sessionUserId);
}
