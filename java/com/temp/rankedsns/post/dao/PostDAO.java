package com.navercorp.rankedsns.post.dao;

import java.util.Map;

import com.navercorp.rankedsns.post.vo.PostVO;

public interface PostDAO {
	public int addPost(PostVO postVO);

	public PostVO getPost(int postId);

	public void setPost(PostVO postVO);

	public void deletePost(int postId);
	
	public void setPostLikeCnt(Map<String, Integer> param);
	
	public void setPostCommentCnt(Map<String, Integer> param);
	
	public int getPostLikeCnt(int postId);
	
	public int getPostCommentCnt(int postId);
}
