package com.ezen.biz;

public class SamsungTV implements TV {

	public SamsungTV() {
		System.out.println("SamsungTV ��ü ����");
	}
	
	public void initMethod() {
		System.out.println("<< ��ü ���� �� �ʱ�ȭ �۾� ó�� >>");
	}
	
	public void destroyMethod() {
		System.out.println("<< ��ü ���� �� ó���� �۾� >>");
	}
	
	@Override
	public void powerOn() {
		System.out.println("Samsung TV - Power on");
	}

	@Override
	public void powerOff() {
		System.out.println("Samsung TV - Power off");
	}

	@Override
	public void volumeUp() {
		System.out.println("Samsung TV - Volume up");
	}

	@Override
	public void volumeDown() {
		System.out.println("Samsung TV - Volume down");
	}

}
