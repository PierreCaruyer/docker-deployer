package services;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;

import utils.Docker;

@Service
public class DockerServiceImpl implements DockerService {

	public void create(String container) {
		Docker.client().createContainerCmd(container).exec();
	}

	public void remove(String container) {
		Docker.client().removeContainerCmd(container).exec();
	}

	public void pause(String container) {
		Docker.client().pauseContainerCmd(container).exec();
	}

	public void unpause(String container) {
		Docker.client().unpauseContainerCmd(container).exec();
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

	public List<Container> listContainers() {
		return docker.listContainersCmd().withShowAll(true).exec();
	}
}