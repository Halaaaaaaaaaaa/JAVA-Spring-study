package polymorphism;

public class TVUser {

	public static void main(String[] args) {
		//�������� �̿��� ���յ��� ���ߴ� ���
		//interface �̿�
		
		//TV tv = new SamsungTV();
		TV tv = new LgTV();
			tv.powerOn();
			tv.powerOff();
			tv.volumeUp();
			tv.volumeDown();
			
	}

}
