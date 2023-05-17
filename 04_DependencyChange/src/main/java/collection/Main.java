package collection;

import java.util.*;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext4.xml");
		
		CollectionBean bean = (CollectionBean)container.getBean("collectionBean");
		
		System.out.println("\n===============[ List : Address ]===============");
		List<String> addrList = bean.getAddressList();
		
		//list ������ Ȯ��. addrList �������� String type�� addr�� �����ϰڴ�
		for( String addr : addrList ) {
			System.out.println(addr);
		}
		
		System.out.println("\n================[ Set : Movie ]=================");
		Set<String> movieSet = bean.getMovieSet();
		Iterator<String> movie = movieSet.iterator();
		
		//set ������ Ȯ��. movieSet �������� String type�� movie�� �����ϰڴ�
		while(movie.hasNext()) {
			System.out.println(movie.next());
		}
		
		System.out.println("\n===============[ Map : Prefect ]================");
		Map<String, String> scoreMap = bean.getPrefList();
		Set<String> keySet = scoreMap.keySet();
		
		for( String key : keySet ) {
			System.out.printf("- %s : %s��\n", key, scoreMap.get(key));
		}
		
		System.out.println("\n================[ Properties ]==================");
		Properties props = bean.getPropList();
		LinkedHashMap<String, String> prop = new LinkedHashMap<String, String>((Map)bean.getPropList());
		
		for (Map.Entry<String, String> entry : prop.entrySet()) {
		    System.out.printf("- %s : %s\n", entry.getKey(), entry.getValue());
		}
		
		/*
		System.out.println("\n================[ Properties ]==================");
		Properties props = bean.getPropList();
		Set<String> prop = (Set)(props.keySet());
		
		for( String user : prop ) {
			System.out.printf("- %s : %s\n", user, props.get(user));
		}
		*/
		
		container.close();
	}
}
