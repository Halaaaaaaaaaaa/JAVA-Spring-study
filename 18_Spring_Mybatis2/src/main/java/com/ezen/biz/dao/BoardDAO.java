package com.ezen.biz.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezen.biz.dto.BoardVO;

//@Repository("boardDAO")
public class BoardDAO extends SqlSessionDaoSupport {
	
	//부모 클래스의 세션 생성 메소드를 호출하여 db에 연결한 세션 생성
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	public void insertBoard(BoardVO vo) { 
		// 첫번째 인자("namespace.id"): 실행될 SQL의 id 
		// 두번째 인자(vo): parameterType 속성으로 지정된 파라미터 객체
		// 부모 클래스의 getSqlSession()을 호출하여 세션을 얻어온다.
		System.out.println("===> MyBatis로 insertBoard() 기능 처리 ");
		getSqlSession().insert("BoardMapper.insertBoard", vo);  
	}
	
	public void updateBoard(BoardVO vo) { 
		System.out.println("===> MyBatis로 updateBoard() 기능 처리 ");
		getSqlSession().update("BoardMapper.updateBoard", vo); 
	}
	
	public void deleteBoard(BoardVO vo) { 
		System.out.println("===> MyBatis로 deleteBoard() 기능 처리 ");
		getSqlSession().delete("BoardMapper.deleteBoard", vo);
	}
	
	public BoardVO getBoard(BoardVO vo) { 
		System.out.println("===> MyBatis로 getBoard() 기능 처리 ");
		return (BoardVO)getSqlSession().selectOne("BoardMapper.getBoard", vo); 
	}
	
	public List<BoardVO> getBoardList(BoardVO vo) { 
		System.out.println("===> MyBatis로 getBoardList() 기능 처리 ");
		return getSqlSession().selectList("BoardMapper.getBoardList", vo); 
	}


}



