package com.ezen.biz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import org.springframework.stereotype.Repository;

import com.ezen.biz.common.JDBCUtil;
import com.ezen.biz.dto.BoardVO;

@Repository("boardDAO")
public class BoardDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	private static final String BOARD_INSERT =
			"INSERT INTO board(seq, title, writer, content) " +
			"VALUES(board_seq.NEXTVAL, ?, ?, ?)";
	private static final String BOARD_UPDATE =
			"UPDATE board SET title=?, writer=?, content=? " +
			"WHERE seq=?";
	private static final String DELETE_BOARD = 
			"DELETE board WHERE seq=?";
	private static final String GET_BOARD =
			"SELECT * FROM board WHERE seq=?";
	private static final String GET_BOARD_LIST =
			"SELECT * FROM board";
	
	// 게시글 insert
	public void insertBoard(BoardVO board) {
		System.out.println("===> JDBC로 insertBoard() 처리");
		
		try {
			// (1) 데이터베이스 연결
			conn = JDBCUtil.getConnection();
			
			// (2) SQL 구문 준비
			pstmt = conn.prepareStatement(BOARD_INSERT);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());
			
			// (3) SQL 실행
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			// (4) 데이터베이스 연결 해지
			JDBCUtil.close(conn, pstmt);
		}
	}
	
	// 게시글 수정
	public void updateBoard(BoardVO board) {
		System.out.println("===> JDBC로 updateBoard() 처리");
	
		try {
			// (1) 데이터베이스 연결
			conn = JDBCUtil.getConnection();
			
			// (2) SQL 구문 준비
			pstmt = conn.prepareStatement(BOARD_UPDATE);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());
			pstmt.setInt(4, board.getSeq());
			
			// (3) SQL 실행
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			// (4) 데이터베이스 연결 해지
			JDBCUtil.close(conn, pstmt);
		}
		
	}
	
	public void deleteBoard(BoardVO board) {
		System.out.println("===> JDBC로 deleteBoard() 처리");
		
		try {
			// (1) 데이터베이스 연결
			conn = JDBCUtil.getConnection();
			
			// (2) SQL 구문 준비
			pstmt = conn.prepareStatement(DELETE_BOARD);
			pstmt.setInt(1, board.getSeq());
			
			// (3) SQL문 실행
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			// (4) 데이터베이스 연결 해지
			JDBCUtil.close(conn, pstmt);
		}
	}
	
	// 게시글 상세 정보 조회
	public BoardVO getBoard(BoardVO board) {
		System.out.println("===> JDBC로 getBoard() 처리");
		BoardVO result = null;
		try {
			// (1) 데이터베이스 연결
			conn = JDBCUtil.getConnection();
			
			// (2) SQL 구문 준비
			pstmt = conn.prepareStatement(GET_BOARD);
			
			// (3) SQL문 실행
			rs = pstmt.executeQuery();
			
			result = new BoardVO();
			if (rs.next()) {
				result.setSeq(rs.getInt("seq"));
				result.setTitle(rs.getString("title"));
				result.setWriter(rs.getString("writer"));
				result.setContent(rs.getString("content"));
				result.setRegDate(rs.getDate("regDate"));
				result.setCnt(rs.getInt("cnt"));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			// (4) 데이터베이스 연결 해지
			JDBCUtil.close(conn, pstmt, rs);
		}
		
		return result;
	}
	
	public List<BoardVO> getBoardList() {
		System.out.println("===> JDBC로 getBoardList() 처리");
		List<BoardVO> boardList = new ArrayList<>();
		
		try {
			// (1) 데이터베이스 연결
			conn = JDBCUtil.getConnection();
			
			// (2) SQL 구문 준비
			pstmt = conn.prepareStatement(GET_BOARD_LIST);
			
			// (3) SQL문 실행
			rs = pstmt.executeQuery();
			
			
			while (rs.next()) {
				BoardVO result = new BoardVO();
				
				result.setSeq(rs.getInt("seq"));
				result.setTitle(rs.getString("title"));
				result.setWriter(rs.getString("writer"));
				result.setContent(rs.getString("content"));
				result.setRegDate(rs.getDate("regDate"));
				result.setCnt(rs.getInt("cnt"));
				
				boardList.add(result);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			// (4) 데이터베이스 연결 해지
			JDBCUtil.close(conn, pstmt, rs);
		}
		
		return boardList;
	}
}






