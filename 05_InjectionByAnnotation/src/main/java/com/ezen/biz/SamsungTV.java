package com.ezen.biz;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv")
public class SamsungTV implements TV {
	
	//@Autowired 지정된 타입의 객체를 컨테이너에서 찾아 의존성 주입
	//@Qualifier("jbl")
	@Resource(name="bose")
	private Speaker speaker;
	private int price;
	
	public SamsungTV() {
		System.out.println("SamsungTV 객체 생성");
	}
	
	public SamsungTV(Speaker speaker ) {
		this.speaker = speaker;
	}

	public SamsungTV(Speaker speaker, int price) {
		this.speaker = speaker;
		this.price = price;
	}

	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void initMethod() {
		System.out.println("-- 객체 생성 전 초기화 작업 처리 --");
		
	}
	
	public void destroyMethod() {
		System.out.println("-- 객체 삭제 전 처리할 작업 --");
	}
	
	@Override
	public void powerOn() {
		System.out.println("SamsungTV -- 전원을 켭니다.");
		System.out.println("price = " + price);
	}

	@Override
	public void powerOff() {
		System.out.println("SamsungTV -- 전원을 끕니다.");
	}

	@Override
	public void volumeUp() {
		speaker.volumeUp();
	}

	@Override
	public void volumeDown() {
		speaker.volumeDown();
	}

}
