package com.ezen.biz.board;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.ezen.biz.dto.UserVO;
import com.ezen.biz.service.UserService;

public class UserServiceClient {
	private static UserService userService;
	
	public static void main(String[] args) {
		// ������ �����̳� ����
		AbstractApplicationContext container =
				new GenericXmlApplicationContext("applicationContext.xml");
		
		userService = (UserService)container.getBean("userService");
		
		UserVO user = new UserVO();
		user.setId("spring_user");
		user.setPassword("1234");
		
		UserVO result = userService.getUser(user);
		
		if (result != null) {
			System.out.println("�α��� ����!");
		} else {
			System.out.println("�α��� ����...");
		}
		
		container.close();
		
	}

}
