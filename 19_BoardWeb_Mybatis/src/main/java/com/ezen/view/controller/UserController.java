package com.ezen.view.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.biz.dto.UserVO;
import com.ezen.biz.service.UserService;

@Controller
@SessionAttributes("loginUser")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String loginView(@ModelAttribute("user") UserVO vo) {
		System.out.println("[로그인] 화면으로 이동");
		
		//get방식으로 login.do 이동할 때 커맨드 객체에 등록된 객체를 사용
		vo.setId("heysh");
		vo.setPassword("1234");
		
		return "login.jsp"; 
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	//기존 String 타입에서 ModelAndView 타입으로 변경
	public String login(UserVO vo, HttpSession session, Model model) throws IllegalAccessException {
		System.out.println("[로그인] 처리");
		
		//예외처리 - 아이디 기재X 
		if(vo.getId() == null || vo.getId().equals("")) {
			throw new IllegalAccessException("아이디를 입력해주세요.");
		}
		
		UserVO user = userService.getUser(vo);
		
		//화면 응답 처리
		//ModelAndView에 값을 저장해서 리턴해줄거야
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

		System.out.println("[Log-Out] 처리");

		modelView.setViewName("login.jsp");
		
		return modelView;
		
	}
}
