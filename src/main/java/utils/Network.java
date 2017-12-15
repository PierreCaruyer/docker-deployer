package utils;

import java.util.ArrayList;
import java.util.List;

public class Network {
	private List<String> containers;
	private String id;
	private String name;
	
	public Network(String id, String name) {
		this.id = id.substring(0, 12);
		this.name = name;
		containers = new ArrayList<>();
	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void addContainer(String container) {
		containers.add(container);
	}
	
	public List<String> connectedContainers() {
		return containers;
	}
}
