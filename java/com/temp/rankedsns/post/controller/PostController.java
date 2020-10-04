package com.navercorp.rankedsns.post.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.navercorp.rankedsns.post.service.PostService;
import com.navercorp.rankedsns.post.vo.PostVO;
import com.navercorp.rankedsns.user.service.UserService;
import com.navercorp.rankedsns.user.vo.UserVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class PostController {
	@Autowired
	PostService postService;
	@Autowired
	UserService userService;

	@PostMapping(value = "addpost")
	public String addPost(HttpSession session, PostVO postVO, boolean mainPost) {
		log.info("addpost : " + postVO);
		UserVO userVO = (UserVO)session.getAttribute("userVO");
		postVO.setUserId(userVO.getUserId());
		int newPostId = postService.addPost(postVO);
		if (mainPost) {
			UserVO vo = new UserVO();
			vo.setUserId(userVO.getUserId());
			vo.setMainPostId(newPostId);
			log.info("set main_post_id : " + vo.toString());

			userService.setUser(vo);
		}
		return "redirect:timeline?userId=" + userVO.getUserId();
	}

	@PostMapping(value = "editpost")
	public String editPost(HttpSession session, PostVO postVO, boolean mainPost) {
		log.info("postId : " + postVO.getPostId());
		UserVO userVO = (UserVO)session.getAttribute("userVO");
		if (userVO != null) {
			postVO.setUserId(userVO.getUserId());
			if (mainPost) {
				UserVO vo = new UserVO();
				vo.setUserId(userVO.getUserId());
				vo.setMainPostId(postVO.getPostId());

				log.info("set main_post_id : " + vo.toString());

				userService.setUser(vo);
			}
			postService.setPost(postVO);
		}
		return "redirect:timeline?userId=" + userVO.getUserId();
	}
	@PostMapping(value = "deletepost")
	public String deletePost(HttpSession session, int postId) {
		UserVO userVO = (UserVO)session.getAttribute("userVO");
		log.info("postId : " + postId);
		postService.deletePost(postId);
		return "redirect:timeline?userId=" + userVO.getUserId();
	}
	
}
