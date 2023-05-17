package com.ezen.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service //����Ʈ������ ������ �޼ҵ� ȣ�� ��, �޼ҵ尡 ����Ǳ� ���� ó���� ������� �����ϱ� ���� ���
@Aspect //����Ʈ�ϰ� �����̽��ϰ� Aspect aop ����
public class BeforeAdvice {
	
	//point cut ����: pointcut ������ �޼ҵ带 ()�ȿ� ����
	//@Pointcut("execution(* com.ezen.biz..*Impl.*())") 
	//public void allPointcut() {	}
	
	@Before("PointcutCommon.allPointcut()")
	public void beforeLog(JoinPoint jp) {
		String method = jp.getSignature().getName(); 
		Object[] args = jp.getArgs(); 
		/* �Ǵ� 
		 Signature sig = jp.getSigature();
		 Sting method = sig.getName();
		 */
		if(args.length == 0) {
			System.out.println("*** [Before ���� ó��] ����Ͻ� ���� ���� �� �۾� ***");
			System.out.printf("*** [Before ���� ó��] %s() ARGS: �������� ���� ***", method);
			//System.out.println("*** [���� ó��] " + method + "() ARGS: ������������. ***");
		} else {
			System.out.println("*** [Before ���� ó��] ����Ͻ� ���� ���� �� �۾� ***");
			System.out.printf("*** [Before ���� ó��] %s() ARGSL %s ***", method, args[0].toString());
			//System.out.println("*** [���� ó��] " + method + "() ARGS: " + args[0].toString() + "***");
		}
	}

}
