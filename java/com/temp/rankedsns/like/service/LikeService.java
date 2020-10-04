package com.navercorp.rankedsns.like.service;

import com.navercorp.rankedsns.like.vo.LikeVO;

public interface LikeService {
	public int addLike(LikeVO likeVO);
	public int deleteLike(LikeVO likeVO);
	public int checkLiked(LikeVO likeVO);
}
