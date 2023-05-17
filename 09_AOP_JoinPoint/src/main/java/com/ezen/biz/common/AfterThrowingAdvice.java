package com.ezen.biz.common;

import org.aspectj.lang.JoinPoint;

public class AfterThrowingAdvice {
	
	//예외관련 타입이 Exception에 들어간다
	public void exceptionLog(JoinPoint jp, Exception exceptObj) {
		
		String  method = jp.getSignature().getName();

		System.out.printf("*** [예외 처리] %s() 메소드 수행 중 예외발생 : %s", method, exceptObj.getMessage());
		
	}
}
