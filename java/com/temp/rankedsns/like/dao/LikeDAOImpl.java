package com.navercorp.rankedsns.like.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.navercorp.rankedsns.like.vo.LikeVO;

@Repository
public class LikeDAOImpl implements LikeDAO {
	@Autowired
	SqlSession session;

	@Override
	public int addLike(LikeVO likeVO) {
		// TODO Auto-generated method stub
		return session.insert("like.addLike", likeVO);
	}

	@Override
	public int deleteLike(LikeVO likeVO) {
		// TODO Auto-generated method stub
		return session.insert("like.deleteLike", likeVO);
	}

	@Override
	public int checkLiked(LikeVO likeVO) {
		// TODO Auto-generated method stub
		return session.selectOne("like.checkLiked", likeVO);
	}

}
