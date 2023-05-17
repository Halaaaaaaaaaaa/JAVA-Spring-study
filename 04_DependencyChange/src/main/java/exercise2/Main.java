package exercise2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		MyColor blue = new BlueColor();
		MyColor yellow = new YellowColor();
		
		ColorManager cm = new ColorManager(blue);
		ColorManager cm2 = new ColorManager(yellow);
		
		cm.printColor();
		cm2.printColor();
		
		//컨테이너 생성
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext3.xml");
		
		ColorManager cm3 = (ColorManager)container.getBean("colorManager");
		cm3.printColor();
		
	}

}
