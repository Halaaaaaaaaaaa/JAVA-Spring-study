
public class CarTest {

	public static void main(String[] args) {
		
		//Car c1 = new Car(); 이렇게만 작성해서 실행하면 NullPointException 발생
		//사이즈를 입력하지만 그 사이즈를 판별할 수 있는 객체가 설정되어 있지 않기 때문에 tire의 객체도 생성해주어야함
		
		//Car 내의 Tire 객체를 사용하는 방법 (1) - 생성자 호출(Constructor Injection)
		Car c1 = new Car(new Tire());
		c1.t.size = 19;
		System.out.println("Tire의 사이즈 : " + c1.t.size + "\n");

		//Car 내의 Tire 객체를 사용하는 방법 (2) - 생성자 호출(Constructor Injection)
		Tire t1 = new Tire();
		Car c2 = new Car(t1);
		c2.t.size = 20;
		System.out.println("Tire의 사이즈 : " + c2.t.size + "\n");

		//Car 내의 Tire 객체를 사용하는 방법 (3) - Setter 호출(Setter Injection)
		Car c3 = new Car();
		c3.setTire(t1);
		c3.t.size = 22;
		System.out.println("Tire의 사이즈 : " + c3.t.size);
		
		
	}

}
