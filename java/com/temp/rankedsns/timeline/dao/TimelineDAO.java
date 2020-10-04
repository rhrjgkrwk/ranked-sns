package com.navercorp.rankedsns.timeline.dao;

import java.util.Map;

import com.navercorp.rankedsns.timeline.vo.TimelineVO;

public interface TimelineDAO {
	public TimelineVO getTimeline(Map<String, Integer> param);
}
