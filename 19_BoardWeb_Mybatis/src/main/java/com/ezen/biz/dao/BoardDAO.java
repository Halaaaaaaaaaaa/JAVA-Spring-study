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
	
	// �Խñ� insert
	public void insertBoard(BoardVO board) {
		System.out.println("===> MyBatis�� insertBoard() ó��");
		
		mybatis.insert("BoardMapper.insertBoard", board);
	}

	
	// �Խñ� ����
	public void updateBoard(BoardVO board) {
		System.out.println("===> MyBatis�� updateBoard() ó��");
		
		mybatis.update("BoardMapper.updateBoard", board);		
	}
	
	
	// �Խñ� ����
	public void deleteBoard(BoardVO board) {
		System.out.println("===> MyBatis�� deleteBoard() ó��");
		
		mybatis.delete("BoardMapper.deleteBoard", board);
	}
	
	
	// �Խñ� �� ���� ��ȸ
	public BoardVO getBoard(BoardVO board) {
		System.out.println("===> MyBatis�� getBoard() ó��");
		
		return (BoardVO)mybatis.selectOne("BoardMapper.getBoard", board);
	}
	
	
	// �Խñ� ��� ��ȸ
	public List<BoardVO> getBoardList(BoardVO board) {
		System.out.println("===> MyBatis�� getBoardList() ó��");		
		
		return mybatis.selectList("BoardMapper.getBoardList_D", board);
		
	}	
}
