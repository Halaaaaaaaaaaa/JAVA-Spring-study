package com.ezen.biz;

import org.springframework.stereotype.Component;

@Component("jbl")
public class JBLSpeaker implements Speaker {

	public JBLSpeaker() {
		System.out.println("<<- JBL Speaker °´Ã¼ »ý¼º ->>");
	}

	@Override
	public void volumeUp() {
		System.out.println("<<- JBL Speaker Volume up ->>");
	}

	@Override
	public void volumeDown() {
		System.out.println("<<- JBL Speaker Volume down ->>");

	}

}
