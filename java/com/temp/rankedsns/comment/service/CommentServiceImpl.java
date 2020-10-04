package com.navercorp.rankedsns.comment.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.navercorp.rankedsns.comment.dao.CommentDAO;
import com.navercorp.rankedsns.comment.vo.CommentVO;
import com.navercorp.rankedsns.post.dao.PostDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	CommentDAO commentDAO;
	@Autowired
	PostDAO postDAO;

	@Transactional
	@Override
	public CommentVO addComment(CommentVO commentVO) {
		//add comment
		CommentVO newComment = commentDAO.addComment(commentVO);
		newComment.setCheckCommented(1);
		log.info("added comment id : " + newComment);

		Map<String, Integer> param = new HashMap<String, Integer>();
		param.put("postId", commentVO.getPostId());
		param.put("commentNum", 1);
		postDAO.setPostCommentCnt(param);
		return commentVO;
	}

	@Override
	public List<CommentVO> getAllComment(Map<String, Integer> param) {
		return commentDAO.getAllComment(param);
	}

	@Override
	public CommentVO getComment(Map<String, Integer> param) {
		// TODO Auto-generated method stub
		CommentVO commentVO = commentDAO.getComment(param);
		return commentVO;
	}
	
	@Override
	public int getCommentCnt(int postId) {
		return postDAO.getPostCommentCnt(postId);
	}

	@Override
	public void setCommentContent(CommentVO commentVO) {
		commentDAO.setCommentContent(commentVO);
	}

	@Transactional
	@Override
	public int deleteComment(CommentVO commentVO) {
		// commentCnt update
		int deleteLine = commentDAO.deleteComment(commentVO.getCommentId());
		if (deleteLine > 0) {
			Map<String, Integer> param = new HashMap<String, Integer>();
			param.put("postId", commentVO.getPostId());
			param.put("commentNum", -1);
			postDAO.setPostCommentCnt(param);
		}
		return postDAO.getPostCommentCnt(commentVO.getPostId());
	}
}
