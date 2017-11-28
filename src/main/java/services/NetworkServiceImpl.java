package services;

import java.util.List;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Network;

public class NetworkServiceImpl implements NetworkService {

	DockerClient docker;

	@Override
	public void create(String network) {
		docker.createNetworkCmd().withName(network).exec();
	}
	
	@Override
	public void remove(String network) {
		docker.removeNetworkCmd(network).exec();
	}
	
	@Override
	public void connect(String network, String container) {
		docker.connectToNetworkCmd()
			.withNetworkId(network)
			.withContainerId(container)
			.exec();
	}
	
	@Override
	public void disconnect(String network, String container) {
		docker.disconnectFromNetworkCmd()
			.withNetworkId(network)
			.withContainerId(container)
			.exec();
	}
	
	@Override
	public List<Network> list() {
		return docker.listNetworksCmd().exec();
	}

}
