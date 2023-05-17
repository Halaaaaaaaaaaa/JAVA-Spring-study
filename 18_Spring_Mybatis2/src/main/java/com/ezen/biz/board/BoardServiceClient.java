package com.ezen.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.ezen.biz.dto.BoardVO;
import com.ezen.biz.service.BoardService;

public class BoardServiceClient {

	private static BoardService boardService;
	
	public static void main(String[] args) {
		//BoardDAO ��ü ����
		//BoardDAO boardDao = new BoardDAO();
		
		//��ü�̳� ����
		AbstractApplicationContext container = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		//�����̳ʿ��� boardService ��ü ���� �޴� ���
		boardService = (BoardService)container.getBean("boardService");
		
		//�Խñ� ���� �� ����
		BoardVO vo = new BoardVO();
			vo.setTitle("MyBatis Title test");
			vo.setWriter("�輼��");
			vo.setContent("MyBatis test ����");
		boardService.insertBoard(vo);
		
		//�˻�
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		
		//�Խñ� ��� ��ȸ
		List<BoardVO> boardList = boardService.getBoardList(vo);
		
		System.out.println("<<< �Խñ� ��� >>>");
		for (BoardVO board : boardList) { 
			System.out.println("-- " + board); 
		}

		container.close();
	}

}
