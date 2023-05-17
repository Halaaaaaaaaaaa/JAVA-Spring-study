package com.ezen.view.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.biz.dao.BoardDAO;
import com.ezen.biz.dto.BoardVO;

public class GetBoardListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("[게시글 목록 조회] 처리");
		
		BoardDAO boardDao = new BoardDAO();
		List<BoardVO> boardList = boardDao.getBoardList();
		
		//사용자가 요청 시 서버와 브라우저에 있는 사용자의 session 저장해서 이를 통해 서버에 있는 정보를 매칭시켜주고
		HttpSession session = request.getSession();
		session.setAttribute("boardList", boardList);
		
		//해당 jsp파일을 리턴한다.		
		return "getBoardList";
	}

}
