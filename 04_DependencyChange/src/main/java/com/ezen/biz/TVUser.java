package com.ezen.biz;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		
		//1. ������ �����̳� ����
		//ȯ�� ���� ������ applicationContext.xml�� �ε��Ͽ� ������ �����̳� �� �ϳ��� GenericXmlApplicationContext�� ����
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		//2. ������ ��ü�̳ʿ��� �ʿ��� ��ü ��û = Lookup
		//applicationContext.xml���� ������ TV ��ü�� ���� �´�
		
		System.out.println("\n============[ ������ ���� ��� ]============");
		TV tv = (TV)container.getBean("tv");
			tv.powerOn();
			tv.volumeUp();
			tv.volumeDown();
			tv.powerOff();
		
		System.out.println("\n===========[ Setter ���� ��� ]===========");
		TV tv2 = (TV)container.getBean("tv2");
			tv2.powerOn();
			tv2.volumeUp();
			tv2.volumeDown();
			tv2.powerOff();
		
		System.out.println("\n===========[ ���ӽ����̽� ��� ]============");
		TV tv3 = (TV)container.getBean("tv3");
			tv3.powerOn();
			tv3.volumeUp();
			tv3.volumeDown();
			tv3.powerOff();
			
		container.close();
	}
}
