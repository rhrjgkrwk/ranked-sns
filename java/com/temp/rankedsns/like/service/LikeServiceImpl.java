package com.navercorp.rankedsns.like.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.navercorp.rankedsns.like.dao.LikeDAO;
import com.navercorp.rankedsns.like.vo.LikeVO;
import com.navercorp.rankedsns.post.dao.PostDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LikeServiceImpl implements LikeService{
	@Autowired
	LikeDAO likeDAO;
	@Autowired
	PostDAO postDAO;
	
	@Transactional
	public int addLike(LikeVO likeVO) {
		log.info("tx : start");
		//add Like
		likeDAO.addLike(likeVO);
		//likeCnt update
		Map<String, Integer> param = new HashMap<String, Integer>();
		param.put("postId", likeVO.getLikePostId());
		param.put("likeNum", 1);
		postDAO.setPostLikeCnt(param);
		
		log.info("tx : end");
		//return updated likeCnt
		return postDAO.getPostLikeCnt(likeVO.getLikePostId());
	}

	@Transactional
	public int deleteLike(LikeVO likeVO) {
		//delete Like
		likeDAO.deleteLike(likeVO);
		//likeCnt update
		Map<String, Integer> param = new HashMap<String, Integer>();
		param.put("postId", likeVO.getLikePostId());
		param.put("likeNum", -1);
		postDAO.setPostLikeCnt(param);
		//return updated likeCnt
		return postDAO.getPostLikeCnt(likeVO.getLikePostId());
	}
	@Override
	public int checkLiked(LikeVO likeVO) {
		// TODO Auto-generated method stub
		return likeDAO.checkLiked(likeVO);
	};
}
