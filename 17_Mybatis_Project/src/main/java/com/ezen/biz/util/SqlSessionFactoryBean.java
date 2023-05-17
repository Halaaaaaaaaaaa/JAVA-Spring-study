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
				//설정 정보를 읽기 위한 입력 스트림 생성
				Reader reader = Resources.getResourceAsReader("sql-map-config.xml"); 
				//입력 스트림을 통해 설정 정보를 읽어와 SqlSessionFactory 객체 생성
				sessionFactory = new SqlSessionFactoryBuilder().build(reader); 
			} catch(IOException e) { 
				e.printStackTrace(); 
			} 
		} 
	}
	
	//sql-map-confif 파일의 data source 설정을 읽어서 db 연결 후, session 객체를 리턴. 
	//session 리턴하면 select/insert/update/delete 기능을 dao에서 실행 
	public static SqlSession getSqlSessionInstance() { 
		//SqlSessionFactory 객체로 부터 SqlSession 객체를 얻어와(getSqlSessionInstance) 리턴
		return sessionFactory.openSession(); 
	}
	
}
