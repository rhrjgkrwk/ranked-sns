package com.navercorp.rankedsns.friend.vo;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("FriendVO")
public class FriendVO {
	private int sendUserId;
	private int receiveUserId;
	private int status;
}
