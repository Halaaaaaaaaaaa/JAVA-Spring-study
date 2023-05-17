package com.ezen.biz;

public class SamsungTV implements TV {
	
	private BoseSpeaker speaker;
	private int price;

	//�Ű������� �ִ� ������ ����  Source > General Constructor Using Fields
	public SamsungTV(BoseSpeaker speaker) {
		this.speaker = speaker;
	}

	//�Ű������� �ִ� ������ ����
	public SamsungTV(BoseSpeaker speaker, int price) {
		super();
		this.speaker = speaker;
		this.price = price;
	}

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
		System.out.println("Samsung TV Price = " + price);
	}

	@Override
	public void powerOff() {
		System.out.println("Samsung TV - Power off");
	}

	@Override
	//�������� speaker�� ���� ��ü ����
	public void volumeUp() {
		speaker.volumeUp();
	}

	@Override
	//�������� speaker�� ���� ��ü ����
	public void volumeDown() {
		speaker.volumeDown();
	}

}
