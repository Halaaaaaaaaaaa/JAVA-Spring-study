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
		
		//list 데이터 확인. addrList 변수들을 String type의 addr에 주입하겠다
		for( String addr : addrList ) {
			System.out.println(addr);
		}
		
		System.out.println("\n================[ Set : Movie ]=================");
		Set<String> movieSet = bean.getMovieSet();
		Iterator<String> movie = movieSet.iterator();
		
		//set 데이터 확인. movieSet 변수들을 String type의 movie에 주입하겠다
		while(movie.hasNext()) {
			System.out.println(movie.next());
		}
		
		System.out.println("\n===============[ Map : Prefect ]================");
		Map<String, String> scoreMap = bean.getPrefList();
		Set<String> keySet = scoreMap.keySet();
		
		for( String key : keySet ) {
			System.out.printf("- %s : %s점\n", key, scoreMap.get(key));
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
