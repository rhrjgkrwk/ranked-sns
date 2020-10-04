package com.navercorp.rankedsns.timeline.service;

import com.navercorp.rankedsns.timeline.vo.TimelineVO;

public interface TimelineService {
	public TimelineVO getTimeline(int sessionUserId, int userId);
}
