package com.ezen.ex1;

import org.springframework.stereotype.Service;

/*
 * ����Ͻ� ó�� ����
 */
@Service("opBean")
public class Operation {
	public void message() {
		System.out.println("message() �޼ҵ� ȣ���.");
	}
	
	public int m() {
		System.out.println("m() �޼ҵ� ȣ���.");
		return 2;
	}
	
	public int k() {
		System.out.println("k() �޼ҵ� ȣ���.");
		return 3;
	}
	
	public void throwException() {
		throw new RuntimeException("���� �߻�...");
	}
}
