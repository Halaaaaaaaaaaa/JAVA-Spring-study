package com.ezen.biz;

public class BoseSpeaker implements Speaker {
	
	public BoseSpeaker() {
		System.out.println("<<- BoseSpeaker ��ü ���� ->>");
	}

	@Override
	public void volumeUp() {
		System.out.println("<<- BoseSpeaker : Volume up ->>");
	}
	
	@Override
	public void volumeDown() {
		System.out.println("<<- BoseSpeaker : Volume down ->>");
	}
	
}
