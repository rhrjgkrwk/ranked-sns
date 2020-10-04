package com.navercorp.rankedsns.comment.service;

import java.util.List;
import java.util.Map;

import com.navercorp.rankedsns.comment.vo.CommentVO;

public interface CommentService {
	public CommentVO addComment(CommentVO commentVO);

	public List<CommentVO> getAllComment(Map<String, Integer> param);
	
	public CommentVO getComment(Map<String, Integer> param);

	public int getCommentCnt(int postId);
	
	public void setCommentContent(CommentVO commentVO);

	public int deleteComment(CommentVO commentVO);
}
