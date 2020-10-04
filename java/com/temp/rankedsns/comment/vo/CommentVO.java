package com.navercorp.rankedsns.comment.vo;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("CommentVO")
public class CommentVO {
	private int commentId;
	private int postId;
	private int userId;
	private String userName;
	private String commentContent;
	private Date commentDate;
	private int checkCommented;
}
