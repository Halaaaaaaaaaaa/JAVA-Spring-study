package com.ezen.biz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ezen.biz.common.JDBCUtil;
import com.ezen.biz.dto.BoardVO;

@Repository("boardDAO")
public class BoardDAO {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	private static final String INSERT_BOARD = 
			"INSERT INTO board(seq, title, writer, content) " + 
			"VALUES(board_seq.NEXTVAL, ?, ?, ? )";
	private static final String UPDATE_BOARD = 
			"UPDATE board SET title = ?, writer = ?, content = ?" + 
			"WHERE seq = ?";
	private static final String DELETE_BOARD =
			"DELETE FROM board WHERE seq = ?";
	private static final String GET_BOARD = 
			"SELECT * FROM board WHERE seq = ?";
	private static final String GET_BOARD_LIST =
			"SELECT * FROM board";
	
	//�Խñ� insert
	public void insertBoard(BoardVO board) {
		System.out.println("<<- JDBC�� insertBoard() ó�� ->>");
		
		try {
			//1. DB����
			conn = JDBCUtil.getConnection();
			
			//2.SQL ����
			pstmt = conn.prepareStatement(INSERT_BOARD);
				pstmt.setString(1, board.getTitle());
				pstmt.setString(2, board.getWriter());
				pstmt.setString(3, board.getContent());
			
			//3.SQL ����
			pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			// (4) �����ͺ��̽� ���� ����
			JDBCUtil.close(conn, pstmt);
		}
	}
	
	//update
	public void updateBoard(BoardVO board) {
		System.out.println("<<- JDBC�� updateBoard() ó�� ->>");
		
		try {
			//1. db����
			conn = JDBCUtil.getConnection();
			
			//2. Sql ����
			pstmt = conn.prepareStatement(UPDATE_BOARD);
				pstmt.setString(1, board.getTitle());
				pstmt.setString(2, board.getWriter());
				pstmt.setString(3, board.getContent());
				pstmt.setInt(4, board.getSeq());
				
			//3.SQL ����
			pstmt.executeUpdate();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			//4. �����ͺ��̽� ���� ����
			JDBCUtil.close(conn, pstmt);
		}
	}
	
	//delete
	public void deleteBoard(BoardVO board) {
		System.out.println("<<- JDBC�� deleteBoard() ó�� ->>");
		
		try {
			//1. db����
			conn = JDBCUtil.getConnection();
			
			//2. Sql ����
			pstmt = conn.prepareStatement(DELETE_BOARD);
				pstmt.setInt(1, board.getSeq());
			
			//3.SQL ����
			pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			//4. db ���� ����
			JDBCUtil.close(conn, pstmt);
		}
		
	}
	
	//�Խñ� �� ���� ��ȸ
	public BoardVO getBoard(BoardVO board) {
		//logging ó�� - spring���� �ڵ������� �α� ó�� ����
		System.out.println("<<- JDBC�� getBoard() ó�� ->>");
		
		BoardVO result = null;
		
		try {
			//1. db����
			conn = JDBCUtil.getConnection();
			
			//2. Sql ����
			pstmt = conn.prepareStatement(GET_BOARD);
				pstmt.setInt(1, board.getSeq());
			
			//3.sql ����
			rs = pstmt.executeQuery();
			result = new BoardVO();
		
			if(rs.next()) {
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
			//4. db ���� ����
			JDBCUtil.close(conn, pstmt, rs);
		}
		return result;
	}
	
	public List<BoardVO> getBoardList() {
		System.out.println("<<- JDBC�� getBoardList() ó�� ->>");
		List<BoardVO> boardList = new ArrayList<>();
		
		try {
			//1. db����
			conn = JDBCUtil.getConnection();
			
			//2. Sql ���� - w������ ���� ������ �Ķ���� ������ �ʿ� ����
			pstmt = conn.prepareStatement(GET_BOARD_LIST);
			
			//3.sql ����
			rs = pstmt.executeQuery();
		
			while(rs.next()) {
				BoardVO result = new BoardVO();
				result.setSeq(rs.getInt(1));
				result.setTitle(rs.getString(2));
				result.setWriter(rs.getString(3));
				result.setContent(rs.getString(4));
				result.setRegDate(rs.getDate(5));
				result.setCnt(rs.getInt(6));
				
				boardList.add(result);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			//4. db ���� ����
			JDBCUtil.close(conn, pstmt, rs);
		}
		return boardList;
	}
	
	
}
