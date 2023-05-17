package com.ezen.biz.common;

//LogAdvice
//비즈니스 로직 처리 중간에 처리정보를 추력해주는 클래스
//어떤 작업을 처리하는지 상태를 파악할 수 있음
//에러 발생 시 어떤 작업 실행 시 에러가 발생하는지 알 수 있네요
public class LogAdvice {
	
	public void printLog() {
		System.out.println("*** [공통 로그] 비즈니스 로직 수행 전 작업 ***");
	}
	
}











