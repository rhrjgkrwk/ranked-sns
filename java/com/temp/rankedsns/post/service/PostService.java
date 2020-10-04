package com.navercorp.rankedsns.post.service;

import com.navercorp.rankedsns.post.vo.PostVO;

public interface PostService {
	public int addPost(PostVO postVO);

	public PostVO getPost(int postId);

	public void setPost(PostVO postVO);

	public void deletePost(int postId);
	
	public int getPostLikeCnt(int postId);

	public int getPostCommentCnt(int postId);
	
}
