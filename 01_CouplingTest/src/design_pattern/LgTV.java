package design_pattern;

public class LgTV implements TV {

	@Override
	public void powerOn() {
		System.out.println("LG TV - Turn on");

	}

	@Override
	public void powerOff() {
		System.out.println("LG TV - Turn off");

	}

	@Override
	public void volumeUp() {
		System.out.println("LG TV - Sound up");

	}

	@Override
	public void volumeDown() {
		System.out.println("LG TV - Sound down");

	}

}
