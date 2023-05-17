package com.ezen.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service 
@Aspect
public class AroundAdvice {
	
	//@Pointcut("execution(* com.ezen.biz..*Impl.*())") 
	//public void allPointcut() {	}
	
	@Around("PointcutCommon.allPointcut()")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("***[Around Before] 비즈니스 메소드 수행 전 작업***");
		String  method  = pjp.getSignature().getName();

		StopWatch stopWatch = new StopWatch(); 
		stopWatch.start();
		
		Object returnObj = pjp.proceed();
		
		stopWatch.stop();
		
		System.out.println("*** [Around After] 비즈니스 메소드 수행 후 작업 ***");
		System.out.printf("*** [Around After] %s() 수행에 걸린 시간: %s(ms)초 ***", method, stopWatch.getTotalTimeMillis());
		
		return returnObj;
		
	}

}
