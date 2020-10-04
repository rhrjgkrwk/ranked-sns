package com.navercorp.rankedsns.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.annotation.SessionScope;

import com.navercorp.rankedsns.user.service.UserService;
import com.navercorp.rankedsns.user.vo.UserVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class UserController {
	@Autowired
	UserService userService;

	@GetMapping("user/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("userVO");
		return "redirect:/";
	}

	@PostMapping("user/register")
	public String register(UserVO userVO) {
		log.info("param : " + userVO.toString());
		int res = userService.register(userVO);
		log.info("insert : " + res);
		return "redirect:/";
	}

	@PostMapping("user/loginCheck")
	@ResponseBody
	public boolean loginCheck(HttpSession session, String userEmail, String userPassword) {
		//logincheck
		log.info("logincheck:post" + userEmail + userPassword);
		UserVO userVO = userService.loginCheck(userEmail, userPassword);
		if (userVO != null) {
			log.info("login chk : " + userVO);
			session.setAttribute("userVO", userVO);
			return true;
		} else {
			log.info("login chk : " + userVO);
			return false;
		}
	}

	//Email 중복 검사를 한다.
	@PostMapping("user/emailCheck")
	@ResponseBody
	public boolean emailCheck(String email) {
		log.info("check Email duplication :" + email);
		if (userService.emailCheck(email) > 0) {
			return true;
		} else {
			return false;
		}
	}
}
