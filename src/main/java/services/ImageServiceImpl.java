package services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Image;

import utils.DummyCallback;

@Service
public class ImageServiceImpl implements ImageService{

	DockerClient docker;
	
	@Override
	public void pull(String image) {
		docker.pullImageCmd(image).exec(new DummyCallback());
	}

	@Override
	public List<Image> list() {
		return docker.listImagesCmd().exec();
	}
	
	@Override
	public void remove(String image) {
		docker.removeImageCmd(image).exec();
	}
}
