package com.navercorp.rankedsns.user.service;

import java.util.List;

import com.navercorp.rankedsns.user.vo.UserVO;

public interface UserService {
	public int register(UserVO userVO);

	public List<UserVO> getAllUser();

	public void setUser(UserVO userVO);

	public void deleteUser(int userId);
	
	public void setScore(List<UserVO> list);
	
	public int emailCheck(String email);

	public UserVO loginCheck(String userEmail, String userPassword);
}
