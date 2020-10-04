package com.navercorp.rankedsns.like.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.navercorp.rankedsns.like.service.LikeService;
import com.navercorp.rankedsns.like.vo.LikeVO;
import com.navercorp.rankedsns.post.service.PostService;
import com.navercorp.rankedsns.user.vo.UserVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LikeController {
	@Autowired
	LikeService likeService;
	@Autowired
	PostService postService;
	
	@PostMapping("like/addLike")
	@ResponseBody
	public int addLike(HttpSession session, int postId) {
		UserVO userVO = (UserVO)session.getAttribute("userVO");
		LikeVO likeVO = new LikeVO();
		log.info("addlike : "+postId+" from : "+userVO.getUserId());
		likeVO.setLikeUserId(userVO.getUserId());
		likeVO.setLikePostId(postId);
		return likeService.addLike(likeVO);
	}
	
	@PostMapping("like/deleteLike")
	@ResponseBody
	public int deleteLike(HttpSession session, int postId) {
		UserVO userVO = (UserVO)session.getAttribute("userVO");
		LikeVO likeVO = new LikeVO();
		log.info("deleteLike : "+postId+" from : "+userVO.getUserId());
		likeVO.setLikeUserId(userVO.getUserId());
		likeVO.setLikePostId(postId);
		return likeService.deleteLike(likeVO);
	}
	
	@PostMapping("like/checkLiked")
	@ResponseBody
	public boolean checkLiked(LikeVO likeVO) {
		int res = likeService.checkLiked(likeVO);
		return res==0?false:true;
	}
}
