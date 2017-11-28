package services;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.api.model.Image;
import com.github.dockerjava.api.model.Network;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;

import utils.DummyCallback;

@Service
public class DockerServiceImpl implements DockerService {

	private static DefaultDockerClientConfig config = DefaultDockerClientConfig.createDefaultConfigBuilder().build();
	private static DockerClient docker = DockerClientBuilder.getInstance(config).build();

	public void create(String container) {
		docker.createContainerCmd(container).exec();
	}

	public void remove(String container) {
		docker.removeContainerCmd(container).exec();
	}

	public void pause(String container) {
		docker.pauseContainerCmd(container).exec();
	}

	public void unpause(String container) {
		docker.unpauseContainerCmd(container).exec();
	}

	public void start(String container) {
		try {
			Runtime.getRuntime().exec("docker start " + container).waitFor();
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
	}

	public void stop(String container) {
		docker.stopContainerCmd(container).exec();
	}

	public List<Image> listImages() {
		return docker.listImagesCmd().exec();
	}

	public void pullImage(String image) {
		docker.pullImageCmd(image).withTag("latest").exec(new DummyCallback());
	}
	
	public void deleteImage(String image) {
		docker.removeImageCmd(image).exec();
	}
	
	public void createNetwork(String network) {
		docker.createNetworkCmd().withName(network).exec();
	}
	
	public void connect(String network, String container) {
		docker.connectToNetworkCmd()
			.withNetworkId(network)
			.withContainerId(container)
			.exec();
	}
	
	public void disconnect(String network, String container) {
		docker.disconnectFromNetworkCmd()
			.withNetworkId(network)
			.withContainerId(container)
			.exec();
	}
	
	public void removeNetwork(String network) {
		docker.removeNetworkCmd(network).exec();
	}
	
	public List<Network> listNetworks() {
		return docker.listNetworksCmd().exec();
	}

	public List<Container> listContainers() {
		return docker.listContainersCmd().withShowAll(true).exec();
	}
}