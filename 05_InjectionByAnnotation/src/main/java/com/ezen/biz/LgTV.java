package com.ezen.biz;

					//TV�� �θ���
public class LgTV implements TV {

	@Override
	public void powerOn() {
		System.out.println("LgTV -- ������ �մϴ�.");
	}

	@Override
	public void powerOff() {
		System.out.println("LgTV -- ������ ���ϴ�.");
	}

	@Override
	public void volumeUp() {
		System.out.println("LgTV -- ������ �ø��ϴ�.");
	}

	@Override
	public void volumeDown() {
		System.out.println("LgTV -- ������ �����ϴ�.");
	}
}
