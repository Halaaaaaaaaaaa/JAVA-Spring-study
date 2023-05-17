package com.ezen.biz.board;

import java.util.*;

import com.ezen.biz.dao.BoardDAO;
import com.ezen.biz.dto.BoardVO;

public class BoardServiceClient {

	public static void main(String[] args) {
		//BoardDAO ��ü ����
		BoardDAO boardDao = new BoardDAO();
		
		//�Խñ� ���� �� ����
		BoardVO vo = new BoardVO();
			vo.setTitle("MyBatis ����");
			vo.setWriter("�輼��");
			vo.setContent("MyBatis test ����");
		boardDao.insertBoard(vo);
		
		//�˻�
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		
		//�Խñ� ��� ��ȸ
		List<BoardVO> boardList = boardDao.getBoardList(vo);
		System.out.println("<< �Խñ� ��� >>");
		for (BoardVO board : boardList) { 
			System.out.println("---> " + board); 
		}

	}

}
