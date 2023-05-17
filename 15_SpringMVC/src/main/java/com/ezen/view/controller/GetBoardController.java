package com.ezen.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.ezen.biz.dao.BoardDAO;
import com.ezen.biz.dto.BoardVO;

public class GetBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("[게시글 상세 조회] 처리");
		// 게시글 번호 입력값 추출
		///getBoard.do 호출 받으면 seq 받아서 전달
		String seq = request.getParameter("seq");

		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		
		BoardDAO boardDao = new BoardDAO();
		BoardVO board = boardDao.getBoard(vo);
		
		ModelAndView modelView = new ModelAndView();
		
		modelView.addObject("board", board);
		modelView.setViewName("getBoard");
		
		return modelView;
	}

}
