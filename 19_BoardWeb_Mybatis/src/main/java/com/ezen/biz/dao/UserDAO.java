package com.ezen.biz.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezen.biz.dto.UserVO;

@Repository("userDAO")
public class UserDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	// 사용자 조회
	public UserVO getUser(UserVO vo) {
		System.out.println("===> MyBatis로 getUser() 처리");

		return (UserVO)mybatis.selectOne("UserMapper.getUser", vo);
	}
}
