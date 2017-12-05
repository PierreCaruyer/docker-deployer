package utils;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;

public class Docker {

	private static DefaultDockerClientConfig config = DefaultDockerClientConfig.createDefaultConfigBuilder().build();
	private static DockerClient docker = DockerClientBuilder.getInstance(config).build();
	
	public static DockerClient client() {
		return docker;
	}
}
