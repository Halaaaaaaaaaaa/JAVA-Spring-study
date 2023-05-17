package com.ezen.biz.Ex1Client;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.ezen.biz.service.Operation;

public class Ex1Client {

	public static void main(String[] args) {
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml"); 
		
		Operation op = (Operation) container.getBean("opBean");
		
		System.out.print("message ȣ�� >>> ");
		op.message();
		System.out.print("m ȣ�� >>> "); 
		op.m();
		System.out.print("k ȣ�� >>> "); 
		op.k();

		container.close();
	}

}
