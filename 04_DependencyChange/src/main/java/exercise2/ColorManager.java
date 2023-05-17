package exercise2;

public class ColorManager {

	private MyColor color;
	
	public ColorManager() {
		System.out.println("ColorManager 객체 생성");
	}
	
	//매개변수가 있는 생성자 주입
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
