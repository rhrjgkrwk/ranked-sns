package com.navercorp.rankedsns.like.dao;

import com.navercorp.rankedsns.like.vo.LikeVO;

public interface LikeDAO {
	public int addLike(LikeVO likeVO);
	public int deleteLike(LikeVO likeVO);
	public int checkLiked(LikeVO likeVO);
}
