package com.navercorp.rankedsns.timeline.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.navercorp.rankedsns.timeline.vo.TimelineVO;

@Repository
public class TimelineDAOImpl implements TimelineDAO {
	@Autowired
	SqlSession session;

	@Override
	public TimelineVO getTimeline(Map<String, Integer> param) {
		TimelineVO timelineVO = session.selectOne("timeline.getTimeline", param);
		return timelineVO;
	};
}
