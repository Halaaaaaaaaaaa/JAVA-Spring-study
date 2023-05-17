package com.ezen.biz;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv")
public class SamsungTV implements TV {
	
	//@Autowired ������ Ÿ���� ��ü�� �����̳ʿ��� ã�� ������ ����
	//@Qualifier("jbl")
	@Resource(name="bose")
	private Speaker speaker;
	private int price;
	
	public SamsungTV() {
		System.out.println("SamsungTV ��ü ����");
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
		System.out.println("-- ��ü ���� �� �ʱ�ȭ �۾� ó�� --");
		
	}
	
	public void destroyMethod() {
		System.out.println("-- ��ü ���� �� ó���� �۾� --");
	}
	
	@Override
	public void powerOn() {
		System.out.println("SamsungTV -- ������ �մϴ�.");
		System.out.println("price = " + price);
	}

	@Override
	public void powerOff() {
		System.out.println("SamsungTV -- ������ ���ϴ�.");
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
