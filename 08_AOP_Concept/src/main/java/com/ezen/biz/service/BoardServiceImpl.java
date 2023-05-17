package com.ezen.biz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.biz.common.Log4jAdvice;
import com.ezen.biz.common.LogAdvice;
import com.ezen.biz.dao.BoardDAO;
import com.ezen.biz.dto.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO;
	//private LogAdvice log;
	//logging class ���濡 ���� ����
	//private Log4jAdvice log;
		
	public BoardServiceImpl() {
		//log = new LogAdvice();
		//log = new Log4jAdvice();
	}
	
	@Override
	public void insertBoard(BoardVO vo) {
		//log.printLog();
		//log.printLogging();
		/*
		if(vo.getSeq() == 0) {
			throw new IllegalArgumentException("0�� ���� ����� �� �����ϴ� !");
		}
		*/
		
		boardDAO.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		//log.printLog();
		//log.printLogging();
		boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		//log.printLog();
		//log.printLogging();
		boardDAO.deleteBoard(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		//log.printLog();
		//log.printLogging();
		return boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList() {
		//log.printLog();
		//log.printLogging();
		return boardDAO.getBoardList();
	}

}
