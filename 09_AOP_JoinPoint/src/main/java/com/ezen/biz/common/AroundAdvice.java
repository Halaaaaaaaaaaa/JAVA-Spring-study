package com.ezen.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class AroundAdvice {
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("\n*** [Before] ����Ͻ� �޼ҵ� ���� �� �۾� ***");
		String  method  = pjp.getSignature().getName();

		StopWatch stopWatch = new StopWatch(); 
		stopWatch.start();
		
		//����Ͻ� �޼ҵ� ȣ�� ó��
		//����Ͻ� �޼ҵ� ȣ�� �� ���ϰ��� ������ ����
		//�޼ҵ带 ȣ���ߴµ� ���⼭ ���ܰ� �߻��ϸ� �� ���� ó���� ȣ���� ������ ������ ���ʿ��� �˾Ƽ� ó�����ֶ�� ����
		//����Ͻ� �޼ҵ� ȣ�� ��/�ķ� �޼��� ��
		//�޼ҵ� ȣ�� ���� ���� �ð��� �����س��� �޼ҵ� ȣ���ؼ� ����Ͻ� ���� ���� �ϰ� ���� ���� �Ŀ� �ð� �����ؼ� ���� �ð� ���
		Object returnObj = pjp.proceed();
		
		stopWatch.stop();
		
		System.out.println("*** [After] ����Ͻ� �޼ҵ� ���� �� �۾� ***");
		System.out.printf("*** [After] %s() ���࿡ �ɸ� �ð�: %s(ms)�� ***", method, stopWatch.getTotalTimeMillis());
		
		return returnObj;
		
	}

}
