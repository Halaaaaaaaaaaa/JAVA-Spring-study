package com.ezen.ex1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

//@Component
public class Ex1Client {

	/*
	private static Operation op;

	@Autowired
	public Ex1Client(Operation op) {
		this.op = op;
	}
	*/
	public static void main(String[] args) {
		AbstractApplicationContext factory = 
				new GenericXmlApplicationContext("applicationContext.xml");
		Operation op = (Operation)factory.getBean("opBean");
		
		System.out.println("msg() 호출 >>>");
		op.message();
		
		System.out.println("m() 호출 >>>");
		op.m();
		
		System.out.println("k() 호출 >>>");
		op.k();
		
		factory.close();
	}

}
