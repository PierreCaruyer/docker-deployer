package services;

import java.util.List;

import com.github.dockerjava.api.model.Container;

public interface ContainerService {
	
	public void create(String container, String networkMode);

	public void remove(String container);

	public void pause(String container);

	public void unpause(String container);

	public void start(String container);

	public void stop(String container);
	
	public void commit(String container);
	
	public List<Container> listContainers();
}
