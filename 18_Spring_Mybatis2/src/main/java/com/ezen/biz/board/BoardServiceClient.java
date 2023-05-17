package com.ezen.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.ezen.biz.dto.BoardVO;
import com.ezen.biz.service.BoardService;

public class BoardServiceClient {

	private static BoardService boardService;
	
	public static void main(String[] args) {
		//BoardDAO 객체 생성
		//BoardDAO boardDao = new BoardDAO();
		
		//컨체이너 생성
		AbstractApplicationContext container = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		//컨테이너에서 boardService 객체 제공 받는 기능
		boardService = (BoardService)container.getBean("boardService");
		
		//게시글 생성 및 저장
		BoardVO vo = new BoardVO();
			vo.setTitle("MyBatis Title test");
			vo.setWriter("김세현");
			vo.setContent("MyBatis test 내용");
		boardService.insertBoard(vo);
		
		//검색
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		
		//게시글 목록 조회
		List<BoardVO> boardList = boardService.getBoardList(vo);
		
		System.out.println("<<< 게시글 목록 >>>");
		for (BoardVO board : boardList) { 
			System.out.println("-- " + board); 
		}

		container.close();
	}

}
