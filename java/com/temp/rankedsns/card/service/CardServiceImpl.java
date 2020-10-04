package com.navercorp.rankedsns.card.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.navercorp.rankedsns.card.dao.CardDAO;
import com.navercorp.rankedsns.card.vo.CardVO;
import com.navercorp.rankedsns.like.dao.LikeDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CardServiceImpl implements CardService {
	@Autowired
	CardDAO cardDAO;
	@Autowired
	LikeDAO likeDAO;

	@Override
	public List<CardVO> getAllCard(int sessionUserId) {
		List<CardVO> cardList = cardDAO.getAllCard(sessionUserId);
		log.info(cardList.toString());
		if (sessionUserId == -1) {
			for (CardVO cardVO : cardList) {
				cardVO.getPostVO().setCheckLiked(-1);
			}
		}
		return cardList;
	}

	@Override
	public List<CardVO> getAllFriendsCard(int sessionUserId) {
		List<CardVO> cardList = cardDAO.getAllFriendsCard(sessionUserId);
		if (sessionUserId == -1) {
			for (CardVO cardVO : cardList) {
				cardVO.getPostVO().setCheckLiked(-1);
			}
		}
		return cardList;
	}
}
