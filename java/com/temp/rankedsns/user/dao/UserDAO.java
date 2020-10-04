package com.navercorp.rankedsns.user.dao;

import java.util.List;

import com.navercorp.rankedsns.user.vo.UserVO;

public interface UserDAO {
	public int addUser(UserVO userVO);

	public List<UserVO> getAllUser();

	public void setUser(UserVO userVO);

	public void deleteUser(int userId);

	public int emailCheck(String email);

	public UserVO loginCheck(String userEmail, String userPassword);
	
	public void setScore(int userId);
	
	public int getUserRank(int userId);
	
	public int getUserCount();
}
