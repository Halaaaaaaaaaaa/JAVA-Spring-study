package exercise;

public class Player {

	private Weapon weapon;

	public Player() {
		System.out.println("Player ��ü ����");
	}
	
	//�Ű������� �ִ� ������ ����  Source > General Constructor Using Fields
	public Player(Weapon weapon) {
		this.weapon = weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	
	public void usePlayerWeapon() {
		weapon.useWeapon(); 
	}

	public Player(Gun gun, Knife knife, Spike spike) {
		super();
		this.weapon = gun;
	}

		
}
