package com.navercorp.rankedsns.comment.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.navercorp.rankedsns.comment.vo.CommentVO;

@Repository
public class CommentDAOImpl implements CommentDAO {
	@Autowired
	SqlSession session;

	@Override
	public CommentVO addComment(CommentVO commentVO) {
		// TODO Auto-generated method stub
		session.insert("comment.addComment", commentVO);
		return commentVO;
	}

	@Override
	public List<CommentVO> getAllComment(Map<String, Integer> param) {
		// TODO Auto-generated method stub
		return session.selectList("comment.getAllComment", param);
	}

	@Override
	public CommentVO getComment(Map<String, Integer> param) {
		// TODO Auto-generated method stub
		return session.selectOne("comment.getComment", param);
	}

	@Override
	public void setCommentContent(CommentVO commentVO) {
		// TODO Auto-generated method stub
		session.update("comment.setCommentContent", commentVO);
	}

	@Override
	public int deleteComment(int commentId) {
		// TODO Auto-generated method stub
		return session.delete("comment.deleteComment", commentId);
	}

}
