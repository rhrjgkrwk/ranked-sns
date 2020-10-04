package com.navercorp.rankedsns.post.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.navercorp.rankedsns.post.vo.PostVO;

@Repository
public class PostDAOImpl implements PostDAO {
	@Autowired
	SqlSession session;

	@Override
	public int addPost(PostVO postVO) {
		session.insert("post.addPost", postVO);
		return postVO.getPostId();
	}

	@Override
	public PostVO getPost(int postId) {
		PostVO res = session.selectOne("post.getPost", postId);
		return res;
	}

	@Override
	public void setPost(PostVO postVO) {
		session.update("post.setPost", postVO);
	}

	@Override
	public void deletePost(int postId) {
		session.delete("post.deletePost", postId);
	}

	@Override
	public void setPostLikeCnt(Map<String, Integer> param) {
		session.update("post.setPostLikeCnt", param);
	}

	@Override
	public void setPostCommentCnt(Map<String, Integer> param) {
		session.update("post.setPostCommentCnt", param);
	}

	@Override
	public int getPostLikeCnt(int postId) {
		return session.selectOne("post.getPostLikeCnt", postId);
	}

	@Override
	public int getPostCommentCnt(int postId) {
		return session.selectOne("post.getPostCommentCnt", postId);
	}

}
