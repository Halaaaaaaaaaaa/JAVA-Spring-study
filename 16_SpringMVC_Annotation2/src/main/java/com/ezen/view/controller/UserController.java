package com.ezen.view.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.biz.dao.UserDAO;
import com.ezen.biz.dto.UserVO;

@Controller
@SessionAttributes("loginUser")
public class UserController {
	
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String loginView(@ModelAttribute("user") UserVO vo) {
		System.out.println("[�α���] ȭ������ �̵�");
		
		//get������� login.do �̵��� �� Ŀ�ǵ� ��ü�� ��ϵ� ��ü�� ���
		vo.setId("heysh");
		vo.setPassword("1234");
		
		return "login.jsp"; 
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	//���� String Ÿ�Կ��� ModelAndView Ÿ������ ����
	public String login(UserVO vo, UserDAO userDao, HttpSession session, Model model) throws IllegalAccessException {
		System.out.println("[�α���] ó��");
		
		//����ó�� - ���̵� ����X 
		if(vo.getId() == null || vo.getId().equals("")) {
			throw new IllegalAccessException("���̵� �Է����ּ���.");
		}
		
		UserVO user = userDao.getUser(vo);
		
		//ȭ�� ���� ó��
		//ModelAndView�� ���� �����ؼ� �������ٰž�
		if (user != null) {
			session.setAttribute("userName", user.getName());
			model.addAttribute("loginUser", user);
			return "getBoardList.do";
		} else {
			return "login.jsp";
		}
	}
	
	@RequestMapping("/logout.do")
	public ModelAndView logout(ModelAndView modelView) {

		System.out.println("[Log-Out] ó��");

		modelView.setViewName("login.jsp");
		
		return modelView;
		
	}
}
