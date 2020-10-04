package com.navercorp.rankedsns.timeline.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.navercorp.rankedsns.like.dao.LikeDAO;
import com.navercorp.rankedsns.post.vo.PostVO;
import com.navercorp.rankedsns.timeline.dao.TimelineDAO;
import com.navercorp.rankedsns.timeline.vo.TimelineVO;
import com.navercorp.rankedsns.user.dao.UserDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TimelineServiceImpl implements TimelineService {
	@Autowired
	TimelineDAO timelineDAO;
	@Autowired
	UserDAO userDAO;
	@Autowired
	LikeDAO likeDAO;

	@Override
	public TimelineVO getTimeline(int sessionUserId, int userId) {
		Map<String, Integer> param = new HashMap<String, Integer>();
		param.put("sessionUserId", sessionUserId);
		param.put("timelineUserId", userId);
		TimelineVO timelineVO = timelineDAO.getTimeline(param);
		timelineVO.getUserVO().setUserRank(userDAO.getUserRank(userId));
		if (sessionUserId == -1) {
			for (PostVO postVO : timelineVO.getPostList()) {
				postVO.setCheckLiked(-1);
			}
		}
		log.info("timelineVO : "+timelineVO);
		return timelineVO;
	}
}

//}
//else {
//	LikeVO likeVO = new LikeVO(postVO.getPostId(), sessionUserId);
//	int checkLiked = likeDAO.checkLiked(likeVO);
//	log.info("likeVO : " + likeVO + " liked : " + checkLiked);
//	postVO.setCheckLiked(checkLiked);
//}