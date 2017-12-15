package services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.github.dockerjava.api.model.Network;

import utils.Docker;

@Service
public class NetworkServiceImpl implements NetworkService {

	@Override
	public void create(String network, String driver) {
		Docker.client().createNetworkCmd().withName(network).withDriver(driver).exec();
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
	public List<utils.Network> list() {
		List<utils.Network> networks = new ArrayList<>();
		for(Network n : Docker.client().listNetworksCmd().exec()) {
			utils.Network network = new utils.Network(n.getId(), n.getName());
			for(String s : n.getContainers().keySet().toArray(new String[n.getContainers().keySet().size()]))
				network.addContainer(s.substring(0, 12));
			networks.add(network);
		}
		return networks;
	}
}
