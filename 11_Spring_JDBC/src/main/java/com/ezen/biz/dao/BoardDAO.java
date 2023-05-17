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
	
	//applicationContext.xml�� ��ϵ� ��ü ��û
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/* 
	private static final String INSERT_BOARD = "INSERT INTO board(seq, title, writer, content) " +
												"VALUES(board_seq.NEXTVAL, ?, ?, ?)";
	*/
	//�� Ʈ����� ó�� �׽�Ʈ�� seq ������� �ʰ� ? ���
	private static final String INSERT_BOARD = "INSERT INTO board(seq, title, writer, content) " +
												"VALUES(?, ?, ?, ?)";
	
	private static final String UPDATE_BOARD = "UPDATE board SET title=?, writer=?, content=? " +
												"WHERE seq=?";
	
	private static final String DELETE_BOARD = "DELETE board WHERE seq=?";
	
	private static final String GET_BOARD = "SELECT * FROM board WHERE seq=?";
	
	private static final String GET_BOARD_LIST = "SELECT * FROM board";
	
	// �Խñ� insert
	public void insertBoard(BoardVO board) {
		System.out.println("\n===> JDBC�� insertBoard() ó��");
		
		//jdbcTemplate.update(INSERT_BOARD, board.getTitle(), board.getWriter(), board.getContent());
		//�� Ʈ����� ó�� �׽�Ʈ�� 
		jdbcTemplate.update(INSERT_BOARD, board.getSeq(), board.getTitle(), board.getWriter(), board.getContent());
	}
	
	// �Խñ� update
	public void updateBoard(BoardVO board) {
		System.out.println("\n===> JDBC�� updateBoard() ó��");
		Object[] args = {board.getTitle(), board.getWriter(), board.getContent(), board.getSeq()};
		
		jdbcTemplate.update(UPDATE_BOARD, args);
	}
	
	//�Խñ� delete
	public void deleteBoard(BoardVO board) {
		System.out.println("\n===> JDBC�� deleteBoard() ó��");
		Object[] args = {board.getSeq()};
		
		jdbcTemplate.update(DELETE_BOARD, args);
	}
	
	// �Խñ� ���� ��ȸ - ���� ��ȸ�� query() ���
	public BoardVO getBoard(BoardVO board) {
		System.out.println("\n===> JDBC�� getBoard() ó��");
		Object[] args = {board.getSeq()};
		
		//������ �Ʒ��� ���� ��ü ���� �� ������ �����ؼ� ����������
		//BoradVO board = (BoardVO) jdbcTemplate.queryForObject(GET_BOARD, args, new BoardRowMapper()); 
		//���⼭�� �׷��� ���� �ʰ� �ȿ� ��ü ����(new BoardRowMapper())�� �־��ش�.
		//�̷��� => jdbcTemplate.queryForObject(GET_BOARD, args, new BoardRowMapper());
		//�׸��� ���� ���� return �ϱ� ���� return �ڿ� ����
		return jdbcTemplate.queryForObject(GET_BOARD, args, new BoardRowMapper());
	}

	// �Խñ� �� ���� ��ȸ - ���� ��ȸ�� query() ���
	public List<BoardVO> getBoardList() {
		System.out.println("\n===> JDBC�� getBoardList() ó��");
		
		return jdbcTemplate.query(GET_BOARD_LIST, new BoardRowMapper());
	}

	//return �ؾ��ϴϱ�� getBoard(), getBoardList()
	class BoardRowMapper implements RowMapper<BoardVO> {

		@Override //ResultSet �긦 BoardVO ���⿡ ���� �����ž�
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

