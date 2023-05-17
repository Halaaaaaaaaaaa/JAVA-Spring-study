package com.ezen.biz.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezen.biz.dto.BoardVO;

//@Repository("boardDAO")
public class BoardDAO extends SqlSessionDaoSupport {
	
	//�θ� Ŭ������ ���� ���� �޼ҵ带 ȣ���Ͽ� db�� ������ ���� ����
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	public void insertBoard(BoardVO vo) { 
		// ù��° ����("namespace.id"): ����� SQL�� id 
		// �ι�° ����(vo): parameterType �Ӽ����� ������ �Ķ���� ��ü
		// �θ� Ŭ������ getSqlSession()�� ȣ���Ͽ� ������ ���´�.
		System.out.println("===> MyBatis�� insertBoard() ��� ó�� ");
		getSqlSession().insert("BoardMapper.insertBoard", vo);  
	}
	
	public void updateBoard(BoardVO vo) { 
		System.out.println("===> MyBatis�� updateBoard() ��� ó�� ");
		getSqlSession().update("BoardMapper.updateBoard", vo); 
	}
	
	public void deleteBoard(BoardVO vo) { 
		System.out.println("===> MyBatis�� deleteBoard() ��� ó�� ");
		getSqlSession().delete("BoardMapper.deleteBoard", vo);
	}
	
	public BoardVO getBoard(BoardVO vo) { 
		System.out.println("===> MyBatis�� getBoard() ��� ó�� ");
		return (BoardVO)getSqlSession().selectOne("BoardMapper.getBoard", vo); 
	}
	
	public List<BoardVO> getBoardList(BoardVO vo) { 
		System.out.println("===> MyBatis�� getBoardList() ��� ó�� ");
		return getSqlSession().selectList("BoardMapper.getBoardList", vo); 
	}


}



