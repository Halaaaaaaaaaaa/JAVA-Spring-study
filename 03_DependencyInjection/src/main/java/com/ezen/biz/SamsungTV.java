package com.ezen.biz;

public class SamsungTV implements TV {
	
	private BoseSpeaker speaker;
	private int price;

	//매개변수가 있는 생성자 주입  Source > General Constructor Using Fields
	public SamsungTV(BoseSpeaker speaker) {
		this.speaker = speaker;
	}

	//매개변수가 있는 생성자 주입
	public SamsungTV(BoseSpeaker speaker, int price) {
		super();
		this.speaker = speaker;
		this.price = price;
	}

	public SamsungTV() {
		System.out.println("SamsungTV 객체 생성");
	}
	
	public void initMethod() {
		System.out.println("<< 객체 생성 전 초기화 작업 처리 >>");
	}
	
	public void destroyMethod() {
		System.out.println("<< 객체 삭제 전 처리할 작업 >>");
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
	//전역변수 speaker를 통해 객체 생성
	public void volumeUp() {
		speaker.volumeUp();
	}

	@Override
	//전역변수 speaker를 통해 객체 생성
	public void volumeDown() {
		speaker.volumeDown();
	}

}
