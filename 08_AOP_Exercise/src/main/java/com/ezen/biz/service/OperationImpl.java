package com.ezen.biz.service;

import org.springframework.stereotype.Service;

@Service("opBean")
public class OperationImpl implements Operation{
	
	public void message() {
		System.out.println("message() method ȣ��\n");
	}
	
	public int m() {
		
		System.out.println("m() �޼ҵ� ȣ��� \n");
		
		return 18;
	}
	
	public int k() {
		System.out.println("k() �޼ҵ� ȣ��� \n");
		return 19;
	}
	
	public void throwExeption() {
		throw new RuntimeException("���� �߻�");
	}

}
