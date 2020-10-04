package com.navercorp.rankedsns.post.vo;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("PostVO")
public class PostVO {
	private int postId;
	private int userId;
	private int postScope;
	private String postTitle;
	private String postContent;
	private Date postDatetime;
	private String postColor;
	private int likeCnt;
	private int commentCnt;
	
	private int checkLiked;
}