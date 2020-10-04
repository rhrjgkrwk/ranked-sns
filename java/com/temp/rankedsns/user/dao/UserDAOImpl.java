package com.navercorp.rankedsns.user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.navercorp.rankedsns.user.vo.UserVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
	SqlSession session;

	@Override
	public int addUser(UserVO userVO) {
		// TODO Auto-generated method stub
		return session.insert("user.addUser", userVO);
	}
	
	@Override
	public List<UserVO> getAllUser() {
		// TODO Auto-generated method stub
		return session.selectList("user.getAllUser");
	}

	@Override
	public void setUser(UserVO userVO) {
		// TODO Auto-generated method stub
		session.update("user.setUser", userVO);
	}

	@Override
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub

	}

	@Override
	public int emailCheck(String email) {
		// TODO Auto-generated method stub
		int res = session.selectOne("user.emailCheck", email);
		return res;
	}

	@Override
	public UserVO loginCheck(String userEmail, String userPassword) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		map.put("userEmail", userEmail);
		map.put("userPassword", userPassword);
		UserVO userVO = session.selectOne("user.loginCheck", map);
		log.info("login check : " + userEmail + userPassword + " : " + userVO);
		return userVO;
	}

	@Override
	public void setScore(int userId) {
		// TODO Auto-generated method stub
		session.update("user.setScore", userId);
	}

	@Override
	public int getUserCount() {
		// TODO Auto-generated method stub
		return session.selectOne("user.getUserCount");
	}

	@Override
	public int getUserRank(int userId) {
		// TODO Auto-generated method stub
		return session.selectOne("user.getUserRank", userId);
	}
	
	
	
}
