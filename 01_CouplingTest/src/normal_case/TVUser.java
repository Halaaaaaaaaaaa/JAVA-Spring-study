package normal_case;

public class TVUser {
	
	//TVUser�� SamsungTV, LgTV�� �������� ����
	public static void main(String[] args) {
		
		/*
		//�ＺTV Ŭ���� ����Ͽ� ����
		SamsungTV tv = new SamsungTV();
			tv.powerOn();
			tv.powerOff();
			tv.volumeUp();
			tv.volumeDown();
		*/
		
		//LGTV Ŭ���� ����Ͽ� ����
		//TV ��ü�� samsungTV���� LgTV�� �ٲ� ��� Ȥ�� �޼ҵ���� �ٲ� ���
		//��ü ������ �޼ҵ� ȣ�� ��� ���α׷��Ӱ� �����ؾ���
		LgTV tv = new LgTV();
			tv.turnOn();
			tv.turnOff();
			tv.soundUp();
			tv.soundDown();

	}

}
