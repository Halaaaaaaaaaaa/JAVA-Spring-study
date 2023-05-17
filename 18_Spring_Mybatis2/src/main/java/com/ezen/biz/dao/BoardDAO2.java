package com.ezen.biz.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezen.biz.dto.BoardVO;

@Repository("boardDAO")
public class BoardDAO2 {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertBoard(BoardVO vo) { 
		// ù��° ����("namespace.id"): ����� SQL�� id 
		// �ι�° ����(vo): parameterType �Ӽ����� ������ �Ķ���� ��ü
		// mybatis ������ ���´�.
		System.out.println("===> MyBatis�� insertBoard() ��� ó�� ");
		mybatis.insert("BoardMapper.insertBoard", vo);  
	}
	
	public void updateBoard(BoardVO vo) { 
		System.out.println("===> MyBatis�� updateBoard() ��� ó�� ");
		mybatis.update("BoardMapper.updateBoard", vo); 
	}
	
	public void deleteBoard(BoardVO vo) { 
		System.out.println("===> MyBatis�� deleteBoard() ��� ó�� ");
		mybatis.delete("BoardMapper.deleteBoard", vo);
	}
	
	public BoardVO getBoard(BoardVO vo) { 
		System.out.println("===> MyBatis�� getBoard() ��� ó�� ");
		return (BoardVO)mybatis.selectOne("BoardMapper.getBoard", vo); 
	}
	
	public List<BoardVO> getBoardList(BoardVO vo) { 
		System.out.println("===> MyBatis�� getBoardList() ��� ó�� ");
		return mybatis.selectList("BoardMapper.getBoardList", vo); 
	}


}



