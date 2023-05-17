package design_pattern;

public class TVUser {

	public static void main(String[] args) {
		
		BeanFactory factory = new BeanFactory();

		//getBean으로 samsung 혹은 lg 둘 중 어떤 값이 넘어올지 모르니까 타입을 부모타입인 TV 타입으로 지정
		TV tv = (TV)factory.getBean(args[0]);
				
		tv.powerOn(); 
		tv.volumeUp(); 
		tv.volumeDown(); 
		tv.powerOff();

	}

}
