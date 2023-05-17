package polymorphism;

public class TVUser {

	public static void main(String[] args) {
		//다형성을 이용한 결합도를 낮추는 방법
		//interface 이용
		
		//TV tv = new SamsungTV();
		TV tv = new LgTV();
			tv.powerOn();
			tv.powerOff();
			tv.volumeUp();
			tv.volumeDown();
			
	}

}
