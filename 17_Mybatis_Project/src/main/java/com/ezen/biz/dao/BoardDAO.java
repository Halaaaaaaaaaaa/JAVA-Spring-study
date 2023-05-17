package com.ezen.biz.dao;

import java.util.*;

import org.apache.ibatis.session.SqlSession;

import com.ezen.biz.dto.BoardVO;
import com.ezen.biz.util.SqlSessionFactoryBean;

public class BoardDAO {
	//db ���� ��ü
	private SqlSession mybatis;
	
	//boardDAO �����ڸ� ���ؼ� db ���� ��ü(SqlSession ��ü)�� ���� ����
	public BoardDAO() { 
		//SqlSessionFactoryBean�� �̿��Ͽ� getSqlSessionInstance ��ü�� ���´�.
		mybatis = SqlSessionFactoryBean.getSqlSessionInstance(); 
	}
	
	public void insertBoard(BoardVO vo) { 
		// ù��° ����("namespace.id"): ����� SQL�� id 
		// �ι�° ����(vo): parameterType �Ӽ����� ������ �Ķ���� ��ü
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



