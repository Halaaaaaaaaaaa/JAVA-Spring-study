package com.ezen.biz;

public class JBLSpeaker implements Speaker {

	public JBLSpeaker() {
		System.out.println("<<- JBLSpeaker °´Ã¼ »ý¼º ->>");
	}
	
	@Override
	public void volumeUp() {
		System.out.println("<<- JBLSpeaker Volume up ->>");
	}

	@Override
	public void volumeDown() {
		System.out.println("<<- JBLSpeaker Volume down ->>");
	}

}
