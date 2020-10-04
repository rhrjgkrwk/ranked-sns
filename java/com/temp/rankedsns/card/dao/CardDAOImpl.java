package com.navercorp.rankedsns.card.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.navercorp.rankedsns.card.vo.CardVO;

import lombok.extern.slf4j.Slf4j;

/*
메인에 표시될 카드 데이터를 디비로 부터 가져온다.
랭킹은 데이터를 가져오는 시점에서 score 순으로 결정이 되며
무한 스크롤로 구성하는 것을 고려하였을 때
한번에 N개씩 가져오도록하는 method도 필요할 듯 하다.
*/

@Slf4j
@Repository
public class CardDAOImpl implements CardDAO {

	@Autowired
	SqlSession session;

	@Override
	public List<CardVO> getAllCard(int sessionUserId) { //전체 유저의 card를 가져온다.
		List<CardVO> res = session.selectList("card.getAllCard", sessionUserId);
		log.info("cardDAOImpl.getAllCard : " + res.size());
		return res;
	}

	@Override
	public List<CardVO> getAllFriendsCard(int sessionUserId) { //해당 user와 친구인 card를 가져온다.
		List<CardVO> res = session.selectList("card.getAllFriendsCard", sessionUserId);
		return res;
	}
}
