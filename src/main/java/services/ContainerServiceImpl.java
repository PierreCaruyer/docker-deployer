package services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.dockerjava.api.model.Container;

import utils.Docker;

@Service
public class ContainerServiceImpl implements ContainerService {

	@Override
	public void create(String container, String networkMode, String cmd) {
		Docker.client().createContainerCmd(container)
			.withNetworkMode(networkMode)
			.withNetworkDisabled(false)
			.withAttachStdin(true)
			.withTty(true)
			.withCmd(cmd)
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
		Docker.client().startContainerCmd(container).exec();
	}

	@Override
	public void stop(String container) {
		Docker.client().stopContainerCmd(container).exec();
	}

	@Override
	public void commit(String container) {
		Docker.client().commitCmd(container).withTag("myTag").exec();
	}
	
	@Override
	public List<Container> listContainers() {
		return Docker.client().listContainersCmd().withShowAll(true).exec();
	}
}