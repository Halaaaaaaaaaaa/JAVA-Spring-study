package com.ezen.biz;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		
		//1. 스프링 컨테이너 구동
		//환경 설정 파일인 applicationContext.xml을 로딩하여 스프링 컨테이너 중 하나인 GenericXmlApplicationContext를 구동
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		//2. 스프링 컨체이너에게 필요한 객체 요청 = Lookup
		//applicationContext.xml에서 정의한 TV 객체를 갖고 온다
		TV tv = (TV)container.getBean("tv");
			tv.powerOn();
			tv.volumeUp();
			tv.volumeDown();
			tv.powerOff();
			
		container.close();
	}

}
