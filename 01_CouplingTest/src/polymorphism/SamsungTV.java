package polymorphism;

public class SamsungTV implements TV {

	@Override
	public void powerOn() {
		System.out.println("Samsung TV - Power on");

	}

	@Override
	public void powerOff() {
		System.out.println("Samsung TV - Power off");

	}

	@Override
	public void volumeUp() {
		System.out.println("Samsung TV - Volume up");

	}

	@Override
	public void volumeDown() {
		System.out.println("Samsung TV - Volume down");

	}

}
