package services;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.github.dockerjava.api.model.Container;

import utils.Docker;

@Service
public class DockerServiceImpl implements DockerService {

	@Override
	public void create(String container, String networkMode) {
		Docker.client().createContainerCmd(container)
			.withNetworkDisabled(false)
			.withNetworkMode(networkMode)
			.exec();
	}

	@Override
	public void remove(String container) {
		Docker.client().removeContainerCmd(container).exec();
	}

	@Override
	public void pause(String container) {
		Docker.client().pauseContainerCmd(container).exec();
	}

	@Override
	public void unpause(String container) {
		Docker.client().unpauseContainerCmd(container).exec();
	}

	@Override
	public void start(String container) {
		try {
			Runtime.getRuntime().exec("docker start " + container).waitFor();
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void stop(String container) {
		Docker.client().stopContainerCmd(container).exec();
	}

	@Override
	public List<Container> listContainers() {
		return Docker.client().listContainersCmd().withShowAll(true).exec();
	}
}