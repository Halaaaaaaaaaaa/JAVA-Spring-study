package com.ezen.biz.common;

//포인트컷으로 지정된 메소드 호출 시, 메소드가 실행되기 전에 처리할 내용들을 지정하기 위해 사용
public class BeforeAdvice {
	
	public void beforeLog() {
		System.out.println("*** [사전 처리] 비즈니스 로직 수행 전 작업 ***");
	}

}
