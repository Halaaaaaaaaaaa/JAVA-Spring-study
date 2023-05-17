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
			tv.powerOff();
			tv.volumeUp();
			tv.volumeDown();
			
		//prototype이면 <bean>이 요청될 때마다 객체를 계속 생성하고 close를 안하기 때문에 destroy 실행 안함
		//singleton이면 <bean>이 요청될 때 하나의 객체만 생성하고 close를 해주기 때문에 destroy 실행
		TV tv1 = (TV)container.getBean("tv");
		TV tv2 = (TV)container.getBean("tv");
			
		container.close();
	}

}
