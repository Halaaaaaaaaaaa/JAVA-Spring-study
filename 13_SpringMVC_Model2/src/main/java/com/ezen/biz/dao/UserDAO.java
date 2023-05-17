package com.ezen.biz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.ezen.biz.common.JDBCUtil;
import com.ezen.biz.dto.UserVO;

public class UserDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private static final String GET_USER =
			"SELECT * FROM users WHERE id=? AND password=?";
	
	// ����� ��ȸ
	public UserVO getUser(UserVO vo) {
		System.out.println("===> JDBC�� getUser() ó��");
		UserVO result = null;
		
		try {
			// (1) �����ͺ��̽� ����
			conn = JDBCUtil.getConnection();
			
			// (2) SQL ���� �غ�
			pstmt = conn.prepareStatement(GET_USER);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			
			// (3) SQL�� ����
			rs = pstmt.executeQuery();
			
			if (rs.next()) { // ��ȸ�� ����� ������ UserVO ��ü�� �����Ѵ�.
				result = new UserVO();
				result.setId(rs.getString("id"));
				result.setPassword(rs.getString("password"));
				result.setName(rs.getString("name"));
				result.setRole(rs.getString("role"));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			// (4) �����ͺ��̽� ���� ����
			JDBCUtil.close(conn, pstmt, rs);
		}
		
		return result;
	}
}
