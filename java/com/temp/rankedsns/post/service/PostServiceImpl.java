package com.navercorp.rankedsns.post.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navercorp.rankedsns.post.dao.PostDAO;
import com.navercorp.rankedsns.post.vo.PostVO;

@Service
public class PostServiceImpl implements PostService {
	@Autowired
	PostDAO postDAO;

	@Override
	public int addPost(PostVO postVO) {
		// TODO Auto-generated method stub
		return postDAO.addPost(postVO);
	}

	@Override
	public PostVO getPost(int postId) {
		// TODO Auto-generated method stub
		return postDAO.getPost(postId);
	}

	@Override
	public void setPost(PostVO postVO) {
		// TODO Auto-generated method stub
		postDAO.setPost(postVO);
	}

	@Override
	public void deletePost(int postId) {
		//comment / like 삭제 후 post 삭제
		postDAO.deletePost(postId);
	}

	@Override
	public int getPostLikeCnt(int postId) {
		// TODO Auto-generated method stub
		return postDAO.getPostLikeCnt(postId);
	}

	@Override
	public int getPostCommentCnt(int postId) {
		// TODO Auto-generated method stub
		return postDAO.getPostCommentCnt(postId);
	}

}
