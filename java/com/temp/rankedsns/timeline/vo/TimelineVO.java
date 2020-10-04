package com.navercorp.rankedsns.timeline.vo;
import java.util.ArrayList;
import org.apache.ibatis.type.Alias;
import com.navercorp.rankedsns.post.vo.PostVO;
import com.navercorp.rankedsns.user.vo.UserVO;
import lombok.Data;

@Data
@Alias("TimelineVO")
public class TimelineVO {
	private UserVO userVO;
	private ArrayList<PostVO> postList;
}
