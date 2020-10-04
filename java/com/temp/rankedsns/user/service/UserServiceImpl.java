package com.navercorp.rankedsns.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.navercorp.rankedsns.user.dao.UserDAO;
import com.navercorp.rankedsns.user.vo.UserVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDAO userDAO;

	@Override
	public int register(UserVO userVO) {
		// TODO Auto-generated method stub
		return userDAO.addUser(userVO);
	}

	@Override
	public List<UserVO> getAllUser() {
		// TODO Auto-generated method stub
		return userDAO.getAllUser();
	}

	@Override
	public void setUser(UserVO userVO) {
		// TODO Auto-generated method stub
		userDAO.setUser(userVO);
	}

	@Override
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub

	}

	@Override
	public int emailCheck(String email) {
		// TODO Auto-generated method stub
		return userDAO.emailCheck(email);
	}

	@Override
	public UserVO loginCheck(String userEmail, String userPassword) {
		// TODO Auto-generated method stub
		return userDAO.loginCheck(userEmail, userPassword);
	}

	@Transactional
	@Override
	public void setScore(List<UserVO> list) {
		// TODO Auto-generated method stub
		log.info("tx start");
		for (UserVO userVO : list) {
			userDAO.setScore(userVO.getUserId());
		}
		log.info("tx end");
	}

}
