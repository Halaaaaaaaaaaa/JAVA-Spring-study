package exercise;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainTest_spring {

	public static void main(String[] args) {
		
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext2.xml");
		
		Player player = (Player)container.getBean("player");
			player.usePlayerWeapon();
		
		Weapon weapon = (Weapon)container.getBean("gun");
			player.setWeapon(weapon);
			

		container.close();
	}
}
