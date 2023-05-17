package com.ezen.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;

public class AroundAdvice {
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("*** [Before] 비즈니스 메소드 수행 전 작업 ***");
		
		//비즈니스 메소드 호출 처리
		//비즈니스 메소드 호출 후 리턴값을 가져와 저장
		//메소드를 호출했는데 여기서 예외가 발생하면 그 예외 처리를 호출한 쪽으로 보내서 그쪽에서 알아서 처리해주라고 던짐
		Object returnObj = pjp.proceed();
		
		System.out.println("*** [After] 비즈니스 메소드 수행 후 작업 ***");
		
		return returnObj;
		
	}

}
