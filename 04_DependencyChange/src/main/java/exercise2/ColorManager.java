package exercise2;

public class ColorManager {

	private MyColor color;
	
	public ColorManager() {
		System.out.println("ColorManager ��ü ����");
	}
	
	//�Ű������� �ִ� ������ ����
	public ColorManager(MyColor color) {
		this.color = color;
	}

	public void setColor(MyColor color) {
		this.color = color;
	}
	
	
	public void printColor() {
		this.color.printColor();
	}
	
	
}
