package com.ezen.biz.common;

import org.aspectj.lang.JoinPoint;

//포인트컷으로 지정된 메소드 호출 시, 메소드가 실행되기 전에 처리할 내용들을 지정하기 위해 사용
public class BeforeAdvice {
	
	public void beforeLog(JoinPoint jp) {
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs(); 
		/* 또는 
		 Signature sig = jp.getSigature();
		 Sting method = sig.getName();
		 */
		if(args.length == 0) {
			System.out.println("*** [사전 처리] 비즈니스 로직 수행 전 작업 ***");
			System.out.printf("*** [사전 처리] %s() ARGS: 존재하지 않음 ***", method);
			//System.out.println("*** [사전 처리] " + method + "() ARGS: 존재하지않음. ***");
		} else {
			System.out.println("*** [사전 처리] 비즈니스 로직 수행 전 작업 ***");
			System.out.printf("*** [사전 처리] %s() ARGSL %s ***", method, args[0].toString());
			//System.out.println("*** [사전 처리] " + method + "() ARGS: " + args[0].toString() + "***");
		}
	}

}
