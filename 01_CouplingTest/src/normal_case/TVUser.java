package normal_case;

public class TVUser {
	
	//TVUser는 SamsungTV, LgTV에 의존성을 가짐
	public static void main(String[] args) {
		
		/*
		//삼성TV 클래스 사용하여 구현
		SamsungTV tv = new SamsungTV();
			tv.powerOn();
			tv.powerOff();
			tv.volumeUp();
			tv.volumeDown();
		*/
		
		//LGTV 클래스 사용하여 구현
		//TV 객체를 samsungTV에서 LgTV로 바꿀 경우 혹은 메소드명을 바꿀 경우
		//객체 생성과 메소드 호출 모두 프로그래머가 변경해야함
		LgTV tv = new LgTV();
			tv.turnOn();
			tv.turnOff();
			tv.soundUp();
			tv.soundDown();

	}

}
