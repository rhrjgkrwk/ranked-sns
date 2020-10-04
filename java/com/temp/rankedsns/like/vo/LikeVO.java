package com.navercorp.rankedsns.like.vo;

import java.util.Date;
import org.apache.ibatis.type.Alias;
import lombok.Data;

@Data
@Alias("LikeVO")
public class LikeVO {
	private int likePostId;
	private int likeUserId;
	private Date likeDate;
	public LikeVO() {
		// TODO Auto-generated constructor stub
	}
	public LikeVO(int likePostId, int likeUserId) {
		super();
		this.likePostId = likePostId;
		this.likeUserId = likeUserId;
	}
	
}
