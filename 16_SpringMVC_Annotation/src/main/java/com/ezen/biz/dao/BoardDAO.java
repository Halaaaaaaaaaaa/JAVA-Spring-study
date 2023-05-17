package com.ezen.biz.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ezen.biz.dto.BoardVO;

@Repository("boardDAO")
public class BoardDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/* */
	private static final String BOARD_INSERT =
			"INSERT INTO board(seq, title, writer, content) " +
			"VALUES(board_seq.NEXTVAL, ?, ?, ?)"; 
	
	/* 트랜잭션 처리 테스트용
	private static final String BOARD_INSERT =
			"INSERT INTO board(seq, title, writer, content) " +
			"VALUES(?, ?, ?, ?)"; */
	private static final String BOARD_UPDATE =
			"UPDATE board SET title=?, writer=?, content=? " +
			"WHERE seq=?";
	private static final String DELETE_BOARD = 
			"DELETE board WHERE seq=?";
	private static final String GET_BOARD =
			"SELECT * FROM board WHERE seq=?";
	private static final String GET_BOARD_LIST =
			"SELECT * FROM board";
	//게시글 검색 조회를 위한 SQL 추가
	private static final String GET_BOARD_LIST_T =
			"SELECT * FROM board WHERE title LIKE '%'||?||'%'" + 
					"ORDER BY seq";
	private static final String GET_BOARD_LIST_C =
			"SELECT * FROM board WHERE content LIKE '%'||?||'%'" +
					"ORDER BY seq";
	
	// 게시글 insert
	public void insertBoard(BoardVO board) {
		System.out.println("===> JDBC로 insertBoard() 처리");
		
		/**/
		jdbcTemplate.update(BOARD_INSERT, 
					board.getTitle(), board.getWriter(), board.getContent());
		
		/* 트랜잭션 처리 테스트용 
		jdbcTemplate.update(BOARD_INSERT, 
				board.getSeq(), board.getTitle(), board.getWriter(), board.getContent());*/
		
	}

	
	// 게시글 수정
	public void updateBoard(BoardVO board) {
		System.out.println("===> JDBC로 updateBoard() 처리");
		Object[] args = {board.getTitle(), board.getWriter(),
						board.getContent(), board.getSeq()};
		
		jdbcTemplate.update(BOARD_UPDATE, args);		
	}
	
	
	// 게시글 삭제
	public void deleteBoard(BoardVO board) {
		System.out.println("===> JDBC로 deleteBoard() 처리");
		Object[] args = {board.getSeq()};
		
		jdbcTemplate.update(DELETE_BOARD, args);
	}
	
	
	// 게시글 상세 정보 조회
	public BoardVO getBoard(BoardVO board) {
		System.out.println("===> JDBC로 getBoard() 처리");
		Object[] args = {board.getSeq()};
		
		return jdbcTemplate.queryForObject(GET_BOARD, args, new BoardRowMapper());
	}
	
	
	// 게시글 목록 조회
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> JDBC로 getBoardList() 처리");		
		
		List<BoardVO> boardList = null;
		Object[] args = {vo.getSearchKeyword()};
		
		//게시글 검색 조회
		if(vo.getSearchCondition().equals("TITLE")) {
			boardList = jdbcTemplate.query(GET_BOARD_LIST_T, args, new BoardRowMapper());
		} else if(vo.getSearchCondition().equals("CONTENT")) {
			boardList = jdbcTemplate.query(GET_BOARD_LIST_C, args, new BoardRowMapper());
		}
		return boardList;
	}
	
	
	class BoardRowMapper implements RowMapper<BoardVO> {

		@Override
		public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			BoardVO board = new BoardVO();
			
			board.setSeq(rs.getInt("seq"));
			board.setTitle(rs.getString("title"));
			board.setWriter(rs.getString("writer"));
			board.setContent(rs.getString("content"));
			board.setRegDate(rs.getDate("regDate"));
			board.setCnt(rs.getInt("cnt"));
			
			return board;
		}
		
	}
	
}






