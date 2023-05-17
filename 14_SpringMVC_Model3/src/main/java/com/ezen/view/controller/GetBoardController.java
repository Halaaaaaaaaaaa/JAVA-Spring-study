package com.ezen.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.biz.dao.BoardDAO;
import com.ezen.biz.dto.BoardVO;

public class GetBoardController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("[�Խñ� �� ��ȸ] ó��");
		// �Խñ� ��ȣ �Է°� ����
		///getBoard.do ȣ�� ������ seq �޾Ƽ� ����
		String seq = request.getParameter("seq");

		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		
		BoardDAO boardDao = new BoardDAO();
		BoardVO board = boardDao.getBoard(vo);
		
		//���� ȭ�� ����
		HttpSession session = request.getSession();
		session.setAttribute("board", board);
		
		//getBoard.jsp ���ǿ� ����� ������ ����ڿ��� �����ؼ� ����
		return "getBoard";
	}

}
