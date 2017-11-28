package utils;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;

@Singleton
public class Docker {

	private static com.github.dockerjava.core.DefaultDockerClientConfig config;
	private static com.github.dockerjava.api.DockerClient docker;
	
	@PostConstruct
	public void init() {
		config = DefaultDockerClientConfig.createDefaultConfigBuilder().build();
		docker = DockerClientBuilder.getInstance(config).build();
	}

	public static DockerClient client() {
		return docker;
	}
}
