package design_pattern;

public class TVUser {

	public static void main(String[] args) {
		
		BeanFactory factory = new BeanFactory();

		//getBean���� samsung Ȥ�� lg �� �� � ���� �Ѿ���� �𸣴ϱ� Ÿ���� �θ�Ÿ���� TV Ÿ������ ����
		TV tv = (TV)factory.getBean(args[0]);
				
		tv.powerOn(); 
		tv.volumeUp(); 
		tv.volumeDown(); 
		tv.powerOff();

	}

}
