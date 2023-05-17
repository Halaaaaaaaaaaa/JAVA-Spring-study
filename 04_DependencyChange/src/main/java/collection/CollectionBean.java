package collection;

import java.util.*;

public class CollectionBean {

	private List<String> addressList;
	private Set<String> movieSet;
	private Map<String, String> prefList;
	private Properties propList;
	
	public CollectionBean() {
		System.out.println("<<- CollectionBean °´Ã¼ »ý¼º ->>");
	}

	public List<String> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<String> addressList) {
		this.addressList = addressList;
	}

	public Set<String> getMovieSet() {
		return movieSet;
	}

	public void setMovieSet(Set<String> movieSet) {
		this.movieSet = movieSet;
	}

	public Map<String, String> getPrefList() {
		return prefList;
	}

	public void setPrefList(Map<String, String> prefList) {
		this.prefList = prefList;
	}

	public Properties getPropList() {
		return propList;
	}

	public void setPropList(Properties propList) {
		this.propList = propList;
	}
	

}
