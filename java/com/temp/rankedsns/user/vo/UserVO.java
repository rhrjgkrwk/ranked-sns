package com.navercorp.rankedsns.user.vo;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("UserVO")
public class UserVO {
	private int userId;
	private String userEmail;
	private String userName;
	private String userPassword;
	private int score;
	private int userRank;
	private int mainPostId;
	private Date regDate;
}
