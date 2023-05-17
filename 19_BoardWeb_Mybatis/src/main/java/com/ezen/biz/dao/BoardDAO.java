package com.ezen.biz.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezen.biz.dto.BoardVO;

@Repository("boardDAO")
public class BoardDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	// 게시글 insert
	public void insertBoard(BoardVO board) {
		System.out.println("===> MyBatis로 insertBoard() 처리");
		
		mybatis.insert("BoardMapper.insertBoard", board);
	}

	
	// 게시글 수정
	public void updateBoard(BoardVO board) {
		System.out.println("===> MyBatis로 updateBoard() 처리");
		
		mybatis.update("BoardMapper.updateBoard", board);		
	}
	
	
	// 게시글 삭제
	public void deleteBoard(BoardVO board) {
		System.out.println("===> MyBatis로 deleteBoard() 처리");
		
		mybatis.delete("BoardMapper.deleteBoard", board);
	}
	
	
	// 게시글 상세 정보 조회
	public BoardVO getBoard(BoardVO board) {
		System.out.println("===> MyBatis로 getBoard() 처리");
		
		return (BoardVO)mybatis.selectOne("BoardMapper.getBoard", board);
	}
	
	
	// 게시글 목록 조회
	public List<BoardVO> getBoardList(BoardVO board) {
		System.out.println("===> MyBatis로 getBoardList() 처리");		
		
		return mybatis.selectList("BoardMapper.getBoardList_D", board);
		
	}	
}
