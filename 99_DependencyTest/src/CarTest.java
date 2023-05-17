
public class CarTest {

	public static void main(String[] args) {
		
		//Car c1 = new Car(); �̷��Ը� �ۼ��ؼ� �����ϸ� NullPointException �߻�
		//����� �Է������� �� ����� �Ǻ��� �� �ִ� ��ü�� �����Ǿ� ���� �ʱ� ������ tire�� ��ü�� �������־����
		
		//Car ���� Tire ��ü�� ����ϴ� ��� (1) - ������ ȣ��(Constructor Injection)
		Car c1 = new Car(new Tire());
		c1.t.size = 19;
		System.out.println("Tire�� ������ : " + c1.t.size + "\n");

		//Car ���� Tire ��ü�� ����ϴ� ��� (2) - ������ ȣ��(Constructor Injection)
		Tire t1 = new Tire();
		Car c2 = new Car(t1);
		c2.t.size = 20;
		System.out.println("Tire�� ������ : " + c2.t.size + "\n");

		//Car ���� Tire ��ü�� ����ϴ� ��� (3) - Setter ȣ��(Setter Injection)
		Car c3 = new Car();
		c3.setTire(t1);
		c3.t.size = 22;
		System.out.println("Tire�� ������ : " + c3.t.size);
		
		
	}

}
