package com.ezen.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterThrowingAdvice {
	 
	//@Pointcut("execution(* com.ezen.biz..*Impl.*())") 
	//public void allPointcut() {	}
	
	//예외관련 타입이 Exception에 들어간다
	@AfterThrowing(pointcut="PointcutCommon.allPointcut()", throwing="exceptObj")
	public void exceptionLog(JoinPoint jp, Exception exceptObj) {
		
		String  method = jp.getSignature().getName();

		System.out.printf("*** [AfterThrowing예외 처리] %s() 메소드 수행 중 예외발생 : %s", method, exceptObj.getMessage() + " ***\n");
		
	}
}
