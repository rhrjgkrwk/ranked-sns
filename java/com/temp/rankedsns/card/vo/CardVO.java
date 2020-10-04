package com.navercorp.rankedsns.card.vo;

import org.apache.ibatis.type.Alias;

import com.navercorp.rankedsns.post.vo.PostVO;
import com.navercorp.rankedsns.user.vo.UserVO;

import lombok.Data;

@Data
@Alias("CardVO")
public class CardVO {
	private UserVO userVO;
	private PostVO postVO;
}
