package com.ezen.biz.service;

import com.ezen.biz.dao.UserDAO;
import com.ezen.biz.dto.UserVO;


public class UserServiceImpl implements UserService {

	private UserDAO userDAO;
	
	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public UserVO getUser(UserVO vo) {
		return userDAO.getUser(vo);
	}

}
