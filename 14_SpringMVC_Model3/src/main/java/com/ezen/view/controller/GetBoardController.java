package com.ezen.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.biz.dao.BoardDAO;
import com.ezen.biz.dto.BoardVO;

public class GetBoardController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("[게시글 상세 조회] 처리");
		// 게시글 번호 입력값 추출
		///getBoard.do 호출 받으면 seq 받아서 전달
		String seq = request.getParameter("seq");

		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		
		BoardDAO boardDao = new BoardDAO();
		BoardVO board = boardDao.getBoard(vo);
		
		//응답 화면 구성
		HttpSession session = request.getSession();
		session.setAttribute("board", board);
		
		//getBoard.jsp 세션에 저장된 내용을 사용자에게 리턴해서 전달
		return "getBoard";
	}

}
