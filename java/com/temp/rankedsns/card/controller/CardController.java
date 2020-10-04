package com.navercorp.rankedsns.card.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.navercorp.rankedsns.card.service.CardService;
import com.navercorp.rankedsns.card.vo.CardVO;
import com.navercorp.rankedsns.user.vo.UserVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CardController {
	@Autowired
	CardService cardService;

	@GetMapping(value = "")
	public String mainPage() {
		log.info("main page");
		return "main";
	}

	@GetMapping(value = "allrank")
	@ResponseBody
	public List<CardVO> getAllCard(HttpSession session) {
		UserVO userVO = (UserVO)session.getAttribute("userVO");
		log.info("main - all rank");
		List<CardVO> res = cardService.getAllCard(userVO==null?-1:userVO.getUserId());
		return res;
	}

	@GetMapping(value = "friendsrank")
	@ResponseBody
	public List<CardVO> getAllFriendsCard(HttpSession session) {
		log.info("main - friends rank");
		UserVO userVO = (UserVO)session.getAttribute("userVO");
		if (userVO==null) {
			return null;
		}
		return cardService.getAllFriendsCard(userVO.getUserId());
	}
}
