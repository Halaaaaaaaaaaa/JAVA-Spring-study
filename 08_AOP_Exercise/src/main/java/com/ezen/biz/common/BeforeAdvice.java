package com.ezen.biz.common;

import org.aspectj.lang.JoinPoint;

//����Ʈ������ ������ �޼ҵ� ȣ�� ��, �޼ҵ尡 ����Ǳ� ���� ó���� ������� �����ϱ� ���� ���
public class BeforeAdvice {
	
	public void myadvice(JoinPoint jp) {
		System.out.println(" �ΰ� ��� ���� !"); 
	}


}
