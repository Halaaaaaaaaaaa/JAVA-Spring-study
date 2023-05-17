package com.ezen.biz.service;

import org.springframework.stereotype.Service;

@Service("opBean")
public class OperationImpl implements Operation{
	
	public void message() {
		System.out.println("message() method 호출\n");
	}
	
	public int m() {
		
		System.out.println("m() 메소드 호출됨 \n");
		
		return 18;
	}
	
	public int k() {
		System.out.println("k() 메소드 호출됨 \n");
		return 19;
	}
	
	public void throwExeption() {
		throw new RuntimeException("예외 발생");
	}

}
