package services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.github.dockerjava.api.model.Network;

import utils.Docker;

@Service
public class NetworkServiceImpl implements NetworkService {

	@Override
	public void create(String network) {
		Docker.client().createNetworkCmd().withName(network).exec();
	}
	
	@Override
	public void remove(String network) {
		Docker.client().removeNetworkCmd(network).exec();
	}
	
	@Override
	public void connect(String network, String container) {
		Docker.client().connectToNetworkCmd()
			.withNetworkId(network)
			.withContainerId(container)
			.exec();
	}
	
	@Override
	public void disconnect(String network, String container) {
		Docker.client().disconnectFromNetworkCmd()
			.withNetworkId(network)
			.withContainerId(container)
			.exec();
	}
	
	@Override
	public List<Network> list() {
		return Docker.client().listNetworksCmd().exec();
	}
	
	@Override
	public List<List<String>> listConnectedContainers() {
		List<List<String>> connectedContainersIds = new ArrayList<>();
		List<Network> networks = list();
		for(int i = 0; i < networks.size(); i++) {
			Network n = networks.get(i);
			System.out.println("Network " + n.getName());
			String[] networkKeySet = n.getContainers().keySet().toArray(new String[n.getContainers().keySet().size()]);
			for(String key : networkKeySet) {
				String containerId = n.getContainers().get(key).getEndpointId();
				System.out.println("\tContainer " + containerId);
				connectedContainersIds.get(i).add(containerId);
			}
		}
		return connectedContainersIds;
	}

}
