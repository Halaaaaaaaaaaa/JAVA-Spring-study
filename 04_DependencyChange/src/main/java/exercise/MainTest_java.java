package exercise;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainTest_java {

	public static void main(String[] args) {
		
		Weapon gun = new Gun();
		Weapon knife = new Knife();
		Weapon spike = new Spike();
		
		Player player = new Player(spike);
		
		player.usePlayerWeapon();
		
	}
}
