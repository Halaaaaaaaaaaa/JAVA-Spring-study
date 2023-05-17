package com.ezen.biz.common;

import org.aspectj.lang.JoinPoint;

//포인트컷으로 지정된 메소드 호출 시, 메소드가 실행되기 전에 처리할 내용들을 지정하기 위해 사용
public class BeforeAdvice {
	
	public void myadvice(JoinPoint jp) {
		System.out.println(" 부가 기능 수행 !"); 
	}


}
