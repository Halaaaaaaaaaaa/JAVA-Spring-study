package com.ezen.biz.common;

import org.aspectj.lang.JoinPoint;

//����Ʈ������ ������ �޼ҵ� ȣ�� ��, �޼ҵ尡 ����Ǳ� ���� ó���� ������� �����ϱ� ���� ���
public class BeforeAdvice {
	
	public void beforeLog(JoinPoint jp) {
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs(); 
		/* �Ǵ� 
		 Signature sig = jp.getSigature();
		 Sting method = sig.getName();
		 */
		if(args.length == 0) {
			System.out.println("*** [���� ó��] ����Ͻ� ���� ���� �� �۾� ***");
			System.out.printf("*** [���� ó��] %s() ARGS: �������� ���� ***", method);
			//System.out.println("*** [���� ó��] " + method + "() ARGS: ������������. ***");
		} else {
			System.out.println("*** [���� ó��] ����Ͻ� ���� ���� �� �۾� ***");
			System.out.printf("*** [���� ó��] %s() ARGSL %s ***", method, args[0].toString());
			//System.out.println("*** [���� ó��] " + method + "() ARGS: " + args[0].toString() + "***");
		}
	}

}
