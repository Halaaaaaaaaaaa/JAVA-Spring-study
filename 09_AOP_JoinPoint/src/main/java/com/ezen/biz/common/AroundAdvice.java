package com.ezen.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class AroundAdvice {
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("\n*** [Before] 비즈니스 메소드 수행 전 작업 ***");
		String  method  = pjp.getSignature().getName();

		StopWatch stopWatch = new StopWatch(); 
		stopWatch.start();
		
		//비즈니스 메소드 호출 처리
		//비즈니스 메소드 호출 후 리턴값을 가져와 저장
		//메소드를 호출했는데 여기서 예외가 발생하면 그 예외 처리를 호출한 쪽으로 보내서 그쪽에서 알아서 처리해주라고 던짐
		//비즈니스 메소드 호출 전/후로 메세지 줌
		//메소드 호출 전에 시작 시간을 저장해놓고 메소드 호출해서 비즈니스 로직 수행 하고 로직 수행 후에 시간 스톱해서 수행 시간 출력
		Object returnObj = pjp.proceed();
		
		stopWatch.stop();
		
		System.out.println("*** [After] 비즈니스 메소드 수행 후 작업 ***");
		System.out.printf("*** [After] %s() 수행에 걸린 시간: %s(ms)초 ***", method, stopWatch.getTotalTimeMillis());
		
		return returnObj;
		
	}

}
