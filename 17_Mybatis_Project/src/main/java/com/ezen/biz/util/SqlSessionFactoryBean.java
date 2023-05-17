package com.ezen.biz.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryBean {

	private static SqlSessionFactory sessionFactory = null; 
	
	static { 
		if(sessionFactory == null) { 
			try { 
				//���� ������ �б� ���� �Է� ��Ʈ�� ����
				Reader reader = Resources.getResourceAsReader("sql-map-config.xml"); 
				//�Է� ��Ʈ���� ���� ���� ������ �о�� SqlSessionFactory ��ü ����
				sessionFactory = new SqlSessionFactoryBuilder().build(reader); 
			} catch(IOException e) { 
				e.printStackTrace(); 
			} 
		} 
	}
	
	//sql-map-confif ������ data source ������ �о db ���� ��, session ��ü�� ����. 
	//session �����ϸ� select/insert/update/delete ����� dao���� ���� 
	public static SqlSession getSqlSessionInstance() { 
		//SqlSessionFactory ��ü�� ���� SqlSession ��ü�� ����(getSqlSessionInstance) ����
		return sessionFactory.openSession(); 
	}
	
}
