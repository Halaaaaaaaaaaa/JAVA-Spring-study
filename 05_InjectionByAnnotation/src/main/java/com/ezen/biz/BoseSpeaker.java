package com.ezen.biz;

import org.springframework.stereotype.Component;

@Component("bose")
public class BoseSpeaker implements Speaker {
	
	public BoseSpeaker() {
		System.out.println("<<- Bose Speaker °´Ã¼ »ý¼º ->>");
	}
	
	@Override
	public void volumeUp() {
		System.out.println("<<- Bose Speaker Volume up ->>");
	}
	
	@Override
	public void volumeDown() {
		System.out.println("<<- Bose Speaker Volume down ->>");
	}

}
