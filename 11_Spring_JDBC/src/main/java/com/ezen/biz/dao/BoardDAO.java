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
	
	//applicationContext.xml에 등록된 객체 요청
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/* 
	private static final String INSERT_BOARD = "INSERT INTO board(seq, title, writer, content) " +
												"VALUES(board_seq.NEXTVAL, ?, ?, ?)";
	*/
	//↓ 트랜잭션 처리 테스트용 seq 사용하지 않고 ? 사용
	private static final String INSERT_BOARD = "INSERT INTO board(seq, title, writer, content) " +
												"VALUES(?, ?, ?, ?)";
	
	private static final String UPDATE_BOARD = "UPDATE board SET title=?, writer=?, content=? " +
												"WHERE seq=?";
	
	private static final String DELETE_BOARD = "DELETE board WHERE seq=?";
	
	private static final String GET_BOARD = "SELECT * FROM board WHERE seq=?";
	
	private static final String GET_BOARD_LIST = "SELECT * FROM board";
	
	// 게시글 insert
	public void insertBoard(BoardVO board) {
		System.out.println("\n===> JDBC로 insertBoard() 처리");
		
		//jdbcTemplate.update(INSERT_BOARD, board.getTitle(), board.getWriter(), board.getContent());
		//↓ 트랜잭션 처리 테스트용 
		jdbcTemplate.update(INSERT_BOARD, board.getSeq(), board.getTitle(), board.getWriter(), board.getContent());
	}
	
	// 게시글 update
	public void updateBoard(BoardVO board) {
		System.out.println("\n===> JDBC로 updateBoard() 처리");
		Object[] args = {board.getTitle(), board.getWriter(), board.getContent(), board.getSeq()};
		
		jdbcTemplate.update(UPDATE_BOARD, args);
	}
	
	//게시글 delete
	public void deleteBoard(BoardVO board) {
		System.out.println("\n===> JDBC로 deleteBoard() 처리");
		Object[] args = {board.getSeq()};
		
		jdbcTemplate.update(DELETE_BOARD, args);
	}
	
	// 게시글 정보 조회 - 정보 조회는 query() 사용
	public BoardVO getBoard(BoardVO board) {
		System.out.println("\n===> JDBC로 getBoard() 처리");
		Object[] args = {board.getSeq()};
		
		//원래는 아래와 같이 객체 생성 후 변수에 주입해서 전달하지만
		//BoradVO board = (BoardVO) jdbcTemplate.queryForObject(GET_BOARD, args, new BoardRowMapper()); 
		//여기서는 그렇게 하지 않고 안에 객체 생성(new BoardRowMapper())을 넣어준다.
		//이렇게 => jdbcTemplate.queryForObject(GET_BOARD, args, new BoardRowMapper());
		//그리고 위의 값을 return 하기 위해 return 뒤에 기재
		return jdbcTemplate.queryForObject(GET_BOARD, args, new BoardRowMapper());
	}

	// 게시글 상세 정보 조회 - 정보 조회는 query() 사용
	public List<BoardVO> getBoardList() {
		System.out.println("\n===> JDBC로 getBoardList() 처리");
		
		return jdbcTemplate.query(GET_BOARD_LIST, new BoardRowMapper());
	}

	//return 해야하니까아 getBoard(), getBoardList()
	class BoardRowMapper implements RowMapper<BoardVO> {

		@Override //ResultSet 얘를 BoardVO 여기에 집어 넣을거야
		public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			BoardVO board = new BoardVO();
				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setRegDate(rs.getDate("regDate"));
				board.setCnt(rs.getInt("cnt"));
			
			return board;
		}
		
	}
}

