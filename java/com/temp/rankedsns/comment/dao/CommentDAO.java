package com.navercorp.rankedsns.comment.dao;

import java.util.List;
import java.util.Map;

import com.navercorp.rankedsns.comment.vo.CommentVO;

public interface CommentDAO {
	public CommentVO addComment(CommentVO commentVO);
	
	public List<CommentVO> getAllComment(Map<String, Integer> param);
	
	public CommentVO getComment(Map<String, Integer> param);

	public void setCommentContent(CommentVO commentVO);
	
	public int deleteComment(int commentId);
}

