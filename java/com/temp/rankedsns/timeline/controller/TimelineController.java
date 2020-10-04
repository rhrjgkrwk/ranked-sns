package com.navercorp.rankedsns.timeline.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.navercorp.rankedsns.timeline.service.TimelineService;
import com.navercorp.rankedsns.timeline.vo.TimelineVO;
import com.navercorp.rankedsns.user.vo.UserVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class TimelineController {
	@Autowired
	TimelineService timelineService;
	
	
	@GetMapping(value = "timeline")
	public ModelAndView getTimeline(HttpSession session, int userId) {
		log.info("getTimeline");
		UserVO userVO = (UserVO)session.getAttribute("userVO");
		ModelAndView mav = new ModelAndView();
		TimelineVO timeline = timelineService.getTimeline(userVO == null ? -1 : userVO.getUserId(), userId);
		mav.addObject("timeline", timeline);
		mav.setViewName("timeline");
		return mav;
	}
}
