package design_pattern;

//TvUser Ŭ�������� ��û�� ��ü�� �����Ͽ� �����ϴ� Ŭ����
public class BeanFactory {

	public Object getBean(String beanName) {
		
		//samsung = lg = Object type
		if(beanName.equals("samsung")) { 
			return new SamsungTV(); 
		} else if(beanName.equals("lg")) { 
			return new LgTV(); 
		}
		return null;
		
	}
}
