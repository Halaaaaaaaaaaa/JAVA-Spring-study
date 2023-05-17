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
		// 첫번째 인자("namespace.id"): 실행될 SQL의 id 
		// 두번째 인자(vo): parameterType 속성으로 지정된 파라미터 객체
		// mybatis 세션을 얻어온다.
		System.out.println("===> MyBatis로 insertBoard() 기능 처리 ");
		mybatis.insert("BoardMapper.insertBoard", vo);  
	}
	
	public void updateBoard(BoardVO vo) { 
		System.out.println("===> MyBatis로 updateBoard() 기능 처리 ");
		mybatis.update("BoardMapper.updateBoard", vo); 
	}
	
	public void deleteBoard(BoardVO vo) { 
		System.out.println("===> MyBatis로 deleteBoard() 기능 처리 ");
		mybatis.delete("BoardMapper.deleteBoard", vo);
	}
	
	public BoardVO getBoard(BoardVO vo) { 
		System.out.println("===> MyBatis로 getBoard() 기능 처리 ");
		return (BoardVO)mybatis.selectOne("BoardMapper.getBoard", vo); 
	}
	
	public List<BoardVO> getBoardList(BoardVO vo) { 
		System.out.println("===> MyBatis로 getBoardList() 기능 처리 ");
		return mybatis.selectList("BoardMapper.getBoardList", vo); 
	}


}



