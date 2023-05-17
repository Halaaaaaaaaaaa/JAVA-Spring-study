package com.ezen.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

//외부 독립된 PointcutCommon에 별도로 Pointcut 참조하기
@Service
@Aspect
public class PointcutCommon {

	@Pointcut("execution(* com.ezen.biz..*Impl.*(..))") 
	public void allPointcut(){ }
	
	@Pointcut("execution(* com.ezen.biz..*Impl.get*(..))") 
	public void getPointcut(){ }
	
}
