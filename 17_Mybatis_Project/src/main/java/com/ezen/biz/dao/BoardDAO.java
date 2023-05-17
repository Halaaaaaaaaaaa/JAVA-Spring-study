package com.ezen.biz.dao;

import java.util.*;

import org.apache.ibatis.session.SqlSession;

import com.ezen.biz.dto.BoardVO;
import com.ezen.biz.util.SqlSessionFactoryBean;

public class BoardDAO {
	//db 연결 객체
	private SqlSession mybatis;
	
	//boardDAO 생성자를 통해서 db 연결 객체(SqlSession 객체)를 얻어와 생성
	public BoardDAO() { 
		//SqlSessionFactoryBean을 이용하여 getSqlSessionInstance 객체를 얻어온다.
		mybatis = SqlSessionFactoryBean.getSqlSessionInstance(); 
	}
	
	public void insertBoard(BoardVO vo) { 
		// 첫번째 인자("namespace.id"): 실행될 SQL의 id 
		// 두번째 인자(vo): parameterType 속성으로 지정된 파라미터 객체
		mybatis.insert("BoardMapper.insertBoard", vo); 
		mybatis.commit(); 
	}
	
	public void updateBoard(BoardVO vo) { 
		mybatis.update("BoardMapper.updateBoard", vo); 
		mybatis.commit(); 
	}
	
	public void deleteBoard(BoardVO vo) { 
		mybatis.delete("BoardMapper.deleteBoard", vo);
		mybatis.commit(); 
	}
	
	public BoardVO getBoard(BoardVO vo) { 
		return (BoardVO)mybatis.selectOne("BoardMapper.getBoard", vo); 
	}
	
	public List<BoardVO> getBoardList(BoardVO vo) { 
		return mybatis.selectList("BoardMapper.getBoardList", vo); 
	}


}



