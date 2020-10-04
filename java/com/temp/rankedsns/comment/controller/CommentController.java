package com.navercorp.rankedsns.comment.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.navercorp.rankedsns.comment.service.CommentService;
import com.navercorp.rankedsns.comment.vo.CommentVO;
import com.navercorp.rankedsns.user.vo.UserVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CommentController {
	@Autowired
	CommentService commentService;

	@PostMapping("comment/addcomment")
	@ResponseBody
	public CommentVO addComment(HttpSession session, CommentVO commentVO) {
		UserVO userVO = (UserVO)session.getAttribute("userVO");
		log.info("addcomment - session user : " + userVO);
		if (userVO == null) {
			return null;
		}
		commentVO.setUserId(userVO.getUserId());
		commentVO.setUserName(userVO.getUserName());
		CommentVO newComment = commentService.addComment(commentVO);
		log.info("added comment id : " + newComment.getCommentId());
		return newComment;
	}

	@PostMapping("comment/getallcomment")
	@ResponseBody
	public List<CommentVO> getAllComment(HttpSession session, int postId) {
		UserVO userVO = (UserVO)session.getAttribute("userVO");
		Map<String, Integer> param = new HashMap<String, Integer>();
		param.put("userId", userVO == null ? -1 : userVO.getUserId());
		param.put("postId", postId);
		return commentService.getAllComment(param);
	}

	@PostMapping("comment/getcomment")
	@ResponseBody
	public CommentVO getComment(HttpSession session, int commentId) {
		UserVO userVO = (UserVO)session.getAttribute("userVO");
		Map<String, Integer> param = new HashMap<String, Integer>();
		
		param.put("userId", userVO == null ? -1 : userVO.getUserId());
		param.put("commentId", commentId);
		return commentService.getComment(param);
	}
	
	@PostMapping("comment/getcommentcnt")
	@ResponseBody
	public int getCommentCnt(int postId) {
		return commentService.getCommentCnt(postId);
	}

	@PostMapping("comment/setcomment")
	@ResponseBody
	public void setComment(CommentVO commentVO) {
		log.info("edit comment : " + commentVO);
		commentService.setCommentContent(commentVO);
	}

	@PostMapping("comment/deletecomment")
	@ResponseBody
	public int deleteComment(CommentVO commentVO) {
		log.info("delete comment : " + commentVO);
		return commentService.deleteComment(commentVO);
	}
}
