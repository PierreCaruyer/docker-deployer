package services;

import java.util.List;

public interface NetworkService {

	public void create(String network, String driver);
	
	public void remove(String network);
	
	public void connect(String network, String container);
	
	public void disconnect(String network, String container);
	
	public List<utils.Network> list();
}
