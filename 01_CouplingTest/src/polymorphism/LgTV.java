package polymorphism;

public class LgTV implements TV {

	@Override
	public void powerOn() {
		System.out.println("LG TV - Power on");

	}

	@Override
	public void powerOff() {
		System.out.println("LG TV - Power off");

	}

	@Override
	public void volumeUp() {
		System.out.println("LG TV - Volume up");

	}

	@Override
	public void volumeDown() {
		System.out.println("LG TV - Volume down");

	}

}
