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
	
	//���ܰ��� Ÿ���� Exception�� ����
	@AfterThrowing(pointcut="PointcutCommon.allPointcut()", throwing="exceptObj")
	public void exceptionLog(JoinPoint jp, Exception exceptObj) {
		
		String  method = jp.getSignature().getName();

		System.out.printf("*** [AfterThrowing���� ó��] %s() �޼ҵ� ���� �� ���ܹ߻� : %s", method, exceptObj.getMessage() + " ***\n");
		
	}
}
