package services;

import java.util.List;

import com.github.dockerjava.api.model.Network;

public interface NetworkService {

	public List<Network> list();
	
	public void create(String network);
	
	public void remove(String network);
	
	public void connect(String network, String container);
	
	public void disconnect(String network, String container);
}
