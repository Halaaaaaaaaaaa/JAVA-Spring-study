package com.ezen.biz.board;

import java.util.*;

import com.ezen.biz.dao.BoardDAO;
import com.ezen.biz.dto.BoardVO;

public class BoardServiceClient {

	public static void main(String[] args) {
		//BoardDAO 객체 생성
		BoardDAO boardDao = new BoardDAO();
		
		//게시글 생성 및 저장
		BoardVO vo = new BoardVO();
			vo.setTitle("MyBatis 제목");
			vo.setWriter("김세현");
			vo.setContent("MyBatis test 내용");
		boardDao.insertBoard(vo);
		
		//검색
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		
		//게시글 목록 조회
		List<BoardVO> boardList = boardDao.getBoardList(vo);
		System.out.println("<< 게시글 목록 >>");
		for (BoardVO board : boardList) { 
			System.out.println("---> " + board); 
		}

	}

}
